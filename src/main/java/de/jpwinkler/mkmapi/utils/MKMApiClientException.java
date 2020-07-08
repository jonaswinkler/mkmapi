package de.jpwinkler.mkmapi.utils;

public class MKMApiClientException extends Exception {

    public MKMApiClientException() {
        super();
    }

    public MKMApiClientException(String message) {
        super(message);
    }

    public MKMApiClientException(String message, Throwable cause) {
        super(message, cause);
    }

    public MKMApiClientException(Throwable cause) {
        super(cause);
    }

    protected MKMApiClientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
