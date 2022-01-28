package com.github.hofls.designpatterns.creational.object_pool;

/**
 * Object Pool is usable when cost of creating object is high
 */
public class Main {

    public void onStartup() {
        ConnectionsPool.Connection connection = ConnectionsPool.acquireConnection();
        ConnectionsPool.releaseConnection(connection);
    }

}
