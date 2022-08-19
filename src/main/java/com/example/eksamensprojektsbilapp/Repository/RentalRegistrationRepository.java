package com.example.eksamensprojektsbilapp.Repository;

import com.example.eksamensprojektsbilapp.Model.RentalAgreement;
import com.example.eksamensprojektsbilapp.Utility.CommonMySQLMethods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RentalRegistrationRepository {
    private CommonMySQLMethods commonMySQLMethods = new CommonMySQLMethods();

    public void insertRentalAgreementDB(RentalAgreement rentalAgreement) throws SQLException {
        Connection connection = commonMySQLMethods.createConnection();

        String mySQLStatement = "INSERT INTO rental_agreement (customer_id, VIN_number, price, rental_startdate, rental_enddate) VALUES (?, ?, ?, ?, ?)";

        PreparedStatement preparedStatement = commonMySQLMethods.createPreparedStatement(connection, mySQLStatement);
        preparedStatement.setInt(1, rentalAgreement.getCustomerID());
        preparedStatement.setString(2, rentalAgreement.getVinNumber());
        preparedStatement.setDouble(3, rentalAgreement.getPrice());
        preparedStatement.setDate(4, rentalAgreement.getRentalStartdate());
        preparedStatement.setDate(5, rentalAgreement.getRentalEndDate());

        preparedStatement.executeUpdate();
        connection.close();
    }

    public void deleteRentalAgreementDB(int rentalAgreementID) throws SQLException {
        Connection connection = commonMySQLMethods.createConnection();

        String mySQLStatement = "DELETE from rental_agreement WHERE rental_agreement_id=?";
        PreparedStatement preparedStatement = commonMySQLMethods.createPreparedStatement(connection, mySQLStatement);
        preparedStatement.setInt(1, rentalAgreementID);

        preparedStatement.executeUpdate();
        connection.close();
    }

    public ArrayList<RentalAgreement> getAllRentalAgreementsDB() throws SQLException {
        Connection connection = commonMySQLMethods.createConnection();
        ArrayList<RentalAgreement> rentalAgreements = new ArrayList<>();

        String mySQLStatement = "SELECT * FROM rental_agreement";
        PreparedStatement preparedStatement = commonMySQLMethods.createPreparedStatement(connection, mySQLStatement);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            RentalAgreement rentalAgreement = new RentalAgreement(resultSet.getInt("customer_id"),
                    resultSet.getString("VIN_number"),
                    resultSet.getDouble("price"),
                    resultSet.getDate("rental_startdate"),
                    resultSet.getDate("rental_enddate"));
            rentalAgreement.setRentalAgreementID(resultSet.getInt("rental_agreement_id"));
            rentalAgreements.add(rentalAgreement);
        }
        connection.close();
        return rentalAgreements;
    }

    public int getRentalAgreementIDByVinNumber(String vinNumber) throws SQLException {
        int rentalAgreementID = 0;
        Connection connection = commonMySQLMethods.createConnection();
        String mySQLStatement = "SELECT rental_agreement_id FROM rental_agreement WHERE VIN_number=?";
        PreparedStatement preparedStatement = connection.prepareStatement(mySQLStatement);
        preparedStatement.setString(1, vinNumber);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            rentalAgreementID = resultSet.getInt("rental_agreement_id");
        }
        return rentalAgreementID;
    }

    public RentalAgreement getRentalAgreementByID(int id) throws SQLException {
        RentalAgreement rentalAgreement = null;
        Connection connection = commonMySQLMethods.createConnection();
        String mySQLStatement = "SELECT *  FROM rental_agreement WHERE rental_agreement_id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(mySQLStatement);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()) {
            rentalAgreement = new RentalAgreement(resultSet.getInt("customer_id"),
                    resultSet.getString("VIN_number"),
                    resultSet.getDouble("price"),
                    resultSet.getDate("rental_startdate"),
                    resultSet.getDate("rental_enddate"));
            rentalAgreement.setRentalAgreementID(resultSet.getInt("rental_agreement_id"));
        }
        return rentalAgreement;
    }

}
