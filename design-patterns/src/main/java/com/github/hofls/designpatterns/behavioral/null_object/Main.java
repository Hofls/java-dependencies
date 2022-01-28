package com.github.hofls.designpatterns.behavioral.null_object;

import java.util.Arrays;
import java.util.List;

/**
 * "Null object" prevents NPEs by providing object that does nothing
 */
public class Main {

    public void onStartup() {
        List<Classes.ConsoleWriter> writers = Arrays.asList(
                new Classes.ClassicWriter(),
                new Classes.NullWriter()
        );

    }

}
