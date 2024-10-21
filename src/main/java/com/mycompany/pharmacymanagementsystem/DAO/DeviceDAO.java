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
public class DeviceDAO {
    public Device findDeviceById(String id) throws SQLException {
    Connection conn = DBConnection.getConnection();
    String sql = "SELECT Device.*, Item.* FROM Device INNER JOIN Item ON Device.ID = Item.ID WHERE Device.ID=?";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, id);
    ResultSet rs = pstmt.executeQuery();
    Device device = null;

    if (rs.next()) {
        // Extract attributes specific to Device
        String deviceType = rs.getString("deviceType");
        String model = rs.getString("model");

        // Extract common attributes from the Item table
        String name = rs.getString("name");
        char category = rs.getString("category").charAt(0);
        String description = rs.getString("description");
        LocalDate expiryDate = null; // Initialize to null

        // Parse expiryDate as a string and then convert it to LocalDate
        String expiryDateStr = rs.getString("expiryDate");
        if (expiryDateStr != null) {
            expiryDate = LocalDate.parse(expiryDateStr);
        }        int qtyInStock = rs.getInt("qtyInStock");
        double price = rs.getDouble("price");
        String supplierId = rs.getString("supplier");

        // Fetch supplier using SupplierDAO
        SupplierDAO supplierDAO = new SupplierDAO();
        Supplier supplier = supplierDAO.findSupplierById(supplierId);

        // Create the Device object
        device = new Device(deviceType, model, id, name, category, description, expiryDate, qtyInStock, price, supplier);
    }

    rs.close();
    pstmt.close();
    conn.close();

    return device;
}
    public List<Device> getAllDevices() throws SQLException {
    Connection conn = DBConnection.getConnection();
    String sql = "SELECT Device.*, Item.name, Item.category, Item.description, Item.qtyInStock, Item.price, Item.supplier, Item.expiryDate FROM Device INNER JOIN Item ON Device.ID = Item.ID";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    ResultSet rs = pstmt.executeQuery();
    
    List<Device> devicesList = new ArrayList<>();

    while (rs.next()) {
        String id = rs.getString("ID");
        String deviceType = rs.getString("deviceType");
        String model = rs.getString("model");
        
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
        Device device = new Device(deviceType, model, id, name, category, description, expiryDate, qtyInStock, price, supplier);
        
        devicesList.add(device);
    }

    rs.close();
    pstmt.close();
    conn.close();

    return devicesList;
}
     public int addDevice(Device device) throws SQLException {
        // Check if the corresponding Item record exists
        ItemDAO itemDAO = new ItemDAO();
        Item item = itemDAO.findItemById(device.getID());
        if (item == null) {
            // If the Item record doesn't exist,
            System.err.println("Error: Corresponding Item record not found for the Device. Aborting insertion.");
            return -1;
        }

        // If the Item record exists, proceed with inserting the Device record
        Connection conn = DBConnection.getConnection();
        String sql = "INSERT INTO Device (ID, deviceType, model) VALUES (?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, device.getID());
        pstmt.setString(2, device.getDeviceType());
        pstmt.setString(3, device.getModel());

        // Execute the insert statement
    int rowsAffected = pstmt.executeUpdate();

        // Clean up resources
        pstmt.close();
        conn.close();

        System.out.println("Device added successfully.");
        return rowsAffected;

    }
     public int updateDevice(Device device) throws SQLException {
    // Check if the corresponding Item record exists
    ItemDAO itemDAO = new ItemDAO();
    Item item = itemDAO.findItemById(device.getID());
    if (item == null) {
        // If the Item record doesn't exist, 
        System.err.println("Error: Corresponding Item record not found for the Device.");
        return -1;
    }
    Connection conn = DBConnection.getConnection();
    String sql = "UPDATE Device SET deviceType=?, model=? WHERE ID=?";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, device.getDeviceType());
    pstmt.setString(2, device.getModel());
    pstmt.setString(3, device.getID());

    // Execute the update statement
    int rowsAffected = pstmt.executeUpdate();

    // Clean up resources
    pstmt.close();
    conn.close();

    if (rowsAffected > 0) {
        System.out.println("Device updated successfully.");
    } else {
        System.err.println("Error: Failed to update device. No rows affected.");
    }
    return rowsAffected;
}   
}
