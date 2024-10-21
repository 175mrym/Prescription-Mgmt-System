/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmacymanagementsystem.DAO;
import java.sql.*;
import java.util.*;
import java.time.*; 
import com.mycompany.pharmacymanagementsystem.Model.*;
import java.time.format.DateTimeParseException;

/**
 *
 * @author maryamwaleed
 */
public class ItemDAO {
    // ========================READ======================
    // Method to find an item by ID
    /**
     The code fetches item details from a database using its ID, then creates an object representing the item.
     * Depending on its category ('M' for Medicine or 'D' for Device), 
     * it constructs 
     * the appropriate type of item object with associated supplier information.
     */
    public Item findItemById(String id) throws SQLException {
    Connection conn = DBConnection.getConnection();
    String sql = "SELECT * FROM Item WHERE ID=?";
    PreparedStatement pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, id);
    ResultSet rs = pstmt.executeQuery();
    Item item = null;

    if (rs.next()) {
        String name = rs.getString("name");
        String categoryStr = rs.getString("category");
        char category = categoryStr != null && !categoryStr.isEmpty() ? categoryStr.charAt(0) : ' '; // Default to space if category is null or empty
        String description = rs.getString("description");
        
        // Parse expiryDate as a string and then convert it to LocalDate
        // Parse expiryDate as a string and then convert it to LocalDate
        String expiryDateStr = rs.getString("expiryDate");
        LocalDate expiryDate = null; // Initialize to null

        try {
           if (expiryDateStr != null) {
           expiryDate = LocalDate.parse(expiryDateStr);
              } else {
                 // Handle the case where expiryDateStr is null (no action needed)
                }
                } catch (DateTimeParseException e) {
                   System.err.println("Error parsing expiry date: " + e.getMessage());
                  // Handle the error gracefully, e.g., log the error and proceed with null expiry date
                }

        int qtyInStock = rs.getInt("qtyInStock");
        double price = rs.getDouble("price");
        String supplierId = rs.getString("supplier");
        
        SupplierDAO supplierDAO = new SupplierDAO();
        Supplier supplier = supplierDAO.findSupplierById(supplierId);

        switch (category) {
            case 'M':
                item = new Medicine(id, name, category, description, expiryDate, qtyInStock, price, supplier);
                break;
            case 'D':
                item = new Device(id, name, category, description, expiryDate, qtyInStock, price, supplier);
                break;
            default:
                throw new IllegalArgumentException("Invalid category: " + category);
        }
    }

    rs.close();
    pstmt.close();
    conn.close();

    return item;
}

    //create a method to find an items provided by supplier by Using a regaular statement.

public List<Item> getAllItems(String sid) throws SQLException {
    // Step 1: Establish connection
    Connection conn = DBConnection.getConnection();

    // Step 2: Write statement & SQL
    String querySQL = "SELECT * FROM Item WHERE supplier = ?";
    
    // Create the list to hold items
    ArrayList<Item> allItems = new ArrayList<>();

    try (PreparedStatement pstmt = conn.prepareStatement(querySQL)) {
        // Step 3: Set parameters
        pstmt.setString(1, sid);

        // Step 4: Execute the statement
        try (ResultSet rs = pstmt.executeQuery()) {
            while (rs.next()) {
                // Retrieve item details from the result set
                String id = rs.getString("ID");
                String name = rs.getString("name");
                char category = rs.getString("category").charAt(0);
                String description = rs.getString("description");
                String expiryDateStr = rs.getString("expiryDate");
                LocalDate expiryDate = null; // Initialize to null

if (expiryDateStr != null) {
    try {
        long timestamp = Long.parseLong(expiryDateStr);
        Instant instant = Instant.ofEpochMilli(timestamp);
        expiryDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
    } catch (NumberFormatException e) {
        System.err.println("Error parsing expiry date timestamp: " + e.getMessage());
        // Handle the error gracefully, e.g., log the error and proceed with null expiry date
    }
}
        
                  
                int qtyInStock = rs.getInt("qtyInStock");
                double price = rs.getDouble("price");
                sid = rs.getString("supplier");

                // Determine the subclass and create the appropriate object
                Item item;
                switch (category) {
                    case 'M':
                        item = new Medicine(id, name, category, description, expiryDate, qtyInStock, price, new SupplierDAO().findSupplierById(sid));
                        break;
                    case 'D':
                        item = new Device(id, name, category, description, expiryDate, qtyInStock, price, new SupplierDAO().findSupplierById(sid));
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid category: " + category);
                }

                // Add the item to the list
                allItems.add(item);
            }
        }
    }

    // Step 5: Close the connection
    conn.close();

    return allItems;
}
public List<Item> getAllItems() throws SQLException {
    // Step 1: Establish connection
    Connection conn = DBConnection.getConnection();
    Statement stmt = conn.createStatement();
    // Step 2: Write statement & SQL
    String querySQL = "SELECT * FROM Item;";
    ResultSet rs = stmt.executeQuery(querySQL);
    // Create the list to hold items
    ArrayList<Item> allItems = new ArrayList<>();
    while (rs.next()) {
    // Retrieve item details from the result set
    String id = rs.getString("ID");
    String name = rs.getString("name");
    char category = rs.getString("category").charAt(0);
    String description = rs.getString("description");
    // Retrieve the expiry date string from the result set
    // Parse expiryDate as a string and then convert it to LocalDate
    String expiryDateStr = rs.getString("expiryDate");
    LocalDate expiryDate = null; // Initialize to null

    if (expiryDateStr != null) {
        try {
            // Parse the expiry date string directly to LocalDate
            expiryDate = LocalDate.parse(expiryDateStr);
        } catch (DateTimeParseException e) {
            System.err.println("Error parsing expiry date: " + e.getMessage());
            // Handle the error gracefully, e.g., log the error and proceed with null expiry date
        }
    }
    
        int qtyInStock = rs.getInt("qtyInStock");
        double price = rs.getDouble("price");
        String sid = rs.getString("supplier");

        // Determine the subclass and create the appropriate object
        Item item;
        switch (category) {
            case 'M':
                item = new Medicine(id, name, category, description, expiryDate, qtyInStock, price, new SupplierDAO().findSupplierById(sid));
                break;
            case 'D':
                item = new Device(id, name, category, description, expiryDate, qtyInStock, price, new SupplierDAO().findSupplierById(sid));
                break;
            default:
                throw new IllegalArgumentException("Invalid category: " + category);
        }

        // Add the item to the list
        allItems.add(item);
    }
    
    // Step 5: Close the connection
    rs.close();
    stmt.close();
    conn.close();        
    
    return allItems;
}
     // New method to get all medicines
    public List<Medicine> getAllMedicines() throws SQLException {
        // Step 1: Establish connection
        Connection conn = DBConnection.getConnection();
        Statement stmt = conn.createStatement();
        // Step 2: Write statement & SQL
        String querySQL = "SELECT * FROM Item WHERE category = 'M';"; // Filter by category 'M' for medicines
        ResultSet rs = stmt.executeQuery(querySQL);
        // Create the list to hold medicines
        ArrayList<Medicine> allMedicines = new ArrayList<>();
        while (rs.next()) {
            // Retrieve medicine details from the result set
            String id = rs.getString("ID");
            String name = rs.getString("name");
            char category = rs.getString("category").charAt(0);
            String description = rs.getString("description");
            // Retrieve the expiry date string from the result set
            // Parse expiryDate as a string and then convert it to LocalDate
            String expiryDateStr = rs.getString("expiryDate");
            LocalDate expiryDate = null; // Initialize to null

            if (expiryDateStr != null) {
                try {
                    // Parse the expiry date string directly to LocalDate
                    expiryDate = LocalDate.parse(expiryDateStr);
                } catch (DateTimeParseException e) {
                    System.err.println("Error parsing expiry date: " + e.getMessage());
                    // Handle the error gracefully, e.g., log the error and proceed with null expiry date
                }
            }

            int qtyInStock = rs.getInt("qtyInStock");
            double price = rs.getDouble("price");
            String sid = rs.getString("supplier");

            // Create a Medicine object
            Medicine medicine = new Medicine(id, name, category, description, expiryDate, qtyInStock, price, new SupplierDAO().findSupplierById(sid));
            // Add the medicine to the list
            allMedicines.add(medicine);
        }
        
        // Step 5: Close the connection
        rs.close();
        stmt.close();
        conn.close();        

        return allMedicines;
    }
         // New method to get all Devices
    public List<Device> getAllDevices() throws SQLException {
        // Step 1: Establish connection
        Connection conn = DBConnection.getConnection();
        Statement stmt = conn.createStatement();
        // Step 2: Write statement & SQL
        String querySQL = "SELECT * FROM Item WHERE category = 'D';"; // Filter by category 'M' for medicines
        ResultSet rs = stmt.executeQuery(querySQL);
        // Create the list to hold medicines
        ArrayList<Device> allDevices = new ArrayList<>();
        while (rs.next()) {
            // Retrieve medicine details from the result set
            String id = rs.getString("ID");
            String name = rs.getString("name");
            char category = rs.getString("category").charAt(0);
            String description = rs.getString("description");
            // Retrieve the expiry date string from the result set
            // Parse expiryDate as a string and then convert it to LocalDate
            String expiryDateStr = rs.getString("expiryDate");
            LocalDate expiryDate = null; // Initialize to null

            if (expiryDateStr != null) {
                try {
                    // Parse the expiry date string directly to LocalDate
                    expiryDate = LocalDate.parse(expiryDateStr);
                } catch (DateTimeParseException e) {
                    System.err.println("Error parsing expiry date: " + e.getMessage());
                    // Handle the error gracefully, e.g., log the error and proceed with null expiry date
                }
            }

            int qtyInStock = rs.getInt("qtyInStock");
            double price = rs.getDouble("price");
            String sid = rs.getString("supplier");

            // Create a Medicine object
            Device device = new Device(id, name, category, description, expiryDate, qtyInStock, price, new SupplierDAO().findSupplierById(sid));
            // Add the medicine to the list
            allDevices.add(device);
        }
        
        // Step 5: Close the connection
        rs.close();
        stmt.close();
        conn.close();        

        return allDevices;
    }

    // ========================ADD======================
public int addNewItem(String id, String name, char category, String description, LocalDate expiryDate, int qtyInStock, double price, String supplierId) throws SQLException {
    // Step 1: Establish connection
    Connection conn = DBConnection.getConnection();
    
    try {
        // Step 2: Define SQL statement
        String querySQL = "INSERT INTO Item (id, name, category, description, expiryDate, qtyInStock, price, supplier) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        
        // Step 3: Prepare the statement
        PreparedStatement pstmt = conn.prepareStatement(querySQL);
        
        // Step 4: Set parameter values
        pstmt.setString(1, id);
        pstmt.setString(2, name);
        pstmt.setString(3, String.valueOf(category)); // Convert char to String
        pstmt.setString(4, description);
        if (expiryDate != null) {
            pstmt.setObject(5, expiryDate); // Use setObject to set LocalDate directly
        } else {
            pstmt.setNull(5, Types.DATE); // Set expiry date to null
        }
        pstmt.setInt(6, qtyInStock);
        pstmt.setDouble(7, price);
        pstmt.setString(8, supplierId); // Use supplier ID
        
        // Step 5: Execute the statement
        int status = pstmt.executeUpdate();
        
        // Step 6: Close resources
        pstmt.close();
        conn.close();
        
        return status;
    } catch (SQLException e) {
        // Step 7: Handle exceptions
        e.printStackTrace();
        return -1; // Return -1 to indicate an error occurred
    } 
}



    // ========================UPDATE======================
public int updateItem(String id, String name, char category, String description, LocalDate expiryDate, int qtyInStock, double price, String supplierId) throws SQLException {
    // Step 1: Establish connection
    Connection conn = DBConnection.getConnection();
    
    try {
        // Step 2: Define SQL statement for update
        String querySQL = "UPDATE Item SET name = ?, category = ?, description = ?, expiryDate = ?, qtyInStock = ?, price = ?, supplier = ? WHERE id = ?";
        
        // Step 3: Prepare the statement
        PreparedStatement pstmt = conn.prepareStatement(querySQL);
        
        // Step 4: Set parameter values
        pstmt.setString(1, name); // Set name at index 1
        pstmt.setString(2, String.valueOf(category)); // Set category at index 2
        pstmt.setString(3, description); // Set description at index 3
        pstmt.setObject(4, expiryDate); // Set expiry date at index 4
        pstmt.setInt(5, qtyInStock); // Set quantity in stock at index 5
        pstmt.setDouble(6, price); // Set price at index 6
        pstmt.setString(7, supplierId); // Set supplier ID at index 7
        pstmt.setString(8, id); // Set ID for WHERE clause at index 8
        

        
        // Step 5: Execute the statement
        int status = pstmt.executeUpdate();
        
        // Step 6: Close resources
        pstmt.close();
        conn.close();
        
        return status;
    } catch (SQLException e) {
        // Step 7: Handle exceptions
        e.printStackTrace();
        return -1; // Return -1 to indicate an error occurred
    } 
}

    // ========================DELETE======================
    public int deleteItem(String id) throws SQLException {
    // Step 1: Establish connection
    Connection conn = DBConnection.getConnection();
    
    try {
        // Step 2: Define SQL statement
        String querySQL = "DELETE FROM Item WHERE id =?";
        
        // Step 3: Prepare the statement
        PreparedStatement pstmt = conn.prepareStatement(querySQL);
        
        // Step 4: Set parameter values
        pstmt.setString(1, id);
   
        // Step 5: Execute the statement
        int status = pstmt.executeUpdate();
        
        // Step 6: Close resources
        pstmt.close();
        conn.close();
        
        return status;
    } catch (SQLException e) {
        // Step 7: Handle exceptions
        e.printStackTrace();
        return -1; // Return -1 to indicate an error occurred
    } 
}

}

