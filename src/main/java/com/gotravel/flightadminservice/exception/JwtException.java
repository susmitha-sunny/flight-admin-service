package com.gotravel.flightadminservice.exception;


public class JwtException extends Exception {
    public JwtException() {
        super();
    }

    public JwtException(final String message) {
        super(message);
    }

    public JwtException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public JwtException(final Throwable cause) {
        super(cause);
    }

    public JwtException(final String message, final Throwable cause, final boolean enableSuppression, final  boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
