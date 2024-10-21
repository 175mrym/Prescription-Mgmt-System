/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmacymanagementsystem.DAO;
import com.mycompany.pharmacymanagementsystem.Model.*;
import java.sql.*;
import java.util.*;

/**
 *
 * @author maryamwaleed
 */
public class InsightsDAO {
    // Method to retrieve total number of prescriptions
     public int getTotalPrescriptions() throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        int totalPrescriptions = 0;

        try {
            conn = DBConnection.getConnection();
            String sql = "SELECT COUNT(*) AS total FROM Prescription";
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                totalPrescriptions = rs.getInt("total");
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

        return totalPrescriptions;
    }
    // Method to fetch most prescribed items
public List<List<Object>> getMostPrescribedItems() {
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;
    List<List<Object>> mostPrescribedItems = new ArrayList<>();

    try {
        conn = DBConnection.getConnection();
        String sql = "SELECT ItemID, COUNT(*) AS PrescriptionCount FROM Prescription_Item GROUP BY ItemID ORDER BY PrescriptionCount DESC LIMIT 5;";
        pstmt = conn.prepareStatement(sql);
        rs = pstmt.executeQuery();

        while (rs.next()) {
            List<Object> itemData = new ArrayList<>();
            itemData.add(rs.getObject("ItemID"));
            itemData.add(rs.getObject("PrescriptionCount"));
            mostPrescribedItems.add(itemData);
        }
    } catch (SQLException e) {
        e.printStackTrace(); // Handle the exception properly in your application
    } finally {
        // Close resources in a finally block
        try {
            if (rs != null) {
                rs.close();
            }
            if (pstmt != null) {
                pstmt.close();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle the exception properly in your application
        }
    }
    return mostPrescribedItems;
}

    // Method to fetch items by supplier ID
public List<Object> getItemsBySupplier(String supplierId) throws SQLException {
    List<Object> itemData = new ArrayList<>();
    Connection conn = null;
    PreparedStatement pstmt = null;
    ResultSet rs = null;

    try {
        conn = DBConnection.getConnection();
        String sql = "SELECT i.ID, i.name AS item_name, i.category,  i.supplier as Supplier_ID , s.name AS supplier_name FROM Item AS i INNER JOIN Supplier AS s ON i.supplier = s.id WHERE s.id = ?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, supplierId);
        rs = pstmt.executeQuery();

        while (rs.next()) {
            Object[] rowData = new Object[5];
            rowData[0] = rs.getString("ID");
            rowData[1] = rs.getString("item_name");
            rowData[2] = rs.getString("category");
            rowData[3] = rs.getString("Supplier_ID");
            rowData[4] = rs.getString("supplier_name");
            itemData.add(rowData);
        }
    } finally {
        // Close resources in the finally block
        if (rs != null) rs.close();
        if (pstmt != null) pstmt.close();
        if (conn != null) conn.close();
    }

    return itemData;
}

    public Map<String, Integer> getInventoryDistributionByCategory() throws SQLException {
    Map<String, Integer> inventoryDistribution = new HashMap<>();

    Connection conn = null;
    PreparedStatement stmt = null;
    ResultSet rs = null;

    try {
        conn = DBConnection.getConnection();
        String sql = "SELECT i.category, COUNT(*) AS total_count " +
                     "FROM Item i " +
                     "GROUP BY i.category";
        stmt = conn.prepareStatement(sql);
        rs = stmt.executeQuery();

        // Iterate through the result set and add data to the map
        while (rs.next()) {
            String category = rs.getString("category");
            // Map category values to specified words
            String categoryName = mapCategoryToWord(category);
            int totalCount = rs.getInt("total_count");
            inventoryDistribution.put(categoryName, totalCount);
        }
    } finally {
        // Close the resources
        if (rs != null) {
            rs.close();
        }
        if (stmt != null) {
            stmt.close();
        }
        if (conn != null) {
            conn.close();
        }
    }

    return inventoryDistribution;
}

// Method to map category values to specified words
private String mapCategoryToWord(String category) {
    // You can define your own mapping logic here
    if ("M".equals(category)) {
        return "Medicine";
    } else if ("D".equals(category)) {
        return "Device";
    } else {
        return "Other";
    }
}


}


      