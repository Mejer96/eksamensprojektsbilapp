package com.example.eksamensprojektsbilapp.Service;

import com.example.eksamensprojektsbilapp.Model.RentalAgreement;
import com.example.eksamensprojektsbilapp.Repository.CustomerRepository;
import com.example.eksamensprojektsbilapp.Repository.RentalRegistrationHistory;
import com.example.eksamensprojektsbilapp.Repository.RentalRegistrationRepository;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

public class RentalRegistrationService {
   private RentalRegistrationRepository rentalRegistrationRepository = new RentalRegistrationRepository();
   private RentalRegistrationHistory rentalRegistrationHistory = new RentalRegistrationHistory();

   public RentalAgreement createRentalAgreementObject(int customerID, String vinNumber, double price, Date rentalStartdate, Date rentalEndDate) {
      return new RentalAgreement(customerID, vinNumber, price, rentalStartdate, rentalEndDate);
   }

   public void insertRentalAgreementDB(RentalAgreement rentalAgreement) throws SQLException {
      rentalRegistrationRepository.insertRentalAgreementDB(rentalAgreement);
   }

   public void deleteRentalAgreementDB(int id) throws SQLException {
      rentalRegistrationRepository.deleteRentalAgreementDB(id);
   }

   public ArrayList<RentalAgreement> selectAllRentalAgreements() throws SQLException {
      return rentalRegistrationRepository.getAllRentalAgreementsDB();
   }

   public RentalAgreement selectRentalAgreementByIDDB(int id) throws SQLException {
     return rentalRegistrationRepository.getRentalAgreementByID(id);
   }

   public void insertRentalAgreementToHistoryDB(RentalAgreement rentalAgreement) throws SQLException {
      rentalRegistrationHistory.insertRentalAgreementToHistory(rentalAgreement);
   }

}
