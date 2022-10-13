package com.github.pitzzahh.pinGenerator.exceptions;

/**
 * Throwable class used for handling exceptions on invalid pin type.
 */
public class InvalidPinTypeException extends Exception {
    /**
     * Throws an InvalidPinTypeException with custom message based on the pin type.
     * @param pinType the pin type that is invalid.
     */
    public InvalidPinTypeException(int pinType) {
        super(String.format("INVALID PIN TYPE: UNKNOWN PIN TYPE %d", pinType));
    }
}
