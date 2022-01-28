package com.github.hofls.designpatterns.structural.composite;

import java.util.ArrayList;
import java.util.List;

public class Classes {

    public interface FileSystemElement {}

    public static class File implements FileSystemElement {}

    public static class Directory implements FileSystemElement {

        private List<FileSystemElement> elements = new ArrayList<>();

        public void addElement(FileSystemElement element) {
            elements.add(element);
        }

    }

}
