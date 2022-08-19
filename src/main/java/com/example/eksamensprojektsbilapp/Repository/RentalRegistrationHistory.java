package com.example.eksamensprojektsbilapp.Repository;

import com.example.eksamensprojektsbilapp.Model.RentalAgreement;
import com.example.eksamensprojektsbilapp.Utility.CommonMySQLMethods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RentalRegistrationHistory {
    CommonMySQLMethods commonMySQLMethods = new CommonMySQLMethods();


    public void insertRentalAgreementToHistory(RentalAgreement rentalAgreement) throws SQLException {
        Connection connection = commonMySQLMethods.createConnection();
        String mySQLStatement = "INSERT INTO rental_agreement_history (customer_id, VIN_number, price, rental_startdate, rental_enddate) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(mySQLStatement);
        preparedStatement.setInt(1, rentalAgreement.getCustomerID());
        preparedStatement.setString(2, rentalAgreement.getVinNumber());
        preparedStatement.setDouble(3, rentalAgreement.getPrice());
        preparedStatement.setDate(4, rentalAgreement.getRentalStartdate());
        preparedStatement.setDate(5, rentalAgreement.getRentalEndDate());
        preparedStatement.executeUpdate();
        connection.close();
    }

}
