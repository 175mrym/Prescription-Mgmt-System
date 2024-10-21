package com.mycompany.pharmacymanagementsystem.Model;

import java.util.ArrayList;
import java.util.List;

// Generic class Container that can hold a list of any type of items
public class Container<T> {

    private List<T> items;

    // Constructor to initialize the list
    public Container() {
        items = new ArrayList<>();
    }

    // Method to add an item to the container
    public void add(T item) {
        items.add(item);
    }

    // Method to remove an item from the container
    public void remove(T item) {
        items.remove(item);
    }

    // Method to retrieve the list of items
    public List<T> getItems() {
        return items;
    }
    
    // Add the addAll method to the Container class
public void addAll(List<T> itemList) {
    items.addAll(itemList);
}


    // Method to print the contents of the container
    public void printContents() {
        System.out.println("Container contents:");
        for (T item : items) {
            System.out.println(item);
        }
    }
}
