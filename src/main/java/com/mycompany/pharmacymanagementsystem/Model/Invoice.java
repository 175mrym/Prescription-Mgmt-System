package com.mycompany.pharmacymanagementsystem.Model;

import java.time.LocalDate;
import java.util.List;

/**
 *
 * author amalalzahmi
 */
public class Invoice {
    private int invoiceID;
    private LocalDate dateIssued;
    private Supplier supplier; // Reference to the supplier who supplied the items
    private List<Item> items; // Reference to the list of items in the invoice

    public Invoice(int invoiceID, LocalDate dateIssued, Supplier supplier) {
        this.invoiceID = invoiceID;
        this.dateIssued = dateIssued;
        this.supplier = supplier;
    }

    public Invoice(int invoiceID, LocalDate dateIssued, Supplier supplier, List<Item> items) {
        this.invoiceID = invoiceID;
        this.dateIssued = dateIssued;
        this.supplier = supplier;
        this.items = items;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public LocalDate getDateIssued() {
        return dateIssued;
    }

    public void setDateIssued(LocalDate dateIssued) {
        this.dateIssued = dateIssued;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public double calculateTotalAmount() {
        double totalAmount = 0.0;
        for (Item item : items) {
            totalAmount += item.getPrice() * item.getQtyInStock();
        }
        return totalAmount;
    }

    @Override
    public String toString() {
        return "Invoice{" +
                "invoiceID=" + invoiceID +
                ", dateIssued=" + dateIssued +
                ", supplier=" + supplier +
                '}';
    }
}
