package com.github.pitzzahh.pinGenerator;

/**
 * Record used for making a Pin object.
 * @param pin the actual pin.
 * @param pinType the type of pin. Numbers = 1, Letters = 2, User_Defined = 3.
 * @param pinLength the length of the pin. The pin should always be the same as the length of the actual pin.
 */
public record Pin(String pin, int pinType, int pinLength) {
    @Override
    public String toString() {
        return (pin().length() == pinLength() || (pinType == 4)) ? ("\033[0;94m" + pin()) : "";
    }
}
