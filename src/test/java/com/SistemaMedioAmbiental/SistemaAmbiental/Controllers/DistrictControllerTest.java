/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SistemaMedioAmbiental.SistemaAmbiental.Controllers;

import com.SistemaMedioAmbiental.SistemaAmbiental.Models.District;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Antonio
 */
public class DistrictControllerTest {
    
    public DistrictControllerTest() {
    }

    /**
     * Test of showClasification method, of class DistrictController.
     */
    @Test
    public void testShowClasification_0args() {
        System.out.println("showClasification");
        DistrictController instance = new DistrictController();
        List<District> expResult = null;
        List<District> result = instance.showClasification();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showClasification method, of class DistrictController.
     */
    @Test
    public void testShowClasification_Long() {
        System.out.println("showClasification");
        Long id = null;
        DistrictController instance = new DistrictController();
        Optional<District> expResult = null;
        Optional<District> result = instance.showClasification(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class DistrictController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        District ds = null;
        DistrictController instance = new DistrictController();
        District expResult = null;
        District result = instance.create(ds);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class DistrictController.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Long id = null;
        District cl = null;
        DistrictController instance = new DistrictController();
        District expResult = null;
        District result = instance.update(id, cl);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class DistrictController.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Long id = null;
        DistrictController instance = new DistrictController();
        instance.delete(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}