/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmacymanagementsystem.Model;

import java.time.LocalDate;

/**
 *
 * @author maryamwaleed
 */

public class ItemFactory {
    
    public Item createItem(String type, String ID, String name, char category, String description, LocalDate expiryDate, int qtyInStock, double price, Supplier supplier, String deviceType, String model, float dosage, String format, String unitSize) {
        switch (type.toUpperCase()) { // Convert type to uppercase for comparison
            case "DEVICE": // Use uppercase strings for comparison
                return new Device(deviceType, model, ID, name, category, description, expiryDate, qtyInStock, price, supplier);
            case "MEDICINE": // Use uppercase strings for comparison
                return new Medicine(dosage, format, unitSize, ID, name, category, description, expiryDate, qtyInStock, price, supplier);
            default:
                throw new IllegalArgumentException("Invalid item type");
        }
    }
}
