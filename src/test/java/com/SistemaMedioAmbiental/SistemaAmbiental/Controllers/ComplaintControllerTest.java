/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SistemaMedioAmbiental.SistemaAmbiental.Controllers;

import com.SistemaMedioAmbiental.SistemaAmbiental.Models.Complaint;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Antonio
 */
public class ComplaintControllerTest {
    
    public ComplaintControllerTest() {
    }

    /**
     * Test of showComplaints method, of class ComplaintController.
     */
    @Test
    public void testShowComplaints() {
        System.out.println("showComplaints");
        ComplaintController instance = new ComplaintController();
        List<Complaint> expResult = null;
        List<Complaint> result = instance.showComplaints();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showComplaint method, of class ComplaintController.
     */
    @Test
    public void testShowComplaint() {
        System.out.println("showComplaint");
        Long id = null;
        ComplaintController instance = new ComplaintController();
        Optional<Complaint> expResult = null;
        Optional<Complaint> result = instance.showComplaint(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class ComplaintController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Complaint cm = null;
        ComplaintController instance = new ComplaintController();
        Complaint expResult = null;
        Complaint result = instance.create(cm);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class ComplaintController.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Long id = null;
        Complaint cl = null;
        ComplaintController instance = new ComplaintController();
        Complaint expResult = null;
        Complaint result = instance.update(id, cl);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class ComplaintController.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Long id = null;
        ComplaintController instance = new ComplaintController();
        instance.delete(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
