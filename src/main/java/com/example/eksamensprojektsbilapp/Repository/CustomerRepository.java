package com.example.eksamensprojektsbilapp.Repository;

import com.example.eksamensprojektsbilapp.Model.Customer;
import com.example.eksamensprojektsbilapp.Utility.CommonMySQLMethods;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class CustomerRepository {
    private CommonMySQLMethods commonMySQLMethods = new CommonMySQLMethods();

    public void insertCustomerDB(Customer customer) throws SQLException {
        Connection connection = commonMySQLMethods.createConnection();
        String mySQLStatement = "INSERT INTO customer (firstname, lastname, email, phonenumber) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(mySQLStatement);
        preparedStatement.setString(1, customer.getFirstname());
        preparedStatement.setString(2, customer.getLastname());
        preparedStatement.setString(3, customer.getEmail());
        preparedStatement.setInt(4, customer.getPhoneNumber());
        preparedStatement.executeUpdate();
        connection.close();
    }

    public int getCustomerID(String firstname, String lastname, String email) throws SQLException {
        Connection connection = commonMySQLMethods.createConnection();
        int customerID = 0;
        String mySQLStatement = "SELECT customer_id FROM customer WHERE firstname=? AND lastname=? AND email=?";
        PreparedStatement preparedStatement = connection.prepareStatement(mySQLStatement);
        preparedStatement.setString(1, firstname);
        preparedStatement.setString(2, lastname);
        preparedStatement.setString(3, email);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            customerID = resultSet.getInt("customer_id");
        }
        return customerID;
    }

}
