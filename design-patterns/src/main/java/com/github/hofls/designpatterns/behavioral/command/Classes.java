package com.github.hofls.designpatterns.behavioral.command;

import java.io.File;

public class Classes {

    public static abstract class FileCommand {
        private File sourceFile;

        public FileCommand(File sourceFile) {
            this.sourceFile = sourceFile;
        }

        public abstract void execute();
    }

    public static class CopyCommand extends FileCommand {
        public CopyCommand(File sourceFile) {
            super(sourceFile);
        }

        @Override
        public void execute() {}
    }

    public static class DeleteCommand extends FileCommand {
        public DeleteCommand(File sourceFile) {
            super(sourceFile);
        }

        @Override
        public void execute() {}
    }

    public static class RenameCommand extends FileCommand {
        public RenameCommand(File sourceFile) {
            super(sourceFile);
        }

        @Override
        public void execute() {}
    }

}
