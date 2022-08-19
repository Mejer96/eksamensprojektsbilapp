package com.example.eksamensprojektsbilapp.Model;

public class DamageReport {
    private int rentalAgreementID;
    private double kilometersExceeded;
    private String damageReport;
    private double repairCost;

    public DamageReport(int rentalAgreementID, double kilometersExceeded, String damageReport, double repairCost) {
        this.rentalAgreementID = rentalAgreementID;
        this.kilometersExceeded = kilometersExceeded;
        this.damageReport = damageReport;
        this.repairCost = repairCost;
    }

    public int getRentalAgreementID() {
        return rentalAgreementID;
    }

    public void setRentalAgreementID(int rentalAgreementID) {
        this.rentalAgreementID = rentalAgreementID;
    }

    public double getKilometersExceeded() {
        return kilometersExceeded;
    }

    public void setKilometersExceeded(double kilometersExceeded) {
        this.kilometersExceeded = kilometersExceeded;
    }

    public String getDamageReport() {
        return damageReport;
    }

    public void setDamageReport(String damageReport) {
        this.damageReport = damageReport;
    }

    public double getRepairCost() {
        return repairCost;
    }

    public void setRepairCost(double repairCost) {
        this.repairCost = repairCost;
    }

    @Override
    public String toString() {
        return "DamageReport{" +
                "rentalAgreementID=" + rentalAgreementID +
                ", kilometersExceeded=" + kilometersExceeded +
                ", damageReport='" + damageReport + '\'' +
                ", repairCost=" + repairCost +
                '}';
    }
}
