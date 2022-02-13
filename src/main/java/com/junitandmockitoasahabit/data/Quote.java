/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.junitandmockitoasahabit.data;

/**
 *
 * @author AntonGolovin
 */
public class Quote {
    
    private String text;
    private int id;
    private int ofTotalIds;
    
    public Quote(int ids) {
        this.ofTotalIds = ids;
    }
    
    public String getText() {
        return this.text;
    }
    
    public void setText(String text) {
        this.text = text;
    }

    public void setId(int aInt) {
        this.id = aInt;
    }
    
    public int getId() {
        return this.id;
    }
    
    public int getTotalIds() {
        return this.ofTotalIds;
    }
    
}
