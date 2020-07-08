package de.jpwinkler.mkmapi.impl;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import javax.ws.rs.core.GenericType;
import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class RequestCache {

    private static final Logger LOGGER = Logger.getLogger(RequestCache.class.getName());

    private class Entry {
        String content;
        LocalDateTime expirationDate;
    }

    private static class LocalDateTimeSerializer implements JsonSerializer<LocalDateTime> {
        @Override
        public JsonElement serialize(LocalDateTime src, Type typeOfSrc, JsonSerializationContext context) {
            return new JsonPrimitive(DateTimeFormatter.ISO_LOCAL_DATE_TIME.format(src));
        }
    }

    private static class LocalDateTimeDeserializer implements JsonDeserializer<LocalDateTime> {

        @Override
        public LocalDateTime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return LocalDateTime.parse(json.getAsString(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        }
    }


    private Map<String, Entry> cache = new HashMap<>();
    private Gson gson;
    private boolean isDirty = false;
    private int changesSinceLastSave = 0;
    private String filename;

    public RequestCache() {
        gson = new GsonBuilder()
                .setPrettyPrinting()
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeSerializer())
                .registerTypeAdapter(LocalDateTime.class, new LocalDateTimeDeserializer())
                .create();
    }

    public synchronized <T> T get(String url, String method, Object requestObject, Class<T> responseClass) {
        String key = makeKey(url, method, requestObject);
        if (cache.containsKey(key) && cache.get(key).expirationDate.isAfter(LocalDateTime.now())) {
            return new Gson().fromJson(cache.get(key).content, responseClass);
        } else if (cache.containsKey(key) && cache.get(key).expirationDate.isBefore(LocalDateTime.now())) {
            cache.remove(key);
            return null;
        } else {
            return null;
        }
    }

    private String makeKey(String url, String method, Object requestObject) {
        String base = method + "|" + url;
        if (requestObject != null) {
            base += "|" + gson.toJson(requestObject);
        }
        return base;
    }

    public synchronized <T> void store(String url, String method, Object requestObject, T responseObject, LocalDateTime expirationDate) {
        Entry e = new Entry();
        e.content = gson.toJson(responseObject);
        e.expirationDate = expirationDate;
        cache.put(makeKey(url, method, requestObject), e);
        isDirty = true;
        changesSinceLastSave += 1;
        if (changesSinceLastSave > 10) {
            LOGGER.info("Cache autosaving...");
            try {
                saveToFile(filename);
            } catch (IOException ioException) {
                LOGGER.warning("Cache autosave failed with IOException: " + ioException.getMessage());
            }
        }
    }

    public synchronized void loadFromFile(String filename) throws IOException {
        try (InputStreamReader reader = new InputStreamReader(new GZIPInputStream(new FileInputStream(filename)))) {
            cache = gson.fromJson(reader, new TypeToken<Map<String, Entry>>() {}.getType());
            if (cache == null) {
                cache = new HashMap<>();
            }
            isDirty = false;
            this.filename = filename;
        }
    }

    public synchronized void saveToFile() throws IOException {
        saveToFile(this.filename);
    }

    public synchronized void saveToFile(String filename) throws IOException {
        if (isDirty) {
            try (OutputStreamWriter writer = new OutputStreamWriter(new GZIPOutputStream(new FileOutputStream(filename)))) {
                gson.toJson(cache, writer);
                isDirty = false;
                changesSinceLastSave = 0;
            }
        }
    }

}
