package com.github.hofls.designpatterns.behavioral.strategy;

import java.util.Arrays;
import java.util.List;

/**
 * Strategy defines family of algorithms, puts each of them into a separate class, and make their objects interchangeable.
 */
public class Main {

    public void onStartup() {
        List<Classes.Sorting> algorithms = Arrays.asList(
                new Classes.QuickSorting(),
                new Classes.SlowSorting()
        );
        for (Classes.Sorting algorithm : algorithms) {
            algorithm.sort(Arrays.asList("def", "abc"));
        }
    }

}
