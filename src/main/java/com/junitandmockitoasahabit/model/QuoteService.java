/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.junitandmockitoasahabit.model;

import com.junitandmockitoasahabit.data.Quote;
import com.junitandmockitoasahabit.data.QuoteDAO;

/**
 *
 * @author AntonGolovin
 */
public class QuoteService {
    
    private QuoteDAO dataDAO;
    
    public QuoteService() throws Exception {
        try {
            this.dataDAO = new QuoteDAO();
        } catch (final Exception ex) {
            throw ex;
        }
    }
    
    
    public Quote randomQuote() throws Exception {
        try {
            return this.dataDAO.random();
        } catch (final Exception ex) {
            throw ex;
        }
    }
    
    public Quote roundrobinQuote() throws Exception {
        try {
            return this.dataDAO.roundrobin();
        } catch (final Exception ex) {
            throw ex;
        }
    }
    
    public void resetQuotes() throws Exception {
        try {
            this.dataDAO.reset();
        } catch (final Exception ex) {
            throw ex;
        }
    }
    
    public void resetData() throws Exception {
        try {
            this.dataDAO.stop();
        } catch (final Exception ex) {
            throw ex;
        }
    }

    
}
