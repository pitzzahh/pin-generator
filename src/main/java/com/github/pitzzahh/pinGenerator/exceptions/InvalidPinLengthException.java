package com.github.pitzzahh.pinGenerator.exceptions;

/**
 * Throwable class used for handling exceptions on invalid pin length.
 */
public class InvalidPinLengthException extends Exception {

    /**
     * Throws an InvalidPinLengthException with custom message based on the pin length.
     * @param pinLength the pin length that is invalid.
     */
    public InvalidPinLengthException(int pinLength) {
        super(pinLength <= 3 ? String.format("PIN LENGTH SHOULD NOT BE LESS THAN OR EQUAL TO 3: PIN LENGTH %d", pinLength) : pinLength >= 21 ? String.format("PIN LENGTH SHOULD NOT BE GREATER THAN OR EQUAL TO 21: PIN LENGTH %d", pinLength) : "INPUTTED LENGTH IS NOT THE SAME AS THE PIN LENGTH");
    }
}
