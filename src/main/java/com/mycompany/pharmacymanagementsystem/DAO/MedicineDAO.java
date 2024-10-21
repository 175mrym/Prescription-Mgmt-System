/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmacymanagementsystem.DAO;
import com.mycompany.pharmacymanagementsystem.Model.*;
import java.sql.*;
import java.time.*;
import java.util.*;
/**
 *
 * @author maryamwaleed
 */
public class MedicineDAO {
    // Method to find medicine by ID
    public Medicine findMedicineById(String id) throws SQLException {
    Connection conn = DBConnection.getConnection();
    String sql = "SELECT Medicine.*, Item.* FROM Medicine INNER JOIN Item ON Medicine.ID = Item.ID WHERE Medicine.ID=?";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, id);
    ResultSet rs = pstmt.executeQuery();
    Medicine medicine = null;

    if (rs.next()) {
        float dosage = rs.getFloat("dosage");
        String format = rs.getString("format");
        String unitSize = rs.getString("unitSize");

        // Fetch the common attributes from the Item table
        String name = rs.getString("name");
        char category = rs.getString("category").charAt(0);
        String description = rs.getString("description");
        LocalDate expiryDate = null; // Initialize to null

        // Parse expiryDate as a string and then convert it to LocalDate
        String expiryDateStr = rs.getString("expiryDate");
        if (expiryDateStr != null) {
            expiryDate = LocalDate.parse(expiryDateStr);
        }

        int qtyInStock = rs.getInt("qtyInStock");
        double price = rs.getDouble("price");
        String supplierId = rs.getString("supplier");

        // Fetch supplier using SupplierDAO
        SupplierDAO supplierDAO = new SupplierDAO();
        Supplier supplier = supplierDAO.findSupplierById(supplierId);

        // Create the Medicine object
        medicine = new Medicine(dosage, format, unitSize, id, name, category, description, expiryDate, qtyInStock, price, supplier);
    }

    rs.close();
    pstmt.close();
    conn.close();

    return medicine;
}

public List<Medicine> getAllMedicines() throws SQLException {
    Connection conn = DBConnection.getConnection();
    String sql = "SELECT Medicine.*, Item.name, Item.category, Item.description, Item.qtyInStock, Item.price, Item.supplier, Item.expiryDate FROM Medicine INNER JOIN Item ON Medicine.ID = Item.ID";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    ResultSet rs = pstmt.executeQuery();
    
    List<Medicine> medicines = new ArrayList<>();

    while (rs.next()) {
        String id = rs.getString("ID");
        float dosage = rs.getFloat("dosage");
        String format = rs.getString("format");
        String unitSize = rs.getString("unitSize");
        
        String name = rs.getString("name");
        char category = rs.getString("category").charAt(0);
        String description = rs.getString("description");
        
        LocalDate expiryDate = null; // Initialize to null
        
        // Check if expiry date string is not null
        String expiryDateStr = rs.getString("expiryDate");
        if (expiryDateStr != null) {
            // Parse the expiry date
            expiryDate = LocalDate.parse(expiryDateStr);
        }

        int qtyInStock = rs.getInt("qtyInStock");
        double price = rs.getDouble("price");
        String supplierId = rs.getString("supplier");
        
        // Fetch supplier using SupplierDAO
        SupplierDAO supplierDAO = new SupplierDAO();
        Supplier supplier = supplierDAO.findSupplierById(supplierId);

        // Create the Medicine object
        Medicine medicine = new Medicine(dosage, format, unitSize, id, name, category, description, expiryDate, qtyInStock, price, supplier);
        
        medicines.add(medicine);
    }

    rs.close();
    pstmt.close();
    conn.close();

    return medicines;
}

    public int addMedicine(Medicine medicine) throws SQLException {
    // Check if the corresponding Item record exists
    ItemDAO itemDAO = new ItemDAO();
    Item item = itemDAO.findItemById(medicine.getID());
    if (item == null) {
        // If the Item record doesn't exist, you might want to handle this situation accordingly
        System.err.println("Error: Corresponding Item record not found for the Medicine. Aborting insertion.");
        return -1;
    }

    // If the Item record exists, proceed with inserting the Medicine record
    Connection conn = DBConnection.getConnection();
    String sql = "INSERT INTO Medicine (ID, dosage, format, unitSize) VALUES (?, ?, ?, ?)";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, medicine.getID());
    pstmt.setFloat(2, medicine.getDosage());
    pstmt.setString(3, medicine.getFormat());
    pstmt.setString(4, medicine.getUnitSize());

    // Execute the insert statement
    int rowsAffected = pstmt.executeUpdate();

    // Clean up resources
    pstmt.close();
    conn.close();
        System.out.println("Medicine added successfully.");

        return rowsAffected; // return the number of rows affected by the insert
}
    
    public int updateMedicine(Medicine medicine) throws SQLException {
    // Check if the corresponding Item record exists
    ItemDAO itemDAO = new ItemDAO();
    Item item = itemDAO.findItemById(medicine.getID());
    if (item == null) {
        // If the Item record doesn't exist, handle this situation accordingly
        System.err.println("Error: Corresponding Item record not found for the Medicine. Aborting update.");
        return -1;
    }

    // If the Item record exists, proceed with updating the Medicine record
    Connection conn = DBConnection.getConnection();
    String sql = "UPDATE Medicine SET dosage = ?, format = ?, unitSize = ? WHERE ID = ?";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setFloat(1, medicine.getDosage());
    pstmt.setString(2, medicine.getFormat());
    pstmt.setString(3, medicine.getUnitSize());
    pstmt.setString(4, medicine.getID());

    // Execute the update statement
    int rowsAffected = pstmt.executeUpdate();

    // Clean up resources
    pstmt.close();
    conn.close();

    System.out.println("Medicine updated successfully.");
    return rowsAffected;
}






}
