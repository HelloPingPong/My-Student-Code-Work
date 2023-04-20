package com.techelevator;

import java.math.BigDecimal;
import java.util.Scanner;

public class AssertingDoublesApp {

    private static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        System.out.println("What is the expected value?");
        String expectedValue = in.nextLine();
        double expected = Double.parseDouble(expectedValue);
        System.out.println("What is the actual value?");
        String actualValue = in.nextLine();
        double actual = Double.parseDouble(actualValue);
        System.out.println("How much difference is acceptable? Please enter a percentage as a decimal.");
        System.out.println("example: 1% would be .01. Or for 0.9% enter 0.009");
        String deltaValueAsPercentage = in.nextLine();
        double delta = Double.parseDouble(deltaValueAsPercentage);
        System.out.println("Expected: " + expected);
        System.out.println("Actual: " + actual);
        System.out.println("Delta:" + delta);
        boolean isAcceptableDifference = areTheseDoublesEqualEnough(expected, actual, delta);
        System.out.println("Are these doubles equal enough? " + isAcceptableDifference);
    }

    public static boolean areTheseDoublesEqualEnough(double expected, double actual, double delta){
        double difference = Math.abs(expected - actual);

        String plainStringDifference = new BigDecimal(Double.toString(difference)).toPlainString();
        System.out.println("The difference between actual and expected is: " + ANSI_YELLOW + plainStringDifference + ANSI_RESET);

        if(difference > delta){
            return false;
        }
        return true;
    }
}
