package com.cyber_chill.exception;

public class ItemAlreadyExists extends RuntimeException {
    public ItemAlreadyExists(String message) {
        super(message);
    }
}
