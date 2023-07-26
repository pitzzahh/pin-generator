package com.github.pitzzahh.pinGenerator;

import com.github.pitzzahh.pinGenerator.exceptions.InvalidPinLengthException;
import static io.github.pitzzahh.util.utilities.Print.println;
import com.github.pitzzahh.pinGenerator.exceptions.InvalidPinTypeException;
import io.github.pitzzahh.util.utilities.validation.Validator;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.Optional;
import java.util.stream.IntStream;

class PinGeneratorTest {

    @Test
    void shouldPassIfPinIsRandomNumbers() throws InvalidPinLengthException, InvalidPinTypeException {
        // given
        int pintype = PinGenerator.NUMBERS;
        int pintLength = 6;
        // when
        Pin pinObject = PinGenerator.generatePin(pintype, pintLength);
        String pin = pinObject.pin();
        println(pinObject);
        // then
        assertTrue(Validator.isWholeNumber().test(pin));
    }

    @Test
    void shouldPassIfPinIsRandomLetters() throws InvalidPinLengthException, InvalidPinTypeException {
        // given
        int pintype = PinGenerator.LETTERS;
        int pintLength = 6;
        // when
        Pin pinObject = PinGenerator.generatePin(pintype, pintLength);
        String pin = pinObject.pin();
        println(pinObject);
        // then
        assertTrue(Validator.isString().test(pin));
    }

    @Test
    void shouldPassIfPinIsRandomMixedNumbersAndLetters() throws InvalidPinLengthException, InvalidPinTypeException {
        // given
        int pintype = PinGenerator.LETTERS;
        int pintLength = 6;
        // when
        Pin pinObject = PinGenerator.generatePin(pintype, pintLength);
        String[] pin = pinObject.pin().split("");
        Optional<String> result = IntStream.range(0, pintLength)
                .filter(i -> Validator.isString().or(Validator.isWholeNumber()).test(pin[i]))
                .findAny()
                .stream()
                .mapToObj(e -> pin[e])
                .findAny();
        // then
        assertTrue(result.isPresent());
    }

    @Test
    void shouldThrowInvalidPinLengthExceptionIfPinLengthIsLessThanFour() {
        assertThrows(InvalidPinLengthException.class, () -> {
            Pin pin = PinGenerator.generatePin(PinGenerator.NUMBERS, 3);
            println(pin);
        });
    }

    @Test
    void shouldThrowInvalidPinLengthExceptionIfPinLengthIsGreaterThanTwenty() {
        assertThrows(InvalidPinLengthException.class, () -> PinGenerator.generatePin(PinGenerator.NUMBERS, 21));
    }

    @Test
    void shouldThrowInvalidPinTypeExceptionIfPinTypeIsInvalid() {
        assertThrows(InvalidPinTypeException.class, () -> PinGenerator.generatePin(5, 6));
    }
}