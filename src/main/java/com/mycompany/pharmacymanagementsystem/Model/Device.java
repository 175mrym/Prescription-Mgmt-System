/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmacymanagementsystem.Model;
import com.mycompany.pharmacymanagementsystem.*;
import java.time.LocalDate;
/**
 *
 * @author maryamwaleed
 */
public class Device extends Item {
   
    private String deviceType;
    private String model;

    public Device() {
    }

    public Device(String deviceType, String model, String ID, String name, char category, String description, LocalDate expiryDate, int qtyInStock, double price, Supplier supplier) {
        super(ID, name, category, description, expiryDate, qtyInStock, price, supplier);
        this.deviceType = deviceType;
        this.model = model;
    }
    
    public Device(String id, String name, char category, String description, LocalDate expiryDate, int qtyInStock, double price, Supplier supplier) {
        super(id, name, category, description, expiryDate, qtyInStock, price, supplier);
    }
    

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
    
    @Override
    public double calculateTotalPrice() {
        double totalPrice = getPrice() * getQtyInStock();
        if (getDeviceType().equalsIgnoreCase("Type1")) {
            totalPrice *= 1.1; // Example: Increase price by 10% for Type1 devices
        } else if (getDeviceType().equalsIgnoreCase("Type2")) {
            totalPrice *= 1.2; // Example: Increase price by 20% for Type2 devices
    }

    return totalPrice;
    }
    
    @Override
    public boolean checkExpiry() {
        LocalDate currentDate = LocalDate.now();
        return currentDate.isAfter(getExpiryDate());
    }
    
    @Override
    public String toString() {
        return super.toString() +
                "\nDevice Type: " + deviceType +
                "\nModel: " + model;
    }

    @Override
    public void search() {
        System.out.println("Searching for device!");
    }
    
    @Override
    public void purchase() {
        System.out.println("The device is purchaseable");
    }

    @Override
    public void supply() {
        System.out.println("The device is Supplyable");
    }


   
}
