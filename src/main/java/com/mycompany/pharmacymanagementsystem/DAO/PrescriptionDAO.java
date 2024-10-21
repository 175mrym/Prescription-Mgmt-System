package com.mycompany.pharmacymanagementsystem.DAO;

import com.mycompany.pharmacymanagementsystem.Model.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate; // Import LocalDate
import java.time.format.DateTimeParseException;

public class PrescriptionDAO {
public void AddPrescription(int prescriptionID, String patientName, String doctorName, LocalDate datePrescribed, Container<Item> itemsContainer) throws SQLException {
    Connection conn = DBConnection.getConnection();
    
    try {
        // Save prescription details
        String insertPrescriptionQuery = "INSERT INTO Prescription (prescriptionID, patientName, doctorName, datePrescribed) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(insertPrescriptionQuery)) {
            ps.setInt(1, prescriptionID);
            ps.setString(2, patientName);
            ps.setString(3, doctorName);
            ps.setObject(4, datePrescribed); // Use setObject to set LocalDate directly
            ps.executeUpdate();
        }
        
        // Save prescription items
        String insertPrescriptionItemQuery = "INSERT INTO Prescription_Item (prescriptionID, itemID) VALUES (?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(insertPrescriptionItemQuery)) {
            for (Item item : itemsContainer.getItems()) {
                ps.setInt(1, prescriptionID);
                ps.setString(2, item.getID());
                ps.executeUpdate();
            }
        }
    } finally {
        // Close the connection
        conn.close();
    }
}
    // Method to find a prescription by its ID
public Prescription findPrescriptionById(int prescriptionID) throws SQLException {
    Connection conn = DBConnection.getConnection();
    String sql = "SELECT * FROM Prescription WHERE prescriptionID=?";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setInt(1, prescriptionID);
    ResultSet rs = pstmt.executeQuery();
    Prescription prescription = null;

    if (rs.next()) {
        String patientName = rs.getString("patientName");
        String doctorName = rs.getString("doctorName");
        LocalDate datePrescribed = null; // Initialize to null
        // Retrieve the expiry date string from the result set
        String DateStr = rs.getString("datePrescribed");
        if (DateStr != null) {
            try {
               
                // Parse the expiry date string directly to LocalDate
                datePrescribed = LocalDate.parse(DateStr);
            } catch (DateTimeParseException e) {
                System.err.println("Error parsing expiry date: " + e.getMessage());
                // Handle the error gracefully, e.g., log the error and proceed with null expiry date
            }
        }

        // Create a new Prescription object with the retrieved data
        prescription = new Prescription(prescriptionID, patientName, doctorName, null, datePrescribed); // List of items is null for now
    }

    // Close resources
    rs.close();
    pstmt.close();
    conn.close();

    return prescription;
}

    // Method to find items associated with a prescription by its ID
    public List<List<Object>> findItemsByPrescriptionId(int prescriptionID) throws SQLException {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    List<List<Object>> prescriptionItems = new ArrayList<>();

    try {
        conn = DBConnection.getConnection();
        String sql = "SELECT prescriptionID, itemID FROM Prescription_Item WHERE prescriptionID = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, prescriptionID);
        rs = pstmt.executeQuery();

        while (rs.next()) {
            int pid = rs.getInt("prescriptionID");
            String itemID = rs.getString("itemID");
            List<Object> pair = new ArrayList<>();
            pair.add(pid);
            pair.add(itemID);
            prescriptionItems.add(pair);
        }
    } finally {
        // Close resources
        if (rs != null) {
            rs.close();
        }
        if (pstmt != null) {
            pstmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    return prescriptionItems;
}





    
    // Method to delete a prescription by its ID
    public int deletePrescriptionById(int prescriptionID) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        int rowsAffected = 0;
        
        try {
            conn = DBConnection.getConnection();
            conn.setAutoCommit(false); // Disable auto-commit
            
            // Delete prescription items first to avoid violating foreign key constraints
            String deleteItemsSQL = "DELETE FROM Prescription_Item WHERE prescriptionID=?";
            pstmt = conn.prepareStatement(deleteItemsSQL);
            pstmt.setInt(1, prescriptionID);
            pstmt.executeUpdate();
            pstmt.close();
            
            // Now delete the prescription
            String deletePrescriptionSQL = "DELETE FROM Prescription WHERE prescriptionID=?";
            pstmt = conn.prepareStatement(deletePrescriptionSQL);
            pstmt.setInt(1, prescriptionID);
            rowsAffected = pstmt.executeUpdate();
            
            // Commit the transaction
            conn.commit();
        } catch (SQLException e) {
            if (conn != null) {
                conn.rollback(); // Rollback the transaction if an exception occurs
            }
            throw e;
        } finally {
            // Close resources
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.setAutoCommit(true); // Re-enable auto-commit
                conn.close();
            }
        }
        
        return rowsAffected;
    }
    
}
