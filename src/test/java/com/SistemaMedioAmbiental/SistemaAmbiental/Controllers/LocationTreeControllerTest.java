/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SistemaMedioAmbiental.SistemaAmbiental.Controllers;

import com.SistemaMedioAmbiental.SistemaAmbiental.Models.LocationTree;
import java.util.List;
import java.util.Optional;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Antonio
 */
public class LocationTreeControllerTest {
    
    public LocationTreeControllerTest() {
    }

    /**
     * Test of showLocationTree method, of class LocationTreeController.
     */
    @Test
    public void testShowLocationTree_0args() {
        System.out.println("showLocationTree");
        LocationTreeController instance = new LocationTreeController();
        List<LocationTree> expResult = null;
        List<LocationTree> result = instance.showLocationTree();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showLocationTree method, of class LocationTreeController.
     */
    @Test
    public void testShowLocationTree_Long() {
        System.out.println("showLocationTree");
        Long id = null;
        LocationTreeController instance = new LocationTreeController();
        Optional<LocationTree> expResult = null;
        Optional<LocationTree> result = instance.showLocationTree(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showLocationsSubClasification method, of class LocationTreeController.
     */
    @Test
    public void testShowLocationsSubClasification() {
        System.out.println("showLocationsSubClasification");
        Long id = null;
        LocationTreeController instance = new LocationTreeController();
        List<LocationTree> expResult = null;
        List<LocationTree> result = instance.showLocationsSubClasification(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class LocationTreeController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        LocationTree lc = null;
        Long id = null;
        LocationTreeController instance = new LocationTreeController();
        LocationTree expResult = null;
        LocationTree result = instance.create(lc, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class LocationTreeController.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Long id = null;
        LocationTree lc = null;
        LocationTreeController instance = new LocationTreeController();
        LocationTree expResult = null;
        LocationTree result = instance.update(id, lc);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class LocationTreeController.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Long id = null;
        LocationTreeController instance = new LocationTreeController();
        instance.delete(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
