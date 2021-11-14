/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SistemaMedioAmbiental.SistemaAmbiental.Controllers;

import com.SistemaMedioAmbiental.SistemaAmbiental.Models.LocationTree;
import com.SistemaMedioAmbiental.SistemaAmbiental.Models.SubClasification;
import com.SistemaMedioAmbiental.SistemaAmbiental.Models.Tree;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

import java.util.Optional;

import com.SistemaMedioAmbiental.SistemaAmbiental.Repositories.TreeRepository;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;

/**
 *
 * @author Antonio
 */

@RunWith(SpringRunner.class)
public class TreeControllerTest {
    
    private MockMvc mockMvc;
    @InjectMocks
    TreeController treeController;
    
    @Mock
    TreeRepository treeRepository;
    
    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(treeController).build();
    }
    
    /*public TreeControllerTest() {
    }*/

    /**
     * Test of showTree method, of class TreeController.
     */
    @Test
    public void testShowTree() throws Exception {
        System.out.println("showTree");
        LocationTree locationTree = new LocationTree("Tiquipaya", "Arboles", "arbol_tiqui", new SubClasification("Arbolito", "Arboles Cocha", "imagen_arbol"));
        List<Tree> trees = Arrays.asList(new Tree("1Code", "Sauce", "Sauce_Cientifico", 10, 10, "Antonio", "Imagen_Sauce", "Sauce_especies", locationTree));
        
        Mockito.when(treeRepository.findAll()).thenReturn(trees);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/tree"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Test of showTrees method, of class TreeController.
     */
    @Test
    public void testShowTrees() throws Exception {
        System.out.println("showTrees");
        LocationTree locationTree = new LocationTree("Tiquipaya", "Arboles", "arbol_tiqui", new SubClasification("Arbolito", "Arboles Cocha", "imagen_arbol"));
        Tree tree = new Tree("1Code", "Sauce", "Sauce_Cientifico", 10, 10, "Antonio", "Imagen_Sauce", "Sauce_especies", locationTree);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/tree/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(treeRepository).findById(new Long(1));
    }

    /**
     * Test of create method, of class TreeController.
     */
    /*@Test
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
    }*/

    /**
     * Test of update method, of class TreeController.
     */
    /*@Test
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
    }*/

    /**
     * Test of delete method, of class TreeController.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/tree/1").accept(MediaType.APPLICATION_JSON))
            .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
}
