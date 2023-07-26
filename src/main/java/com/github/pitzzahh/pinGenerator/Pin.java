package com.github.pitzzahh.pinGenerator;

import java.util.Objects;

/**
 * Record used for making a Pin object.
 *
 * @param pin       the actual pin.
 * @param pinType   the type of pin. Numbers = 1, Letters = 2, User_Defined = 3.
 * @param pinLength the length of the pin. The pin should always be the same as the length of the actual pin.
 */
public final class Pin {
    private final String pin;
    private final int pinType;
    private final int pinLength;

    Pin(String pin, int pinType, int pinLength) {
        this.pin = pin;
        this.pinType = pinType;
        this.pinLength = pinLength;
    }

    public String pin() {
        return pin;
    }

    public int pinType() {
        return pinType;
    }

    public int pinLength() {
        return pinLength;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        Pin that = (Pin) obj;
        return Objects.equals(this.pin, that.pin) &&
                this.pinType == that.pinType &&
                this.pinLength == that.pinLength;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pin, pinType, pinLength);
    }

    @Override
    public String toString() {
        return (pin().length() == pinLength() || (pinType == 4)) ? ("\033[0;94m" + pin()) : "";
    }
}
