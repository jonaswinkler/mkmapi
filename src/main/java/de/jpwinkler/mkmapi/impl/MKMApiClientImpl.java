package de.jpwinkler.mkmapi.impl;

import de.jpwinkler.mkmapi.*;
import de.jpwinkler.mkmapi.response.BadRequestResponse;
import de.jpwinkler.mkmapi.utils.MKMApiClientException;
import de.jpwinkler.mkmapi.utils.RequestLimitExhaustedException;
import de.jpwinkler.mkmapi.utils.UnauthorizedException;
import org.apache.http.client.utils.URIBuilder;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXB;
import java.io.IOException;
import java.io.StringWriter;
import java.lang.reflect.InvocationTargetException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.logging.Logger;

public class MKMApiClientImpl implements MKMApiClient {

    private String host = "api.cardmarket.com";
    private String basePath = "/ws/v2.0";

    public class RequestBuilder {

        private Map<String, Object> parameters = new LinkedHashMap<>();
        private List<String> pathSegments = new ArrayList<>();
        private Object requestObject = null;
        private int cacheDurationInSeconds = 0;
        private boolean useCache = false;

        public RequestBuilder path(String pathSegment) {
            this.pathSegments.add(pathSegment);
            return this;
        }
        public RequestBuilder path(int pathSegment) {
            this.pathSegments.add(Integer.toString(pathSegment));
            return this;
        }

        public RequestBuilder parameter(String key, Object value) {
            this.parameters.put(key, value);
            return this;
        }

        public RequestBuilder requestObject(Object requestObject) {
            this.requestObject = requestObject;
            return this;
        }

        public RequestBuilder withCache(int cacheDurationInSeconds) {
            this.useCache = true;
            this.cacheDurationInSeconds = cacheDurationInSeconds;
            return this;
        }

        public <T> T execute(String method, Class<T> responseClass) throws MKMApiClientException {
            StringBuilder path = new StringBuilder(basePath);
            pathSegments.forEach(s -> path.append("/" + s));
            URI uri = buildURI(path.toString(), parameters);
            return performRequest(uri, method, requestObject, responseClass, useCache, cacheDurationInSeconds);
        }

        public void execute(String method) throws MKMApiClientException {
            execute(method, null);
        }

        public <T> T execute(Class<T> responseClass) throws MKMApiClientException {
            return execute("GET", responseClass);
        }

        public void execute() throws MKMApiClientException {
            execute("GET", null);
        }

    }

    private static final Logger LOGGER = Logger.getLogger(MKMApiClientImpl.class.getName());

    private Client client = ClientBuilder.newClient();

    private MKMAuth auth;

    private int currentRequestCount = -2;
    private int currentRequestMax = -1;

    protected RequestBuilder getRequestBuilder() {
        return new RequestBuilder();
    }

    private AccountManagement accountManagement = new AccountManagementImpl(this);
    private MarketPlaceInformation marketPlaceInformation = new MarketPlaceInformationImpl(this);
    private OrderManagement orderManagement = new OrderManagementImpl(this);
    private ShoppingCartManagement shoppingCartManagement = new ShoppingCartManagementImpl(this);
    private StockManagement stockManagement = new StockManagementImpl(this);
    private WantsListManagement wantsListManagement = new WantsListManagementImpl(this);

    private RequestCache cache = new RequestCache();
    private boolean cacheEnabled;

    @Override
    public AccountManagement getAccountManagement() {
        return accountManagement;
    }

    @Override
    public StockManagement getStockManagement() {
        return stockManagement;
    }

    @Override
    public MarketPlaceInformation getMarketPlaceInformation() {
        return marketPlaceInformation;
    }

    @Override
    public OrderManagement getOrderManagement() {
        return orderManagement;
    }

    @Override
    public ShoppingCartManagement getShoppingCartManagement() {
        return shoppingCartManagement;
    }

    @Override
    public WantsListManagement getWantsListManagement() {
        return wantsListManagement;
    }

    @Override
    public int getCurrentRequestMax() {
        return currentRequestMax;
    }

    @Override
    public int getCurrentRequestCount() {
        return currentRequestCount;
    }

    @Override
    public MKMAuth getAuth() {
        return auth;
    }

    @Override
    public void setAuth(MKMAuth auth) {
        this.auth = auth;
    }

    @Override
    public void loadCache(String filename) throws IOException {
        cache.loadFromFile(filename);
    }

    @Override
    public void enableCache(boolean enabled) {
        this.cacheEnabled = enabled;
    }

    @Override
    public void saveCache() throws IOException {
        cache.saveToFile();
    }

    @Override
    public void saveCache(String filename) throws IOException {
        cache.saveToFile(filename);
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    private URI buildURI(String path, Map<String, Object> parameters) {
        URIBuilder builder = new URIBuilder();
        builder.setScheme("https");
        builder.setHost(host);
        builder.setPath(path);

        if (parameters != null) {
            parameters.entrySet().stream()
                    .filter(e -> e.getValue() != null)
                    .forEach(e -> builder.setParameter(e.getKey(), String.valueOf(e.getValue())));
        }

        URI uri = null;
        try {
            uri = builder.build();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return uri;
    }

    private <S,T> T performRequest(URI uri, String method, S requestObject, Class<T> responseClass, boolean useCache, int cacheDurationInSeconds) throws MKMApiClientException {

        LOGGER.info("Request " + method + " " + uri.toString());

        if (useCache && cacheEnabled) {
            T cachedResponse = cache.get(uri.toString(), method, requestObject, responseClass);
            if (cachedResponse != null) {
                LOGGER.info("Cache hit");
                return cachedResponse;
            }

        }

        if (currentRequestCount >= currentRequestMax) {
            throw new RequestLimitExhaustedException();
        }

        if (requestObject != null) {
            StringWriter writer = new StringWriter();
            JAXB.marshal(requestObject, writer);
            LOGGER.info(writer.toString());
        }

        Response response = client.target(uri)
                .request(MediaType.APPLICATION_XML)
                .header("Authorization", auth.getAuthorizationHeader(method, uri.toString()))
                .method(method, Entity.entity(requestObject, MediaType.APPLICATION_XML));

        if (response.getHeaders().containsKey("X-Request-Limit-Count")) {
            currentRequestCount = Integer.parseInt(response.getHeaderString("X-Request-Limit-Count"));
        }
        if (response.getHeaders().containsKey("X-Request-Limit-Max")) {
            currentRequestMax = Integer.parseInt(response.getHeaderString("X-Request-Limit-Max"));
        }

        LOGGER.info("Request Limits: " + currentRequestCount + "/" + currentRequestMax);

        LOGGER.info(response.getStatus() + " " + response.getStatusInfo());

        response.bufferEntity();
        String bodyAsString = response.readEntity(String.class);
        if (bodyAsString != null && !bodyAsString.isEmpty()) {
            LOGGER.info(bodyAsString);
        }

        switch (response.getStatus()) {
            case 200:
            case 206:
                T entity = null;
                if (responseClass != null) {
                    entity = response.readEntity(responseClass);
                }
                if (useCache && cacheEnabled) {
                    cache.store(uri.toString(), method, requestObject, entity, LocalDateTime.now().plus(cacheDurationInSeconds, ChronoUnit.SECONDS));
                }

                return entity;
            case 204:
                if (responseClass != null) {
                    try {
                        return responseClass.getDeclaredConstructor().newInstance();
                    } catch (InstantiationException | InvocationTargetException e) {
                        throw new RuntimeException(e);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException("no-args constructor of " + responseClass + " is not accessible");
                    } catch (NoSuchMethodException e) {
                        throw new RuntimeException(responseClass + " must have a no-args constructor");
                    }
                } else {
                    return null;
                }
            case 400:
                throw new MKMApiClientException(response.readEntity(BadRequestResponse.class).toString());
            case 401:
            case 403:
                throw new UnauthorizedException();
            case 429:
                throw new RequestLimitExhaustedException();
            default:
                throw new MKMApiClientException("Status Code " + response.getStatus());
        }
    }
}
