package com.wmb.simplerpg;

/**
 * Created by rob on 7/7/15.
 */
public class EdgeOfTheWorldException extends InvalidActionException{
    public EdgeOfTheWorldException() {
    }

    public EdgeOfTheWorldException(String message) {
        super(message);
    }

    public EdgeOfTheWorldException(String message, Throwable cause) {
        super(message, cause);
    }

    public EdgeOfTheWorldException(Throwable cause) {
        super(cause);
    }

    public EdgeOfTheWorldException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
