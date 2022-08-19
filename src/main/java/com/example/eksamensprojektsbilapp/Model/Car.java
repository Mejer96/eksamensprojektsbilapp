package com.example.eksamensprojektsbilapp.Model;

public class Car {
    private String vinNumber;
    private String chassisNumber;
    private String model;
    private String brand;

    public Car(String vinNumber, String chassisNumber, String model, String brand) {
        this.vinNumber = vinNumber;
        this.chassisNumber = chassisNumber;
        this.model = model;
        this.brand = brand;
    }

    public String getVinNumber() {
        return vinNumber;
    }

    public void setVinNumber(String vinNumber) {
        this.vinNumber = vinNumber;
    }

    public String getChassisNumber() {
        return chassisNumber;
    }

    public void setChassisNumber(String chassisNumber) {
        this.chassisNumber = chassisNumber;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                "vinNumber='" + vinNumber + '\'' +
                ", chassisNumber='" + chassisNumber + '\'' +
                ", model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                '}';
    }
}
