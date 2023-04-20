package com.techelevator.exceptions;

/*
    Demonstrates a custom checked exception with custom properties.
    A custom runtime exception is the same except that it extends RuntimeException
 */
public class IncorrectStringValueException extends Exception {

    private String originalString;

    public IncorrectStringValueException(String message, String originalValue) {
        super(message);
        this.originalString = originalValue;
    }

    public String getOriginalString() {
        return this.originalString;
    }
}
