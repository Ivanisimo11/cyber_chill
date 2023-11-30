package com.cyber_chill.exception;

public class TooManyLoginAttemptsException extends RuntimeException{
    public TooManyLoginAttemptsException(String message) {
        super(message);
    }
}
