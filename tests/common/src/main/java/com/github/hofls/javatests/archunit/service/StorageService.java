package com.github.hofls.javatests.archunit.service;


import org.springframework.validation.annotation.Validated;

// Remove a comment to break archunit test
public class StorageService {

    private String message;

    public static void tryToBreakArchitecture() {
        // OffsetDateTime.now();

        // throw new IllegalArgumentException("ss");

        // StorageWeb.recalculateValues();
    }

   // public void temp(@Deprecated Integer number) {}

/*
    public void methodWithManyParameters(int a, int b, int c, int d, int e,
                                         int f, int g, int h, int i, int j) {

    }
 */

/*
    public void hugeMethod() {
        System.out.println("Hello world");
        System.out.println("Hello world");
        System.out.println("Hello world");
        System.out.println("Hello world");
        System.out.println("Hello world");
        System.out.println("Hello world");
        System.out.println("Hello world");
        System.out.println("Hello world");
        System.out.println("Hello world");
        System.out.println("Hello world");
    }
*/


}
