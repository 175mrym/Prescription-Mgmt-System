/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmacymanagementsystem.DAO;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author maryamwaleed
 */
public class DBConnection {
     public static Connection getConnection() throws SQLException {
        //Change the path the database (.db) file on your machine...
        //Just by changing the URL you point to another database
        String dbURL = "jdbc:sqlite:PharamcyDB.db";
        Connection conn = DriverManager.getConnection(dbURL);
        return conn;
    }
}
