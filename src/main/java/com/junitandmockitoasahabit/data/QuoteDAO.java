/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.junitandmockitoasahabit.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author AntonGolovin
 */
public class QuoteDAO {
    
    private static final boolean DEBUG = false;
    
    private static final int QUOTES_TO_CREATE = 100;
    
    private int totalQuotes;
    private int currentQuoteIndex;
    
    private Connection conn;
    
     public QuoteDAO() throws Exception {
        connect();
        load();
        this.totalQuotes = total();
        this.currentQuoteIndex = 1;
        
    }
    
    private Quote fetch(int quoteIndex) throws Exception {
        
        try {
        
            if(quoteIndex < 1 || quoteIndex > this.totalQuotes)
                throw new Exception("invalid quoteIndex value passed in");
        
            if(conn.isValid(1000)) {
                Statement stmt0 = conn.createStatement();
                ResultSet rs0 = stmt0.executeQuery("SELECT A.ID, A.QUOTE FROM QUOTES A WHERE A.ID = " + quoteIndex + ";");
                rs0.next();
                final Quote q = new Quote(this.totalQuotes);
                final int id = rs0.getInt("ID"); 
                q.setId(id);
                final String quote = rs0.getString("QUOTE");
                if (DEBUG) 
                    System.out.println("fetch(): found " + quote);
                q.setText(quote);
                return q;
            } else
                throw new Exception("Invalid connection");
        } catch (Exception ex) {
            throw ex;
        }
        
    }
    
    private void load() throws Exception {
        try {
            if(conn.isValid(1000)) {
                if (DEBUG) 
                    System.out.println("Connection " + conn + " is valid");
                Statement stmt0 = conn.createStatement();
                final int stmt0success = stmt0.executeUpdate("CREATE TABLE QUOTES (ID INT NOT NULL, QUOTE VARCHAR(255) NOT NULL);");
                if (DEBUG) 
                    System.out.println("Created table quotes correctly: " + stmt0success);                
                PreparedStatement stmt1 = conn.prepareStatement("INSERT INTO QUOTES (ID, QUOTE) VALUES (?, ?);");
                for (int i = 1; i <= QUOTES_TO_CREATE; i++) {
                    stmt1.setLong(1, i);
                    stmt1.setString(2, "Quote" + i + " is being displayed.");
                    final int stmt1UpdatedRows = stmt1.executeUpdate();
                    if (DEBUG) 
                        System.out.println("Updated rows for index " + i + ": " + stmt1UpdatedRows);
                }
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    private int total() throws Exception {
        
        try {
            if(conn.isValid(1000)) {
                if (DEBUG) 
                    System.out.println("total(): Connection " + conn + " is valid");
                Statement stmt0 = conn.createStatement();
                final ResultSet rs0 = stmt0.executeQuery("SELECT COUNT(A.*) as NUM_QUOTES FROM QUOTES A");
                rs0.next();
                final int total = rs0.getInt("NUM_QUOTES");
                if (DEBUG) 
                    System.out.println("Found these many quotes: " + total);                
                return total;
            } else
                throw new Exception("connection is not valid");
        } catch (Exception ex) {
            throw ex;
        }
    }
    
     private void unload() throws Exception {
        try {
            if(conn.isValid(1000)) {
                if (DEBUG) 
                    System.out.println("Connection " + conn + " is valid");
                    Statement stmt0 = conn.createStatement();
                    final int stmt0success = stmt0.executeUpdate("DELETE FROM QUOTES");                
                    if (DEBUG) 
                        System.out.println("Deleted quotes from table correctly: " + stmt0success);   
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    private void connect() throws Exception {
        try {
            this.conn = DriverManager.getConnection("jdbc:h2:mem:", "sa", "");
        if (DEBUG) 
            System.out.println("Opened connection to H2 db: " + conn);
        } catch (Exception ex) {
            throw ex;
        }
    }
    
    private void disconnect() throws Exception {
        try {
        if(!conn.isClosed())
            conn.close();
            if (DEBUG) 
                System.out.println("Closed database connection"); 
        } catch (Exception ex) {
            System.out.println("DID NOT close database connection: " + ex.getMessage());
            throw ex;
        }
    }
    
    private int random(int topValue) throws Exception {
        try {
            return (int) Math.ceil(Math.random() * topValue);
        } catch (final Exception ex) {
            throw ex;
        }
    }
    
    public Quote random() throws Exception {
        try {
            final int quoteIndex = this.random(this.totalQuotes);
            return this.fetch(quoteIndex);
        } catch (final Exception ex) {
            throw ex;
        }
    }
    
    public Quote roundrobin() throws Exception {
        try {
            if(currentQuoteIndex > totalQuotes)
                currentQuoteIndex = 1;
            return this.fetch(currentQuoteIndex++);
        } catch (final Exception ex) {
            throw ex;
        }
    }
    
    public void reset() throws Exception {
        try {
            this.currentQuoteIndex = 1;
        } catch (final Exception ex) {
            throw ex;
        }
    }
    
    public void stop() throws Exception {
        try {
            this.unload();
            this.disconnect();
        } catch (final Exception ex) {
            throw ex;
        }
       
    }
    
}
