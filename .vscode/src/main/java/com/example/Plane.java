package com.example;

import java.util.Objects;

public class Plane {
    private String model;
    private Manufacturer manufacturer;
    private double fuelLevel;
    private int mileage;
    private final double maxFuel = 15000;

    public Plane(String model, Manufacturer manufacturer, double fuelLevel, int mileage) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.fuelLevel = fuelLevel;
        this.mileage = mileage;
    }

    public void fly(int kilometers) {
        double fuelConsumption = kilometers * 0.5;
        if (fuelLevel >= fuelConsumption) {
            mileage += kilometers;
            fuelLevel -= fuelConsumption;
        } else {
            System.out.println("Not enough fuel to fly.");
        }
    }

    public void refuel(double amount) {
        fuelLevel = Math.min(fuelLevel + amount, maxFuel);
    }

    public void refuelToFull() {
        fuelLevel = maxFuel;
    }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public Manufacturer getManufacturer() { return manufacturer; }
    public void setManufacturer(Manufacturer manufacturer) { this.manufacturer = manufacturer; }

    public double getFuelLevel() { return fuelLevel; }
    public int getMileage() { return mileage; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plane plane)) return false;
        return Objects.equals(model, plane.model) &&
                Objects.equals(manufacturer, plane.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, manufacturer);
    }

    @Override
    public String toString() {
        return "Plane{" +
                "model='" + model + '\'' +
                ", manufacturer=" + manufacturer +
                ", fuelLevel=" + fuelLevel +
                ", mileage=" + mileage +
                '}';
    }
}
