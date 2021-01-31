package com.github.hofls.javatests.unit;

public class Mathematics {

    public static int sum(int a, int b) {
        return a + b;
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static void divideByNull() {
        throw new RuntimeException("Quit trying to destroy the universe please");
    }

    public static boolean isOdd(int number) {
        return number % 2 != 0;
    }


}
