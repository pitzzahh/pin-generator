package com.github.pitzzahh;

import com.github.pitzzahh.exceptions.InvalidPinLengthException;
import com.github.pitzzahh.exceptions.InvalidPinTypeException;
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
    public static final int MIXED_NUMBERS_AND_LETTERS = 3;
    public static final int USER_DEFINED = 4;

    // Cannot instantiate this class
    private PinGenerator() {}

    // Random class object
    private static final Random random = new Random();

    /**
     * Method that generates a pin.
     * random pin or user defined pin.
     * If the user did not follow the flow of the code, the program will return a pin that contains with mixed
     * of numbers and letters.
     * @param pinType the type of pin. You can specify the pin type by using the instance variables of this class
     *      <p>NUMBERS = 1</p>
     *      <p>LETTERS = 2</p>
     *      <p>USER_DEFINED = 3</p>
     * @param pinLength the length of the pin. The pin length should not be less than 4 and not over than 20 characters.
     */
    public static Pin generatePin(int pinType, int pinLength) throws InvalidPinLengthException, InvalidPinTypeException {

        String numbers = "1234567890";
        String letters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String userDefined;

        var pinHolder = new char[0];

        if ((pinType == NUMBERS || pinType == LETTERS || pinType == MIXED_NUMBERS_AND_LETTERS || pinType == USER_DEFINED) && (pinLength >= 4 && pinLength <= 20)) {
            // storing each randomly generated characters / user defined pin or password into this char array
            pinHolder = new char[pinLength];
            // checks which type of pin is it
            switch (pinType) {
                case NUMBERS -> generatePin(pinLength, pinHolder, numbers);
                case LETTERS -> generatePin(pinLength, pinHolder, letters);
                case MIXED_NUMBERS_AND_LETTERS -> generatePin(pinLength, pinHolder, numbers + letters);
                case USER_DEFINED -> {
                    System.out.print("\u001B[33mENTER YOUR OWN PIN: ");
                    userDefined = new Scanner(System.in).nextLine();
                    pinHolder = userDefined.toCharArray();
                }
            }
        }
        if (pinLength <= 3 || pinLength >= 21) throw new InvalidPinLengthException(pinType == USER_DEFINED ? pinHolder.length : pinLength);
        else if (pinType != NUMBERS && pinType != LETTERS && pinType != MIXED_NUMBERS_AND_LETTERS && pinType != USER_DEFINED) throw new InvalidPinTypeException(pinType);
        else if (pinLength != pinHolder.length && (pinType == NUMBERS && pinType == LETTERS && pinType == MIXED_NUMBERS_AND_LETTERS)) throw new InvalidPinLengthException(pinLength);
        return new Pin(String.valueOf(pinHolder), pinType, pinLength);
    }

    /**
     * Generates the pin.
     * @param pinLength the length of the pin.
     * @param pinHolder the char array that holds the pin.
     * @param s the letters or numbers.
     */
    private static void generatePin(int pinLength, char[] pinHolder, String s) {
        for (int index = 0; index < pinLength; index++) {
            pinHolder[index] = s.charAt(random.nextInt(s.length()));
        }
    }

}



