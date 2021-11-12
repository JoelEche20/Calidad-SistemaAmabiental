/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SistemaMedioAmbiental.SistemaAmbiental.Controllers;

import com.SistemaMedioAmbiental.SistemaAmbiental.Models.SubDistrict;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Antonio
 */
public class SubDistrictControllerTest {
    
    public SubDistrictControllerTest() {
    }

    /**
     * Test of showSubDistrict method, of class SubDistrictController.
     */
    @Test
    public void testShowSubDistrict_0args() {
        System.out.println("showSubDistrict");
        SubDistrictController instance = new SubDistrictController();
        List<SubDistrict> expResult = null;
        List<SubDistrict> result = instance.showSubDistrict();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showSubDistrict method, of class SubDistrictController.
     */
    @Test
    public void testShowSubDistrict_Long() {
        System.out.println("showSubDistrict");
        Long id = null;
        SubDistrictController instance = new SubDistrictController();
        Optional<SubDistrict> expResult = null;
        Optional<SubDistrict> result = instance.showSubDistrict(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showSubDistrictsOfDistrict method, of class SubDistrictController.
     */
    @Test
    public void testShowSubDistrictsOfDistrict() {
        System.out.println("showSubDistrictsOfDistrict");
        Long id = null;
        SubDistrictController instance = new SubDistrictController();
        List<SubDistrict> expResult = null;
        List<SubDistrict> result = instance.showSubDistrictsOfDistrict(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class SubDistrictController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        SubDistrict sd = null;
        Long id = null;
        SubDistrictController instance = new SubDistrictController();
        SubDistrict expResult = null;
        SubDistrict result = instance.create(sd, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class SubDistrictController.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Long id = null;
        SubDistrict sd = null;
        SubDistrictController instance = new SubDistrictController();
        SubDistrict expResult = null;
        SubDistrict result = instance.update(id, sd);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class SubDistrictController.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Long id = null;
        SubDistrictController instance = new SubDistrictController();
        instance.delete(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
