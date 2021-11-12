/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SistemaMedioAmbiental.SistemaAmbiental.Controllers;

import com.SistemaMedioAmbiental.SistemaAmbiental.Models.TreatmentTree;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Antonio
 */
public class TreatmentTreeControllerTest {
    
    public TreatmentTreeControllerTest() {
    }

    /**
     * Test of showTretmentsTree method, of class TreatmentTreeController.
     */
    @Test
    public void testShowTretmentsTree() {
        System.out.println("showTretmentsTree");
        TreatmentTreeController instance = new TreatmentTreeController();
        List<TreatmentTree> expResult = null;
        List<TreatmentTree> result = instance.showTretmentsTree();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showTretmentsTreeLocation method, of class TreatmentTreeController.
     */
    @Test
    public void testShowTretmentsTreeLocation() {
        System.out.println("showTretmentsTreeLocation");
        Long id = null;
        TreatmentTreeController instance = new TreatmentTreeController();
        List<TreatmentTree> expResult = null;
        List<TreatmentTree> result = instance.showTretmentsTreeLocation(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showTreatmentTree method, of class TreatmentTreeController.
     */
    @Test
    public void testShowTreatmentTree() {
        System.out.println("showTreatmentTree");
        Long id = null;
        TreatmentTreeController instance = new TreatmentTreeController();
        Optional<TreatmentTree> expResult = null;
        Optional<TreatmentTree> result = instance.showTreatmentTree(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class TreatmentTreeController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        TreatmentTree cm = null;
        Long id = null;
        TreatmentTreeController instance = new TreatmentTreeController();
        TreatmentTree expResult = null;
        TreatmentTree result = instance.create(cm, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class TreatmentTreeController.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Long id = null;
        TreatmentTree cl = null;
        TreatmentTreeController instance = new TreatmentTreeController();
        TreatmentTree expResult = null;
        TreatmentTree result = instance.update(id, cl);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class TreatmentTreeController.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Long id = null;
        TreatmentTreeController instance = new TreatmentTreeController();
        instance.delete(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
