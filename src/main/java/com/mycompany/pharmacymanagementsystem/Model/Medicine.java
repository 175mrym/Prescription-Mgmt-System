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
public class Medicine  extends Item {
  
    private float dosage;
    private String format; //as in liquid, topical gel, oral tablet...etc
    private String unitSize; //as in ml, mg, g...etc

    public Medicine() {
    }

    public Medicine(float dosage, String format, String unitSize, String ID, String name, char category, String description, LocalDate expiryDate, int qtyInStock, double price, Supplier supplier) {
        super(ID, name, category, description, expiryDate, qtyInStock, price, supplier);
        this.dosage = dosage;
        this.format = format;
        this.unitSize = unitSize;
    }
    
    public Medicine(String id, String name, char category, String description, LocalDate expiryDate, int qtyInStock, double price, Supplier supplier) {
        super(id, name, category, description, expiryDate, qtyInStock, price, supplier);
    }
    
    public float getDosage() {
        return dosage;
    }

    public void setDosage(float dosage) {
        this.dosage = dosage;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getUnitSize() {
        return unitSize;
    }

    public void setUnitSize(String unitSize) {
        this.unitSize = unitSize;
    }

    @Override
    public double calculateTotalPrice() {
        // Base price calculation: price * qtyInStock
        double basePrice = getPrice() * getQtyInStock();
        //price is per unit dose
        double totalPrice = basePrice * getDosage();
    return totalPrice;
}

    
    @Override
    public boolean checkExpiry() {
        if (getExpiryDate() == null) {
            // No expiry date set, consider it as not expired
        return false;
        } else {
            LocalDate currentDate = LocalDate.now();
            return currentDate.isAfter(getExpiryDate());
        }
    }
    

    @Override
    public String toString() {
        return super.toString() +
                "\nDosage:" + dosage +
                "\nFormat: " + format +
                "\nUnit Size: " + unitSize;
    }

    @Override
    public void search() {
        System.out.println("Searching for the Medicine!");
    }
    
    @Override
    public void purchase() {
        System.out.println("The Medicine is purchaseable");
    }

    @Override
    public void supply() {
        System.out.println("The Medicine is Supplyable");
    }

    
}
