package com.example.eksamensprojektsbilapp.Service;

import com.example.eksamensprojektsbilapp.Model.DamageReport;
import com.example.eksamensprojektsbilapp.Repository.DamageRegistrationRepository;
import com.example.eksamensprojektsbilapp.Repository.RentalRegistrationRepository;

import java.sql.SQLException;

public class DamageRegistrationService {
    private DamageRegistrationRepository damageRegistrationRepository = new DamageRegistrationRepository();
    private RentalRegistrationRepository rentalRegistrationRepository = new RentalRegistrationRepository();

    public DamageReport createDamageReportObject(int rentalAgreementID, double kilometers_exceeded, String damageReport, double repairCost) {
        return new DamageReport(rentalAgreementID, kilometers_exceeded, damageReport, repairCost);
    }

    public int getRentalAgreementID(String vinNumber) throws SQLException {
        return rentalRegistrationRepository.getRentalAgreementIDByVinNumber(vinNumber);
    }

    public void insertDamageReportObjectDB(DamageReport damageReport) throws SQLException {
        damageRegistrationRepository.insertDamageReportDB(damageReport);
    }

}
