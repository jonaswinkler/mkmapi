package de.jpwinkler.mkmapi;

import com.google.gson.GsonBuilder;
import com.google.gson.annotations.Expose;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.HmacAlgorithms;
import org.apache.commons.codec.digest.HmacUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

public class MKMAuth {

    public static MKMAuth loadFromFile(String filename) throws IOException {
        try (InputStreamReader reader = new InputStreamReader(new FileInputStream(filename))) {
            return new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create().fromJson(reader, MKMAuth.class);
        }
    }

    @Expose
    private String appToken;
    @Expose
    private String appSecret;
    @Expose
    private String accessToken;
    @Expose
    private String accessTokenSecret;

    private Random random;

    public String getAppToken() {
        return appToken;
    }

    public void setAppToken(String appToken) {
        this.appToken = appToken;
    }

    public String getAppSecret() {
        return appSecret;
    }

    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getAccessTokenSecret() {
        return accessTokenSecret;
    }

    public void setAccessTokenSecret(String accessTokenSecret) {
        this.accessTokenSecret = accessTokenSecret;
    }

    public MKMAuth(String appToken, String appSecret, String accessToken, String accessTokenSecret) {
        this.appToken = appToken;
        this.appSecret = appSecret;
        this.accessToken = accessToken;
        this.accessTokenSecret = accessTokenSecret;

        random = new Random();
    }

    public MKMAuth() {
        random = new Random();
        appToken = "";
        appSecret = "";
        accessToken = "";
        accessTokenSecret = "";
    }

    private Map<String, String> parseQueryString(String query) {
        Map<String, String> result = new HashMap<>();

        for (String parameter : query.split("&")) {
            result.put(parameter.split("=")[0], parameter.split("=")[1]);
        }

        return result;
    }

    public String getAuthorizationHeader(String method, String requestUrl) {
        try {
            Map<String, String> headerParams;

            byte[] bytes = new byte[10];
            random.nextBytes(bytes);

            headerParams = new HashMap<>();
            headerParams.put("oauth_consumer_key", appToken);
            headerParams.put("oauth_token", accessToken);
            headerParams.put("oauth_nonce", Hex.encodeHexString(bytes));
            headerParams.put("oauth_timestamp", String.valueOf(System.currentTimeMillis()));
            headerParams.put("oauth_signature_method", "HMAC-SHA1");
            headerParams.put("oauth_version", "1.0");

            URL uri = new URL(requestUrl);
            String baseUrl = uri.getProtocol() + "://" + uri.getHost() + uri.getPath();

            headerParams.put("realm", baseUrl);

            StringBuilder baseStringBuilder = new StringBuilder();

            baseStringBuilder.append(method.toUpperCase());
            baseStringBuilder.append("&");
            baseStringBuilder.append(URLEncoder.encode(baseUrl, "UTF-8"));
            baseStringBuilder.append("&");

            if (uri.getQuery() != null) {
                Map<String, String> queryParameters = parseQueryString(uri.getQuery());
                headerParams.putAll(queryParameters);
            }

            String paramString = headerParams.keySet()
                    .stream()
                    .filter(p -> !"realm".equals(p))
                    .sorted()
                    .map(p -> p + "=" + headerParams.get(p)).collect(Collectors.joining("&"));

            baseStringBuilder.append(URLEncoder.encode(paramString, "UTF-8"));

            String signatureKey = URLEncoder.encode(appSecret, "UTF-8") + "&" + URLEncoder.encode(accessTokenSecret, "UTF-8");

            String oauthSignature = new String(Base64.encodeBase64(new HmacUtils(HmacAlgorithms.HMAC_SHA_1, signatureKey).hmac(baseStringBuilder.toString())));

            headerParams.put("oauth_signature", oauthSignature);

            return "OAuth " + headerParams.entrySet().stream().map(e -> e.getKey() + "=\"" + e.getValue() + "\"").collect(Collectors.joining(", "));
        } catch (UnsupportedEncodingException | MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
