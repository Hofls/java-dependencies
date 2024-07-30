package com.github.hofls.designpatterns.behavioral.chain_of_responsibility;

/**
 * Chain of responsibility lets you pass requests along a chain of handlers.
 * Upon receiving a request, each handler decides either to process the request or to pass it to the next handler in the chain.
 */
public class Main {

    public void example() {
        Classes.HeaderWriterFilter headerWriterFilter = new Classes.HeaderWriterFilter();
        headerWriterFilter
                .setNext(new Classes.LogoutFilter())
                .setNext(new Classes.AuthenticationFilter());

        headerWriterFilter.process(new Classes.Request() {});
    }

}
