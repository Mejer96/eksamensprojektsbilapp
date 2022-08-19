package com.example.eksamensprojektsbilapp.Controller;

import com.example.eksamensprojektsbilapp.Model.Customer;
import com.example.eksamensprojektsbilapp.Model.RentalAgreement;
import com.example.eksamensprojektsbilapp.Service.CustomerService;
import com.example.eksamensprojektsbilapp.Service.RentalRegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;

@Controller
public class RentalRegistrationController {
    RentalRegistrationService rentalRegistrationService = new RentalRegistrationService();
    CustomerService customerService = new CustomerService();

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/rental-registration")
    public String requestRentalRegistrationPage() {
        return "rental-registration";
    }

    @PostMapping("/rental-registration")
    public String postRentalRegistrationPage(@RequestParam("firstname") String firstname,
                                         @RequestParam("lastname") String lastname,
                                         @RequestParam("phoneNumber") int phoneNumber,
                                         @RequestParam("email") String email,
                                         @RequestParam("vinNumber") String vinNumber,
                                         @RequestParam("rentalStartdate") Date startdate,
                                         @RequestParam("rentalEndDate") Date endDate,
                                         @RequestParam("price") double price) throws SQLException {
        Customer customer = customerService.createCustomerObject(firstname, lastname, email, phoneNumber);
        customerService.insertCustomerObjectDB(customer);
        int customerID = customerService.selectCustomerID(firstname, lastname, email);
        RentalAgreement rentalAgreement = rentalRegistrationService.createRentalAgreementObject(customerID, vinNumber, price, startdate, endDate);
        rentalRegistrationService.insertRentalAgreementDB(rentalAgreement);
        return "rental-registration";
    }


    @GetMapping("/show-rental-agreements")
    public String requestShowRentalAgreementsPage(Model model) throws SQLException {
        ArrayList<RentalAgreement> rentalAgreements = rentalRegistrationService.selectAllRentalAgreements();
        model.addAttribute("activeRentalAgreements", rentalAgreements);
        return  "delete-rental-agreement";
    }


    @GetMapping("/delete-rental/{rental-agreement-id}")
    public String postShowRentalAgreementsPage(@PathVariable("rental-agreement-id") int id) throws SQLException {
        RentalAgreement rentalAgreement = rentalRegistrationService.selectRentalAgreementByIDDB(id);
        rentalRegistrationService.insertRentalAgreementToHistoryDB(rentalAgreement);
        rentalRegistrationService.deleteRentalAgreementDB(id);
        return "delete-rental-agreement";
    }

}
