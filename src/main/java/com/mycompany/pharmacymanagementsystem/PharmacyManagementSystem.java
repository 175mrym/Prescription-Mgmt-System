package com.mycompany.pharmacymanagementsystem;

import com.mycompany.pharmacymanagementsystem.DAO.*;
import com.mycompany.pharmacymanagementsystem.Model.*;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PharmacyManagementSystem {

    public static void main(String[] args) {
        // Create a PrescriptionDAO instance
        PrescriptionDAO prescriptionDAO = new PrescriptionDAO();
               
            // Define test data for the prescription
            int prescriptionID = 156;
            String patientName = "John Doe";
            String doctorName = "Dr. Smith";
            LocalDate datePrescribed = LocalDate.now();
       

        try {
            // Retrieve existing medicines/items from the database
            List<Item> existingItems = new ArrayList<>();
            // Assuming you have the IDs of existing medicines/items
            String medicineId1 = "1";
            String deviceId1 = "4";
            
            // Create instances of MedicineDAO and DeviceDAO
            MedicineDAO medicineDAO = new MedicineDAO();
            DeviceDAO deviceDAO = new DeviceDAO();
            
            // Fetch existing medicine/item from the database using their IDs
            Medicine medicine1 = medicineDAO.findMedicineById(medicineId1);
            Device device1 = deviceDAO.findDeviceById(deviceId1);
            
            // Check if medicine1 or device1 is null
            if (medicine1 == null) {
                System.out.println("Medicine with ID " + medicineId1 + " doesn't exist.");
                return;
            }
            if (device1 == null) {
                System.out.println("Device with ID " + deviceId1 + " doesn't exist.");
                return;
            }
            
            // Add existing medicines/items to the list
            existingItems.add(medicine1);
            existingItems.add(device1);
            
            // Create a Container to hold the prescription items
            Container<Item> itemsContainer = new Container<>();
            
            // Add existing items to the container
            itemsContainer.addAll(existingItems);
            
            // Call the AddPrescription method with the test data and container of items
            prescriptionDAO.AddPrescription(prescriptionID, patientName, doctorName, datePrescribed, itemsContainer);
            System.out.println("\n");
            System.out.println("\n");

            System.out.println("Prescription added successfully!");
        } catch (SQLException e) {
            System.err.println("Error occurred while adding prescription: " + e.getMessage());
        }

        System.out.println("\n");
        System.out.println("\n");
        

        // Create a supplier
        Supplier supplier = new Supplier("S001", "ABC Pharmaceuticals", "123-456-7890");

        // Create an item factory
        ItemFactory itemFactory = new ItemFactory();

        // Create some dummy items using the factory
        Item item1 = itemFactory.createItem("DEVICE", "I001", "Paracetamol", 'M', "Fever", LocalDate.now(), 100, 10.5, supplier, "Tablet", "Model A", 0, "", "");
        Item item2 = itemFactory.createItem("MEDICINE", "I002", "Ibuprofen", 'M', "Pain relief", LocalDate.now(), 50, 8.0, supplier, "", "", 10, "Tablet", "20mg");

        // Add the items to the supplier's list of supplied items
        List<Item> suppliedItems = new ArrayList<>();
        suppliedItems.add(item1);
        suppliedItems.add(item2);
        supplier.setSuppliedItems(suppliedItems);

        // Create an invoice with the supplier's details and the items supplied
        Invoice invoice = new Invoice(1001, LocalDate.now(), supplier);

        // Set the list of supplied items to the invoice
        invoice.setItems(suppliedItems);
        System.out.println("===================================================");
        System.out.println("\n");
        System.out.println("\n");


        // Print the details of the invoice
        System.out.println("Invoice details:");
        System.out.println("Invoice ID: " + invoice.getInvoiceID());
        System.out.println("Date: " + invoice.getDateIssued());
        System.out.println("Supplier ID: " + supplier.getId());
        System.out.println("Supplier Name: " + supplier.getName());
        System.out.println("Items Supplied:");
        for (Item item : invoice.getItems()) { // Iterate over the items in the invoice
          System.out.println(item);
        }
        double totalAmount = invoice.calculateTotalAmount();
        System.out.println("Total amount for this invoice: " + totalAmount);
    }
}
