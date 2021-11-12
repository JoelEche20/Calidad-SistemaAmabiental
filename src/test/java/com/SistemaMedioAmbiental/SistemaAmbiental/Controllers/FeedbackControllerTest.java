/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SistemaMedioAmbiental.SistemaAmbiental.Controllers;

import com.SistemaMedioAmbiental.SistemaAmbiental.Models.Feedback;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Antonio
 */
public class FeedbackControllerTest {
    
    public FeedbackControllerTest() {
    }

    /**
     * Test of showFeedbacks method, of class FeedbackController.
     */
    @Test
    public void testShowFeedbacks() {
        System.out.println("showFeedbacks");
        FeedbackController instance = new FeedbackController();
        List<Feedback> expResult = null;
        List<Feedback> result = instance.showFeedbacks();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showFeedback method, of class FeedbackController.
     */
    @Test
    public void testShowFeedback() {
        System.out.println("showFeedback");
        Long id = null;
        FeedbackController instance = new FeedbackController();
        Optional<Feedback> expResult = null;
        Optional<Feedback> result = instance.showFeedback(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class FeedbackController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Feedback cm = null;
        FeedbackController instance = new FeedbackController();
        Feedback expResult = null;
        Feedback result = instance.create(cm);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class FeedbackController.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Long id = null;
        Feedback cl = null;
        FeedbackController instance = new FeedbackController();
        Feedback expResult = null;
        Feedback result = instance.update(id, cl);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class FeedbackController.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Long id = null;
        FeedbackController instance = new FeedbackController();
        instance.delete(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
