package com.mycompany.pharmacymanagementsystem.Model;
import com.mycompany.pharmacymanagementsystem.*;
import java.time.LocalDate;


/**
 *
 * @author maryamwaleed
 */
public abstract class Item implements Searchable, Supplyable, Purchaseable{
    
    private String ID;
    private String name;
    private char category;
    private String description;
    private LocalDate expiryDate;
    private int qtyInStock;
    private double price;
    private Supplier supplier; // Reference to the Supplier class


    public Item(String ID, String name, char category, String description, LocalDate expiryDate, int qtyInStock, double price, Supplier supplier) {
        this.ID = ID;
        this.name = name;
        this.category = category;
        this.description = description;
        this.expiryDate = expiryDate;
        this.qtyInStock = qtyInStock;
        this.price = price;
        this.supplier = supplier; // Assign the supplier

    }

    public Item() {
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public char getCategory() {
        return category;
    }

    public void setCategory(char category) {
        this.category = category;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }
    
    public int getQtyInStock() {
        return qtyInStock;
    }

    public void setQtyInStock(int qtyInStock) {
        this.qtyInStock = qtyInStock;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
    
    //This method should multiply the price by qtyInStock to get the base price.
    public abstract double calculateTotalPrice();
  
    public abstract boolean checkExpiry();

    //This method should return a formatted string containing common details. 
    @Override
     public String toString() {
        return "Item ID: "+ ID +
                "\nItem Name: " + name +
                "\nItem Category: " + category +
                "\nItem Description: " + description +
                "\nItem Expiry date: " + expiryDate +
                "\nItem Stock: " + qtyInStock +
                "\nItem Price: " + price +
                "\nSupplier: " + supplier.getId(); // Include supplier details
    }
}