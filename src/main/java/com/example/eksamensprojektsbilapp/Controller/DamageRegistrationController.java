package com.example.eksamensprojektsbilapp.Controller;

import com.example.eksamensprojektsbilapp.Model.DamageReport;
import com.example.eksamensprojektsbilapp.Service.DamageRegistrationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;

@Controller
public class DamageRegistrationController {
    DamageRegistrationService damageRegistrationService = new DamageRegistrationService();

    @GetMapping("damage-registration")
    public String requestDamageRegistrationPage() {
        return "damage-registration";
    }

    @PostMapping("damage-registration")
    public String postDamageRegistrationPage(@RequestParam("vinNumber") String vinNumber, @RequestParam("kilometersExceeded") double kilometersExceeded, @RequestParam("damageReport") String damageReport, @RequestParam("repairCost") double repairCost) throws SQLException {
        int rentalAgreementID = damageRegistrationService.getRentalAgreementID(vinNumber);
        DamageReport report = damageRegistrationService.createDamageReportObject(rentalAgreementID, kilometersExceeded, damageReport, repairCost);
        damageRegistrationService.insertDamageReportObjectDB(report);
        System.out.println("hej");
        return "damage-registration";
    }

}

