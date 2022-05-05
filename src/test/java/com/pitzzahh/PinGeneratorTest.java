package com.pitzzahh;

class PinGeneratorTest {
    public static void main(String[] args) {
        PinGenerator.Pin pin = PinGenerator.generatePin(PinGenerator.NUMBERS, 4);
        System.out.println(pin);
    }
}