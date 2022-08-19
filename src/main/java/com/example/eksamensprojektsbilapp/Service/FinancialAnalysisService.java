package com.example.eksamensprojektsbilapp.Service;

import com.example.eksamensprojektsbilapp.Model.RentalAgreement;
import com.example.eksamensprojektsbilapp.Repository.RentalRegistrationRepository;

import java.sql.SQLException;
import java.util.ArrayList;

public class FinancialAnalysisService {
    private RentalRegistrationRepository rentalRegistrationRepository = new RentalRegistrationRepository();

    public float calculateTotalIncome(ArrayList<RentalAgreement> activeRentalAgreements) {
        float totalIncome = 0;

        for (int i = 0; activeRentalAgreements.size() > i; i++) {
            totalIncome += activeRentalAgreements.get(i).getPrice();
        }
        return totalIncome;
    }

    public ArrayList<RentalAgreement> getAllrentalAgreementsDB() throws SQLException {
        return rentalRegistrationRepository.getAllRentalAgreementsDB();
    }

}
