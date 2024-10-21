/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pharmacymanagementsystem.Exeption;

/**
 *
 * @author maryamwaleed
 */
public class ValidateException extends Exception{
     private String msg;


    public ValidateException(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "ValidateEmptyException{" + "msg=" + msg + '}';
    }


    
}
