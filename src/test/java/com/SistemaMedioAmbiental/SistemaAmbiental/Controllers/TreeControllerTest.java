/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SistemaMedioAmbiental.SistemaAmbiental.Controllers;

import com.SistemaMedioAmbiental.SistemaAmbiental.Models.Tree;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Antonio
 */
public class TreeControllerTest {
    
    public TreeControllerTest() {
    }

    /**
     * Test of showTree method, of class TreeController.
     */
    @Test
    public void testShowTree() {
        System.out.println("showTree");
        TreeController instance = new TreeController();
        List<Tree> expResult = null;
        List<Tree> result = instance.showTree();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showTrees method, of class TreeController.
     */
    @Test
    public void testShowTrees() {
        System.out.println("showTrees");
        Long id = null;
        TreeController instance = new TreeController();
        Tree expResult = null;
        Tree result = instance.showTrees(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showTreesLocation method, of class TreeController.
     */
    @Test
    public void testShowTreesLocation() {
        System.out.println("showTreesLocation");
        Long id = null;
        TreeController instance = new TreeController();
        List<Tree> expResult = null;
        List<Tree> result = instance.showTreesLocation(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of create method, of class TreeController.
     */
    @Test
    public void testCreate() {
        System.out.println("create");
        Tree tree = null;
        Long id = null;
        TreeController instance = new TreeController();
        Tree expResult = null;
        Tree result = instance.create(tree, id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of update method, of class TreeController.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Long id = null;
        Tree t = null;
        TreeController instance = new TreeController();
        Tree expResult = null;
        Tree result = instance.update(id, t);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class TreeController.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Long id = null;
        TreeController instance = new TreeController();
        instance.delete(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
