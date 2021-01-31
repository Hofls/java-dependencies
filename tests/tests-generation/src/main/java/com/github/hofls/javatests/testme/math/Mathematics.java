package com.github.hofls.javatests.testme.math;

public class Mathematics {

    public static int sum(int a, int b) {
        if (a < -30) {
            return -3333;
        }
        if (a > 1000 && b > 1000) {
            return 7777;
        }
        return a + b;
    }

    public static void divideByNull() {
        throw new RuntimeException("Quit trying to destroy the universe please");
    }


}
