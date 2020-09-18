package com.jaredengler;

public class App {
    public static void main(String[] args) {
        BinaryGapCalculator binaryGapCalculator = new BinaryGapCalculator();
        binaryGapCalculator.calculate(Integer.valueOf(args[0]));
    }
}
