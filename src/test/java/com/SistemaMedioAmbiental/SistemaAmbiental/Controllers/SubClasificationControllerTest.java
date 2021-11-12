/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SistemaMedioAmbiental.SistemaAmbiental.Controllers;

import com.SistemaMedioAmbiental.SistemaAmbiental.Models.SubClasification;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Antonio
 */
public class SubClasificationControllerTest {
    
    public SubClasificationControllerTest() {
    }

    /**
     * Test of showSubClasification method, of class SubClasificationController.
     */
    @Test
    public void testShowSubClasification_0args() {
        System.out.println("showSubClasification");
        SubClasificationController instance = new SubClasificationController();
        List<SubClasification> expResult = null;
        List<SubClasification> result = instance.showSubClasification();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showSubClasification method, of class SubClasificationController.
     */
    @Test
    public void testShowSubClasification_Long() {
        System.out.println("showSubClasification");
        Long id = null;
        SubClasificationController instance = new SubClasificationController();
        Optional<SubClasification> expResult = null;
        Optional<SubClasification> result = instance.showSubClasification(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showSubClassesClasification method, of class SubClasificationController.
     */
    @Test
    public void testShowSubClassesClasification() {
        System.out.println("showSubClassesClasification");
        Long id = null;
        SubClasificationController instance = new SubClasificationController();
        List<SubClasification> expResult = null;
        List<SubClasification> result = instance.showSubClassesClasification(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class SubClasificationController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        SubClasification sb = null;
        Long id = null;
        SubClasificationController instance = new SubClasificationController();
        SubClasification expResult = null;
        SubClasification result = instance.create(sb, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class SubClasificationController.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Long id = null;
        SubClasification sb = null;
        SubClasificationController instance = new SubClasificationController();
        SubClasification expResult = null;
        SubClasification result = instance.update(id, sb);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class SubClasificationController.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Long id = null;
        SubClasificationController instance = new SubClasificationController();
        instance.delete(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
