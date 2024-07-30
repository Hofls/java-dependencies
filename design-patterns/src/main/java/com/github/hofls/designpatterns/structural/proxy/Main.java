package com.github.hofls.designpatterns.structural.proxy;

/**
 * Proxy is an object representing another object
 * Proxy controls access to the original object, allowing you to perform something either before or after the request gets through to the original object
 */
public class Main {

    public void example() {
        Classes.Converter converter = new Classes.ProxyConverter();
        converter.convert();
    }

}
