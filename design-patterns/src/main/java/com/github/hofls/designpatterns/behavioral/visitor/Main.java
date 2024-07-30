package com.github.hofls.designpatterns.behavioral.visitor;

import java.util.Arrays;
import java.util.List;

/**
 * Visitor separate algorithms from the objects on which they operate.
 * It allows adding new operations to existing object structures without modifying them
 */
public class Main {

    public void example() {
        List<Classes.Node> nodes = Arrays.asList(
                new Classes.HighNode(),
                new Classes.LowNode()
        );
        Classes.NodeVisitor visitor = new Classes.NodeVisitor();
        for (Classes.Node node : nodes) {
            node.accept(visitor);
        }
    }

}
