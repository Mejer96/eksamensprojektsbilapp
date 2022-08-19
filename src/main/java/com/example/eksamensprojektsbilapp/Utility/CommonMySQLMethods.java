package com.example.eksamensprojektsbilapp.Utility;

import java.sql.*;

public class CommonMySQLMethods {

    public Connection createConnection() {
        Connection connection = null;
        String url = "jdbc:mysql://127.0.0.1:3306/bilabonnement";

        try {
            connection = DriverManager.getConnection(url, "root", "E}#naP47:fz)@^?h");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }


    public PreparedStatement createPreparedStatement(Connection connection, String preparedStatementString) {
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement(preparedStatementString);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return preparedStatement;
    }
}
