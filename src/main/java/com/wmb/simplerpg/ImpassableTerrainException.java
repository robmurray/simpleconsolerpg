package com.wmb.simplerpg;

/**
 * Created by rob on 7/7/15.
 */
public class ImpassableTerrainException extends InvalidActionException {
    public ImpassableTerrainException() {
    }

    public ImpassableTerrainException(String message) {
        super(message);
    }

    public ImpassableTerrainException(String message, Throwable cause) {
        super(message, cause);
    }

    public ImpassableTerrainException(Throwable cause) {
        super(cause);
    }

    public ImpassableTerrainException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
