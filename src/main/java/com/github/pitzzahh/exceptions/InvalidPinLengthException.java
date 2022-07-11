package com.github.pitzzahh.exceptions;

/**
 * Throwable class used for handling exceptions on invalid pin length.
 */
public class InvalidPinLengthException extends Exception {
    public InvalidPinLengthException(int pinLength) {
        super(pinLength <= 3 ? String.format("PIN LENGTH SHOULD NOT BE LESS THAN OR EQUAL TO 3: PIN %d", pinLength) : pinLength >= 21 ? String.format("PIN LENGTH SHOULD NOT BE GREATER THAN OR EQUAL TO 21: PIN %d", pinLength) : "INPUTTED LENGTH IS NOT THE SAME AS THE PIN LENGTH");
    }
}
