/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.junitandmockitoasahabit.data;

/**
 *
 * @author AntonGolovin
 */
public class JUnitAndMockitoAsAHabit_QuoteProvider {
    
    private static int totalQuotes;
    private int currentQuoteIndex = 0;
    
    private String fetch(int quoteIndex) {
        // fetch a quote from the db
        return null;
    }
    
    private void load() {
        // load quotes into in-memory db
    }
    
    private int random(int topValue) {
        // fetch a quote from the in-memory db
        return 0;
    }
    
    
    public JUnitAndMockitoAsAHabit_QuoteProvider() {
        // find out number of quotes from the in-memory db
        
    }
    
    public JUnitAndMockitoAsAHabit_Quote random() {
        return null;
    }
    
    public JUnitAndMockitoAsAHabit_Quote roundrobin() {
        return null;
    }
    
    public void reset() {
        this.currentQuoteIndex = 0;
    }
    
}
