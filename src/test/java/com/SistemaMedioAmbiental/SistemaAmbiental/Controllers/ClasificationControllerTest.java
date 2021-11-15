/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SistemaMedioAmbiental.SistemaAmbiental.Controllers;

import com.SistemaMedioAmbiental.SistemaAmbiental.Models.Clasification;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.SistemaMedioAmbiental.SistemaAmbiental.Models.Feedback;
import com.SistemaMedioAmbiental.SistemaAmbiental.Repositories.ClasificationRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
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
public class ClasificationControllerTest {

    private MockMvc mockMvc;
    @InjectMocks
    ClasificationController clasificationController;

    @Mock
    ClasificationRepository clasificationRepository;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(clasificationController).build();
    }
    public ClasificationControllerTest() {
    }

    /**
     * Test of showClasification method, of class ClasificationController.
     */
    @Test
    public void testShowClasification_0args() throws Exception {
        List<Clasification> clasifications = Arrays.asList(new Clasification("mau","info"));
        Mockito.when(clasificationRepository.findAll()).thenReturn(clasifications);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/clasification"))
                .andExpect(MockMvcResultMatchers.status().isOk());
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
