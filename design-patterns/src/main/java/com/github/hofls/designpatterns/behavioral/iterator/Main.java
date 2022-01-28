package com.github.hofls.designpatterns.behavioral.iterator;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Lets you traverse elements of a collection without exposing its underlying representation
 */
public class Main {

    public void onStartup() {
        Iterator<String> iterator = Arrays.asList("ab", "cd").iterator();
        while (iterator.hasNext()) {
            String element = iterator.next();
        }
    }

}
