/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.junitandmockitoasahabit.model;

import com.junitandmockitoasahabit.data.Quote;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Anton Golovin
 */
public class QuoteServiceTest {
    
    public QuoteServiceTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of randomQuote method, of class QuoteService.
     */
    @Test
    public void testRandomQuote() throws Exception {
        System.out.println("randomQuote");
        QuoteService instance = new QuoteService();
        Quote expResult = null;
        Quote result = instance.randomQuote();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of roundrobinQuote method, of class QuoteService.
     */
    @Test
    public void testRoundrobinQuote() throws Exception {
        System.out.println("roundrobinQuote");
        QuoteService instance = new QuoteService();
        Quote expResult = null;
        Quote result = instance.roundrobinQuote();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resetQuotes method, of class QuoteService.
     */
    @Test
    public void testResetQuotes() throws Exception {
        System.out.println("resetQuotes");
        QuoteService instance = new QuoteService();
        instance.resetQuotes();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of resetData method, of class QuoteService.
     */
    @Test
    public void testResetData() throws Exception {
        System.out.println("resetData");
        QuoteService instance = new QuoteService();
        instance.resetData();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
