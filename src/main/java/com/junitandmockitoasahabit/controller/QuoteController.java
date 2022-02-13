/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.junitandmockitoasahabit.controller;

import com.junitandmockitoasahabit.data.Quote;
import com.junitandmockitoasahabit.model.QuoteService;
import com.junitandmockitoasahabit.view.QuoteWindowView;

/**
 *
 * @author AntonGolovin
 */
public class QuoteController {
    
    private QuoteService service;
    private QuoteWindowView view;
    
    public QuoteController(QuoteWindowView view) throws Exception {
        try {
            this.service = new QuoteService();
            this.view = view;
        } catch (final Exception ex) {
            throw ex;
        }
    }
    
    public void random() {
        try {
            Quote q = this.service.randomQuote();
            view.setQuoteTextArea(q.getText());
            view.setQuoteLocationWithinQuotesProgressBar(0, q.getTotalIds(), q.getId());
        } catch (final Exception ex) {
            view.setQuoteTextArea(ex.getMessage());
            view.setQuoteLocationWithinQuotesProgressBar(0, 100, 0);
        }
    }
    
      public void roundrobin() {
        try {
            Quote q = this.service.roundrobinQuote();
            view.setQuoteTextArea(q.getText());
            view.setQuoteLocationWithinQuotesProgressBar(0, q.getTotalIds(), q.getId());
        } catch (final Exception ex) {
            view.setQuoteTextArea(ex.getMessage());
            view.setQuoteLocationWithinQuotesProgressBar(0, 100, 0);
        }
    }
      
      public void reset() {
        try {
            this.service.resetQuotes();
            view.setQuoteTextArea("Try me again -->");
            view.setQuoteLocationWithinQuotesProgressBar(0, 100, 0);
        } catch (final Exception ex) {
            view.setQuoteLocationWithinQuotesProgressBar(0, 100, 0);
            view.setQuoteTextArea(ex.getMessage());
        }
    }
      
       public void stop() {
        try {
            this.service.resetData();
        } catch (final Exception ex) {
            view.setQuoteLocationWithinQuotesProgressBar(0, 100, 0);
            view.setQuoteTextArea(ex.getMessage());
        }
    }
    
    
   
}
