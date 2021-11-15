/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SistemaMedioAmbiental.SistemaAmbiental.Controllers;

import com.SistemaMedioAmbiental.SistemaAmbiental.Models.SubClasification;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Optional;
import org.junit.Test;

import com.SistemaMedioAmbiental.SistemaAmbiental.Repositories.SubClasificationRepository;
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
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

/**
 *
 * @author Antonio
 */

@RunWith(SpringRunner.class)

public class SubClasificationControllerTest {
    
    private  MockMvc mockMvc;
    @InjectMocks
    SubClasificationController subClasificationController;
    
    @Mock
    SubClasificationRepository subClasificationRepository;
    
    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(subClasificationController).build();
    }
    
    
    
    /*public SubClasificationControllerTest() {
    }*/

    /**
     * Test of showSubClasification method, of class SubClasificationController.
     */
    @Test
    public void testShowSubClasification_0args() throws Exception{
        System.out.println("showSubClasification");
        List<SubClasification> subClasifications = Arrays.asList(new SubClasification("SubClasi", "Clasi_Arbol", "clasi_image"));
        Mockito.when(subClasificationRepository.findAll()).thenReturn(subClasifications);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/subClasification"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Test of showSubClasification method, of class SubClasificationController.
     */
    @Test
    public void testShowSubClasification_Long() throws Exception{
        System.out.println("showSubClasification");
        SubClasification subClasification = new SubClasification("SubClasi", "Clasi_Arbol", "clasi_image");
        Mockito.when(subClasificationRepository.findById(new Long(1))).thenReturn(Optional.of(subClasification));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/subClasification/1")
                    .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(subClasificationRepository).findById(new Long(1));
    }

    /**
     * Test of showSubClassesClasification method, of class SubClasificationController.
     */
    /*@Test
    public void testShowSubClassesClasification() {
        System.out.println("showSubClassesClasification");
        Long id = null;
        SubClasificationController instance = new SubClasificationController();
        List<SubClasification> expResult = null;
        List<SubClasification> result = instance.showSubClassesClasification(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of create method, of class SubClasificationController.
     */
    /*@Test
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
    }*/

    /**
     * Test of update method, of class SubClasificationController.
     */
    /*@Test
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
    }*/

    /**
     * Test of delete method, of class SubClasificationController.
     */
    @Test
    public void testDelete() throws Exception {
        System.out.println("delete");
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/subClasification/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
}
