package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.*;

/**
 * Created by kobis on 20 Mar, 2023
 */
public class ConnectionPool {

    private static ConnectionPool connectionPool = new ConnectionPool();

    private final static int SIZE = 10;

    private final Stack<Connection> connections = new Stack<>();


    private ConnectionPool() {
        InitConnections();
    }

    public static ConnectionPool getConnectionPool() {
        return connectionPool;
    }

    private void InitConnections() {
        for (int i = 0; i < SIZE; i++) {
            try {
                connections.push(DriverManager.getConnection(Credentials.URL, Credentials.USER, Credentials.PASSWORD));
            } catch (SQLException e) {
                System.out.println("Unable to create Connection Pool : " + e.getMessage());
            }
        }
    }

    public void closeAllConnections() {
        synchronized (this.connections){
            while (this.connections.size()!=10){
                try {
                    this.connections.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            this.connections.clear();
        }
    }

    public Connection getConnection() {
        synchronized (this.connections) {
            if (connections.size() == 0) {
                try {
                    this.connections.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
            return connections.pop();
        }
    }

    public void returnConnection(Connection connection) {
        synchronized (this.connections) {
            connections.push(connection);
            this.connections.notify();
        }
    }
}
