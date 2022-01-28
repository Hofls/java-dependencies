package com.github.hofls.designpatterns.behavioral.visitor;

public class Classes {

    interface Node {
        void accept(Visitor v);
    }

    public static class HighNode implements Node {
        public void accept(Visitor v) {
            v.visit(this);
        }
    }

    public static class LowNode implements Node {
        public void accept( Visitor v ) {
            v.visit( this );
        }
    }

    public static interface Visitor {
        void visit(HighNode node);
        void visit(LowNode node);
    }

    public static class NodeVisitor implements Visitor {
        public void visit(HighNode node) { }
        public void visit(LowNode node) { }
    }

}
