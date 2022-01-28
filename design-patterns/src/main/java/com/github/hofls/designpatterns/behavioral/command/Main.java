package com.github.hofls.designpatterns.behavioral.command;

import java.io.File;
import java.util.Arrays;
import java.util.List;

/**
 * Turns a request into a stand-alone object that contains all information about the request.
 * This transformation lets you parameterize methods with different requests, delay or queue a request's execution, and support undoable operations.
 */
public class Main {

    public void onStartup() {
        File file = new File("");
        List<Classes.FileCommand> commands = Arrays.asList(
                new Classes.RenameCommand(file),
                new Classes.CopyCommand(file),
                new Classes.DeleteCommand(file));

        for (Classes.FileCommand command : commands) {
            command.execute();
        }
    }

}
