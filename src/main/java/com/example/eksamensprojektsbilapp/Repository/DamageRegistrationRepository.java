package com.example.eksamensprojektsbilapp.Repository;


import com.example.eksamensprojektsbilapp.Model.DamageReport;
import com.example.eksamensprojektsbilapp.Utility.CommonMySQLMethods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DamageRegistrationRepository {
    private CommonMySQLMethods commonMySQLMethods = new CommonMySQLMethods();

    public void insertDamageReportDB(DamageReport damageReport) throws SQLException {
        Connection connection = commonMySQLMethods.createConnection();
        String mySQLStatement = "INSERT INTO damage_report (rental_agreement_id, kilometers_exceeded, damage_cost, damage_report) VALUES (?, ?, ?, ?)";
        PreparedStatement preparedStatement = connection.prepareStatement(mySQLStatement);
        preparedStatement.setInt(1, damageReport.getRentalAgreementID());
        preparedStatement.setDouble(2, damageReport.getKilometersExceeded());
        preparedStatement.setDouble(3, damageReport.getRepairCost());
        preparedStatement.setString(4, damageReport.getDamageReport());
        preparedStatement.executeUpdate();
        connection.close();
    }
}
