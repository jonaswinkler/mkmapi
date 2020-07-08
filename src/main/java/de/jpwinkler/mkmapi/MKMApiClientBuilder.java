package de.jpwinkler.mkmapi;

import de.jpwinkler.mkmapi.impl.MKMApiClientImpl;
import org.w3c.dom.events.UIEvent;

import java.io.File;
import java.io.IOException;

public class MKMApiClientBuilder {

    private String host;
    private String cacheFilename;
    private MKMAuth auth;

    public static MKMApiClientBuilder newBuilder() {
        return new MKMApiClientBuilder();
    }

    public MKMApiClientBuilder host(String host) {
        this.host = host;
        return this;
    }

    public MKMApiClientBuilder withCache(String filename) {
        this.cacheFilename = filename;
        return this;
    }

    public MKMApiClientBuilder auth(MKMAuth auth) {
        this.auth = auth;
        return this;
    }

    public MKMApiClient build() throws IOException {
        MKMApiClientImpl client = new MKMApiClientImpl();

        if (host != null) {
            client.setHost(host);
        }
        client.setAuth(auth);
        if (cacheFilename != null) {
            client.enableCache(true);
            if (new File(cacheFilename).exists()) {
                client.loadCache(cacheFilename);
            }
        }

        return client;
    }

}
