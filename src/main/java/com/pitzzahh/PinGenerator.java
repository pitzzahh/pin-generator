package com.pitzzahh;

import java.util.Random;
import java.util.Scanner;
/**
 * Utility class used in making pins or passwords.
 * To generate a pin, you need to instantiate the Pin record, not the PinGenerator class itself.
 * Available pin/password choices:
 * <p>1. Random Numbers
 * <p>2. Random Letters
 * <p>3. User defined Pin / Password
 * @author pitzzahh
 * @since 17
 */
public final class PinGenerator {

    public static final int NUMBERS = 1;
    public static final int LETTERS = 2;
    public static final int USER_DEFINED = 3;

    // Cannot instantiate this class
    private PinGenerator() {}

    // Random class object
    private static final Random random = new Random();

    /**
     * Method that generates a pinInString.
     * random pinInString or user defined pinInString.
     * If the user did not follow the flow of the code, the program will return a pinInString that contains with mixed
     * of numbers and letters.
     * @param pinType the type of pinInString. You can specify the pinInString type by using the instance variables of this class
     *      <p>NUMBERS = 1</p>
     *      <p>LETTERS = 2</p>
     *      <p>USER_DEFINED = 3</p>
     * @param pinLength the length of the pinInString. The pinInString length should not be less than 2 and not over than 20 characters.
     */
    public static Pin generatePin(int pinType, int pinLength) {

        String numbers = "1234567890";
        String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String userDefined;

        char[] pinHolder = new char[0];
        if ((pinType == 1 || pinType == 2 || pinType == 3) && (pinLength >= 4 && pinLength <= 20)) {
            // storing each randomly generated characters / user defined pinInString or password into this char array
            pinHolder = new char[pinLength];
            // checks which type of pinInString is it
            switch (pinType) {
                case NUMBERS -> {
                    // generates random numbers by selecting random indexes at numbers variable.
                    for (int index = 0; index < pinLength; index++) {
                        pinHolder[index] = numbers.charAt(random.nextInt(numbers.length()));
                    }
                }
                case LETTERS -> {
                    // generates random letters by selecting random indexes at letters variable.
                    for (int index = 0; index < pinLength; index++) {
                        pinHolder[index] = letters.charAt(random.nextInt(letters.length()));
                    }
                }
                case USER_DEFINED -> {
                    System.out.print("\u001B[33mENTER YOUR OWN PIN: ");
                    userDefined = new Scanner(System.in).nextLine();
                    pinHolder = userDefined.toCharArray();
                }
            }
        }
        try {
            if (pinLength <= 3 || pinLength >= 21) throw new InvalidPinLengthException(pinLength);
            else if (pinType != 1 && pinType != 2 && pinType != 3) throw new InvalidPinTypeException(pinType);
            else if (pinLength != pinHolder.length) throw new InvalidPinLengthException(pinLength);
        } catch (Exception exception) {
            System.out.println("\u001B[31m" + exception.getMessage());
        }
        return new Pin(String.valueOf(pinHolder), pinType, pinLength);
    }

    /**
     * Record used for making a Pin object.
     * @param pinInString the actual pin.
     * @param pinType the type of pin. Numbers = 1, Letters = 2, User_Defined = 3.
     * @param pinLength the length of the pin. The pin should always be the same as the length of the actual pin.
     */
    public record Pin(String pinInString, int pinType, int pinLength) {
        @Override
        public String toString() {
            return (pinInString().length() == pinLength()) ? ("\u001B[35m" + pinInString()) : "";
        }
    }
}

/**
 * Throwable class used for handling exceptions on invalid pin type.
 */
class InvalidPinTypeException extends Exception {
    public InvalidPinTypeException(int pinType) {
        super(String.format("INVALID PIN TYPE: UNKNOWN PIN %d", pinType));
    }
}
/**
 * Throwable class used for handling exceptions on invalid pin length.
 */
class InvalidPinLengthException extends Exception {
    public InvalidPinLengthException(int pinLength) {
        super(pinLength <= 3 ? String.format("PIN LENGTH SHOULD NOT BE LESS THAN OR EQUAL TO 3: PIN %d", pinLength) : pinLength >= 21 ? String.format("PIN LENGTH SHOULD NOT BE GREATER THAN OR EQUAL TO 21: PIN %d", pinLength) : "INPUTTED LENGTH IS NOT THE SAME AS THE PIN LENGTH");
    }
}

