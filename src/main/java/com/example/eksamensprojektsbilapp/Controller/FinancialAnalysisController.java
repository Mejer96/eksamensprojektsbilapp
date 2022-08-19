package com.example.eksamensprojektsbilapp.Controller;

import com.example.eksamensprojektsbilapp.Model.RentalAgreement;
import com.example.eksamensprojektsbilapp.Service.FinancialAnalysisService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.sql.SQLException;
import java.util.ArrayList;

@Controller
public class FinancialAnalysisController {
    FinancialAnalysisService financialAnalysisService = new FinancialAnalysisService();

    @GetMapping("/financial-analysis")
    public String requestFinancialAnalysisPage(Model model) throws SQLException {
       ArrayList<RentalAgreement> rentalAgreements = financialAnalysisService.getAllrentalAgreementsDB();
       double totalIncome = financialAnalysisService.calculateTotalIncome(rentalAgreements);
       model.addAttribute("activeRentalAgreements", rentalAgreements);
       model.addAttribute("totalIncome", totalIncome);

        return "financial-analysis";
    }

}
