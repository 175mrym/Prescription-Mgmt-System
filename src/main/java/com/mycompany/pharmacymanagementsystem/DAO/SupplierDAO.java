package com.mycompany.pharmacymanagementsystem.DAO;

import java.sql.*;
import java.util.*;
import com.mycompany.pharmacymanagementsystem.Model.*;

/**
 * Supplier Data Access Object (DAO)
 */
public class SupplierDAO {
    
 public Supplier findSupplierById(String suppId) throws SQLException {
    Connection conn = DBConnection.getConnection();
    PreparedStatement stmt = null;
    ResultSet rs = null;
    Supplier supplier = null;
    
    try {
        String querySQL = "SELECT * FROM Supplier WHERE id=?";
        stmt = conn.prepareStatement(querySQL);
        stmt.setString(1, suppId);
        rs = stmt.executeQuery();
       
        if (rs.next()) {
            String id = rs.getString("id");
            String name = rs.getString("name");
            String contactInfo = rs.getString("contactInfo");
            String password = rs.getString("password"); // Retrieve password from database
            
            supplier = new Supplier(id, name, contactInfo, password); // Set password in Supplier object
        }   
    } finally {
        // Close result set, statement, and the connection to the database
        if (rs != null) {
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        conn.close();
    }
    
    return supplier;
}

    
    public int addNewSupplier(String suppId, String suppName, String suppContactInfo, String password) throws SQLException {
    Connection conn = DBConnection.getConnection();
    String insertSQL = "INSERT INTO Supplier (id, name, contactInfo, password) VALUES (?, ?, ?, ?);";
    
    PreparedStatement pstmt = conn.prepareStatement(insertSQL);
    pstmt.setString(1, suppId);
    pstmt.setString(2, suppName);
    pstmt.setString(3, suppContactInfo);
    pstmt.setString(4, password); // Set the password
    
    int insertStatus = pstmt.executeUpdate();
    
    pstmt.close();
    conn.close();
    
    return insertStatus;
}

    
    public int updateSupplier(String suppId, String suppName, String suppContactInfo) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String updateSQL = "UPDATE Supplier SET name = ?, contactInfo = ? WHERE id = ?;";
        
        PreparedStatement pstmt = conn.prepareStatement(updateSQL);
        pstmt.setString(1, suppName);
        pstmt.setString(2, suppContactInfo);
        pstmt.setString(3, suppId);
        
        int updateStatus = pstmt.executeUpdate();
        
        pstmt.close();
        conn.close();
        
        return updateStatus;
    }
    
    public int deleteSupplier(String suppId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        String deleteSQL = "DELETE FROM Supplier WHERE id = ?;";
        
        PreparedStatement pstmt = conn.prepareStatement(deleteSQL);
        pstmt.setString(1, suppId);
        
        int deleteStatus = pstmt.executeUpdate();
        
        pstmt.close();
        conn.close();
        
        return deleteStatus;
    }

    public List<Supplier> getAllSupplier() throws SQLException {
        String sql = "SELECT * FROM Supplier;";
        
        Connection conn = DBConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        
        List<Supplier> suppList = new ArrayList<>();
        
        while (rs.next()) {
            String id = rs.getString("id");
            String name = rs.getString("name");
            String contactInfo = rs.getString("contactInfo");
            
            Supplier supplier = new Supplier(id, name, contactInfo);
            suppList.add(supplier);
        }
        
        rs.close();
        stmt.close();
        conn.close();
        
        return suppList;
    }

}
