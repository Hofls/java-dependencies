package com.github.hofls.designpatterns.creational.object_pool;

import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

public class ConnectionsPool {

    private static List<Connection> connections = new ArrayList<>();

    private ConnectionsPool() {}

    public static class Connection {}

    public static Connection acquireConnection() {
        if (CollectionUtils.isEmpty(connections)) {
            connections.add(new Connection());
        }
        return connections.get(0);
    }

    public static void releaseConnection(Connection connection) {
        connections.add(connection);
    }

}
