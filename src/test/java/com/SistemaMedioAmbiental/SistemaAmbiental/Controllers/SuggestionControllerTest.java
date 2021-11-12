/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SistemaMedioAmbiental.SistemaAmbiental.Controllers;

import com.SistemaMedioAmbiental.SistemaAmbiental.Models.Suggestion;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Antonio
 */
public class SuggestionControllerTest {
    
    public SuggestionControllerTest() {
    }

    /**
     * Test of showSuggestions method, of class SuggestionController.
     */
    @Test
    public void testShowSuggestions() {
        System.out.println("showSuggestions");
        SuggestionController instance = new SuggestionController();
        List<Suggestion> expResult = null;
        List<Suggestion> result = instance.showSuggestions();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showSuggestion method, of class SuggestionController.
     */
    @Test
    public void testShowSuggestion() {
        System.out.println("showSuggestion");
        Long id = null;
        SuggestionController instance = new SuggestionController();
        Optional<Suggestion> expResult = null;
        Optional<Suggestion> result = instance.showSuggestion(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class SuggestionController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Suggestion cm = null;
        SuggestionController instance = new SuggestionController();
        Suggestion expResult = null;
        Suggestion result = instance.create(cm);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class SuggestionController.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Long id = null;
        Suggestion cl = null;
        SuggestionController instance = new SuggestionController();
        Suggestion expResult = null;
        Suggestion result = instance.update(id, cl);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class SuggestionController.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Long id = null;
        SuggestionController instance = new SuggestionController();
        instance.delete(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
