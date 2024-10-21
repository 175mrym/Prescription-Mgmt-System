/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmacymanagementsystem.Model;

import com.mycompany.pharmacymanagementsystem.*;
import java.util.*;


/**
 *
 * @author fatmaaldarwish
 */
public class Supplier {
    
    private String id;
    private String name;
    private String contactInfo;
    private String password;
    private static Supplier theInstance = null;
    private List<Item> suppliedItems; // List of items supplied by the supplier


    //the constructor is private as its a singlton pattern
    private Supplier() {
    }

    public Supplier(String id, String name, String contactInfo, String password) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
        this.password = password;
    }
        public Supplier(String id, String name, String contactInfo) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public Supplier(String id, String name, String contactInfo, String password, List<Item> suppliedItems) {
        this.id = id;
        this.name = name;
        this.contactInfo = contactInfo;
        this.password = password;
        this.suppliedItems = suppliedItems;
    }
        
        
    public static Supplier getInstance() {
        if (theInstance == null) {
            theInstance = new Supplier();
        }

        return theInstance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Item> getSuppliedItems() {
        return suppliedItems;
    }

    public void setSuppliedItems(List<Item> suppliedItems) {
        this.suppliedItems = suppliedItems;
    }
   
    @Override
    public String toString() {
        return "Supplier{" + "Supplier id=" + id + ", Supplier name=" + name + ", contact Info=" + contactInfo + '}';
    }
    
    
}
