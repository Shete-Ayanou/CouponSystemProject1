package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by kobis on 13 Mar, 2023
 */
public class DBUtils {

    public static void runQuery(String sql) {

        Connection connection = null;
        PreparedStatement statement = null;

        // Step 2 - Open Connection to Database
        connection = getConnection();

        // Step 3 - Prepare Statement & Execute
        statement = getPreparedStatement(connection, sql);
        execute(statement);

        // Step 5 - Close Resources
        closePreparedStatement(statement);
        closeConnection(connection);

    }

    public static void runQuery(String sql, Map<Integer, Object> map) {
        Connection connection = null;
        PreparedStatement statement = null;

        // Step 2 - Open Connection to Database
        connection = getConnection();

        // Step 3 - Prepare Statement & Execute
        statement = getPreparedStatement(connection, sql);
        statement = updatePrepareStatementWithParam(statement, map);
        execute(statement);

        // Step 5 - Close resources
        closePreparedStatement(statement);
        closeConnection(connection);
    }

    public static List<?> runQueryWithResultSet(String sql) {

        List<?> results = new ArrayList<>();

        // Step 2 - Open Connection to Database
        Connection connection = getConnection();
        // Step 3 - Prepare Statement & Execute
        PreparedStatement statement = getPreparedStatement(connection, sql);
        // Step 4 - ResultSet - Relevant only for DQL (select...)
        ResultSet resultSet = getResultSet(statement);

        results = resultSetToArrayList(resultSet);

        // Step 5 - Close the Connection to Database
        closeResultSet(resultSet);
        closePreparedStatement(statement);
        closeConnection(connection);
        return results;
    }

    public static List<?> runQueryWithResultSet(String sql, Map<Integer, Object> map) {
        List<?> results = new ArrayList<>();

        // Step 2 - Open Connection to Database
        Connection connection = getConnection();
        // Step 3 - Prepare Statement & Execute
        PreparedStatement statement = getPreparedStatement(connection, sql);
        statement = updatePrepareStatementWithParam(statement, map);
        // Step 4 - ResultSet - Relevant only for DQL (select...)
        ResultSet resultSet = getResultSet(statement);

        results = resultSetToArrayList(resultSet);

        // Step 5 - Close the Connection to Database
        closeResultSet(resultSet);
        closePreparedStatement(statement);
        closeConnection(connection);
        return results;
    }


    private static Connection getConnection() {
        return ConnectionPool.getConnectionPool().getConnection();
    }

    private static void closeConnection(Connection connection) {
        ConnectionPool.getConnectionPool().returnConnection(connection);
    }

    private static PreparedStatement getPreparedStatement(Connection connection, String sql) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            System.out.println("Unable to create PreparedStatement " + e.getMessage());
        }
        return statement;
    }

    private static void closePreparedStatement(PreparedStatement statement) {
        try {
            statement.close();
        } catch (SQLException e) {
            System.out.println("Unable to close PreparedStatement " + e.getMessage());

        }

    }

    private static void execute(PreparedStatement statement) {
        try {
            statement.execute();
        } catch (SQLException e) {
            System.out.println("Unable to Execute : " + e.getMessage());
        }
    }

    private static PreparedStatement updatePrepareStatementWithParam(PreparedStatement statement, Map<Integer, Object> map) {
        for (Map.Entry<Integer, Object> entry : map.entrySet()) {
            int key = entry.getKey();
            Object value = entry.getValue();
            try {
                if (value instanceof Integer) {
                    statement.setInt(key, (Integer) value);
                } else if (value instanceof String) {
                    statement.setString(key, (String) value);
                } else if (value instanceof Double) {
                    statement.setDouble(key, (Double) value);
                } else if (value instanceof Boolean) {
                    statement.setBoolean(key, (Boolean) value);
                } else if (value instanceof Date) {
                    statement.setDate(key, (Date) value);
                } else if (value instanceof Float) {
                    statement.setFloat(key, (Float) value);
                } else if (value instanceof Long) {
                    statement.setLong(key, (Long) value);
                }
            } catch (Exception e) {
                System.out.println("Unable to set Params....");
            }
        }

        return statement;
    }

    private static ResultSet getResultSet(PreparedStatement statement) {
        try {
            return statement.executeQuery();
        } catch (SQLException e) {
            System.out.println("Unable to create result set : " + e.getMessage());
            return null;
        }

    }

    private static void closeResultSet(ResultSet resultSet) {
        try {
            resultSet.close();
        } catch (SQLException e) {
            System.out.println("Unable to close result set : " + e.getMessage());
        }
    }

    private static List<?> resultSetToArrayList(ResultSet rs) {

        List<HashMap<String, Object>> list = new ArrayList<>();

        try {

            ResultSetMetaData md = rs.getMetaData();
            int columns = md.getColumnCount();


            while (rs.next()) {
                HashMap<String, Object> row = new HashMap<>(columns);
                for (int i = 1; i <= columns; ++i) {
                    row.put(md.getColumnName(i), rs.getObject(i));
                }
                list.add(row);
            }
        } catch (Exception e) {
            System.out.println("Unable to read result set : " + e.getMessage());
        }

        return list;
    }
}
