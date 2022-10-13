package com.github.pitzzahh.pinGenerator.exceptions;

/**
 * Throwable class used for handling exceptions on invalid pin type.
 */
public class InvalidPinTypeException extends Exception {
    public InvalidPinTypeException(int pinType) {
        super(String.format("INVALID PIN TYPE: UNKNOWN PIN %d", pinType));
    }
}
