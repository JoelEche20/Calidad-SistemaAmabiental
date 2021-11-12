/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SistemaMedioAmbiental.SistemaAmbiental.Controllers;

import com.SistemaMedioAmbiental.SistemaAmbiental.Models.ReplacementOfTree;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Antonio
 */
public class ReplacementOfTreeControllerTest {
    
    public ReplacementOfTreeControllerTest() {
    }

    /**
     * Test of showReplacementsOfTrees method, of class ReplacementOfTreeController.
     */
    @Test
    public void testShowReplacementsOfTrees() {
        System.out.println("showReplacementsOfTrees");
        ReplacementOfTreeController instance = new ReplacementOfTreeController();
        List<ReplacementOfTree> expResult = null;
        List<ReplacementOfTree> result = instance.showReplacementsOfTrees();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showReplacementsOfTreesLocations method, of class ReplacementOfTreeController.
     */
    @Test
    public void testShowReplacementsOfTreesLocations() {
        System.out.println("showReplacementsOfTreesLocations");
        Long id = null;
        ReplacementOfTreeController instance = new ReplacementOfTreeController();
        List<ReplacementOfTree> expResult = null;
        List<ReplacementOfTree> result = instance.showReplacementsOfTreesLocations(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showReplacementTree method, of class ReplacementOfTreeController.
     */
    @Test
    public void testShowReplacementTree() {
        System.out.println("showReplacementTree");
        Long id = null;
        ReplacementOfTreeController instance = new ReplacementOfTreeController();
        Optional<ReplacementOfTree> expResult = null;
        Optional<ReplacementOfTree> result = instance.showReplacementTree(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class ReplacementOfTreeController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        ReplacementOfTree cm = null;
        Long id = null;
        ReplacementOfTreeController instance = new ReplacementOfTreeController();
        ReplacementOfTree expResult = null;
        ReplacementOfTree result = instance.create(cm, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class ReplacementOfTreeController.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Long id = null;
        ReplacementOfTree cl = null;
        ReplacementOfTreeController instance = new ReplacementOfTreeController();
        ReplacementOfTree expResult = null;
        ReplacementOfTree result = instance.update(id, cl);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class ReplacementOfTreeController.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Long id = null;
        ReplacementOfTreeController instance = new ReplacementOfTreeController();
        instance.delete(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
