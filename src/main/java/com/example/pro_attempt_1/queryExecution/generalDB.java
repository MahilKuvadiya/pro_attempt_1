package com.example.pro_attempt_1.queryExecution;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.example.pro_attempt_1.mapper.RowMapperInterface;

public class generalDB<T> {

    private Connection getConnection() throws ClassNotFoundException, SQLException {
        System.out.println("in get connection");
        Class.forName("com.mysql.jdbc.Driver");
        String url ="jdbc:mysql://localhost:3306/mahil";
        String uname = "root";
        String pass = "1234";

        return DriverManager.getConnection(url,uname,pass);
    }

    public List<T> query(String sql, RowMapperInterface<T> rowMapper, Object... parameters) throws SQLException {
        System.out.println("in query");

        List<T> results = new ArrayList<>();
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        try {
            connection = getConnection();
            System.out.println("connetion gotted");
            System.out.println(parameters[1]);
            System.out.println("length "+ parameters.length);
            statement = connection.prepareStatement(sql);
            System.out.println("calling the set parameter");
            setParameter(statement, parameters);
            System.out.println("executing statement");
            System.out.println(statement);
            System.out.println("oi");
            resultSet = statement.executeQuery();
            System.out.println("gotten resultset");
            while (resultSet.next()) {
                System.out.println("this is resultser "+ resultSet.getString(1));
                results.add(rowMapper.mapRow(resultSet));
            }
            return results;
        } catch (SQLException | ClassNotFoundException ex) {
            return new ArrayList<>();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (resultSet != null) {
                    resultSet.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void setParameter(PreparedStatement prepareStatement, Object... parameters) {
        System.out.println("in set parameter");
        try {
            for (int i = 0; i < parameters.length; i++) {
                Object parameter = parameters[i];
                int index = i + 1;
                if (parameter instanceof Long) {
                System.out.println("long");
                    prepareStatement.setLong(index, (Long) parameter);
                } else if (parameter instanceof String) {
                    System.out.println("string");

                    prepareStatement.setString(index, (String) parameter);
                } else if (parameter instanceof Integer) {
                    System.out.println("int");

                    prepareStatement.setInt(index, (Integer) parameter);
                } else if (parameter instanceof Timestamp) {
                    System.out.println(parameter);

                    prepareStatement.setTimestamp(index, (Timestamp) parameter);
                } else if (parameter instanceof Boolean) {
                    System.out.println(parameter);

                    prepareStatement.setBoolean(index, (Boolean) parameter);
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

}
