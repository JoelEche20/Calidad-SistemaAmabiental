/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SistemaMedioAmbiental.SistemaAmbiental.Controllers;

import com.SistemaMedioAmbiental.SistemaAmbiental.Models.Clasification;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Antonio
 */
public class ClasificationControllerTest {
    
    public ClasificationControllerTest() {
    }

    /**
     * Test of showClasification method, of class ClasificationController.
     */
    @Test
    public void testShowClasification_0args() {
        System.out.println("showClasification");
        ClasificationController instance = new ClasificationController();
        List<Clasification> expResult = null;
        List<Clasification> result = instance.showClasification();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showClasification method, of class ClasificationController.
     */
    @Test
    public void testShowClasification_Long() {
        System.out.println("showClasification");
        Long id = null;
        ClasificationController instance = new ClasificationController();
        Optional<Clasification> expResult = null;
        Optional<Clasification> result = instance.showClasification(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showClasificationsSubDistrict method, of class ClasificationController.
     */
    @Test
    public void testShowClasificationsSubDistrict() {
        System.out.println("showClasificationsSubDistrict");
        Long id = null;
        ClasificationController instance = new ClasificationController();
        List<Clasification> expResult = null;
        List<Clasification> result = instance.showClasificationsSubDistrict(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class ClasificationController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Clasification cl = null;
        Long id = null;
        ClasificationController instance = new ClasificationController();
        Clasification expResult = null;
        Clasification result = instance.create(cl, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class ClasificationController.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Long id = null;
        Clasification cl = null;
        ClasificationController instance = new ClasificationController();
        Clasification expResult = null;
        Clasification result = instance.update(id, cl);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class ClasificationController.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Long id = null;
        ClasificationController instance = new ClasificationController();
        instance.delete(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
