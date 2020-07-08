package de.jpwinkler.mkmapi;

import de.jpwinkler.mkmapi.impl.MKMApiClientImpl;
import org.junit.Before;
import org.junit.BeforeClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.LogManager;

public abstract class MKMApiTest {

    private MKMApiClient client;

    @Before
    public void setup() throws IOException {
        client = MKMApiClientBuilder
                .newBuilder()
                .host("sandbox.cardmarket.com")
                .auth(MKMAuth.loadFromFile("auth_sandbox.json"))
                .build();
    }

    protected MKMApiClient getClient() {
        return client;
    }

}
