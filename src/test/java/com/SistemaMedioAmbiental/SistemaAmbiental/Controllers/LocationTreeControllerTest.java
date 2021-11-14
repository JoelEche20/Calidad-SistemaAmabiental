/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SistemaMedioAmbiental.SistemaAmbiental.Controllers;

import com.SistemaMedioAmbiental.SistemaAmbiental.Models.LocationTree;
import com.SistemaMedioAmbiental.SistemaAmbiental.Models.SubClasification;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Optional;

import com.SistemaMedioAmbiental.SistemaAmbiental.Repositories.LocationTreeRepository;
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
//@WebMvcTest(value = LocationTreeController.class, secure = false)

public class LocationTreeControllerTest {
    
    //@Autowired
    private  MockMvc mockMvc;
    @InjectMocks
    LocationTreeController locationTreeController;
    
    @Mock
    LocationTreeRepository locationTreeRepository;
    
    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(locationTreeController).build();
    }
    
    /*public LocationTreeControllerTest() {
    }*/

    /**
     * Test of showLocationTree method, of class LocationTreeController.
     */
    @Test
    public void testShowLocationTree_0args() throws Exception {
     
        System.out.println("showLocationTree");
        List<LocationTree> locationTrees = Arrays.asList(new LocationTree("Tiquipaya", "Arboles", "arbol_tiqui", new SubClasification("Arbolito", "Arboles Cocha", "imagen_arbol")));
        Mockito.when(locationTreeRepository.findAll()).thenReturn(locationTrees);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/locationTree"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Test of showLocationTree method, of class LocationTreeController.
     */
    @Test
    public void testShowLocationTree_Long() throws Exception{
        System.out.println("showLocationTree");
        
        LocationTree locationTree = new LocationTree("Tiquipaya", "Arboles", "arbol_tiqui", new SubClasification("Arbolito", "Arboles Cocha", "imagen_arbol"));
        Mockito.when(locationTreeRepository.findById(new Long(1))).thenReturn(Optional.of(locationTree));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/locationTree/1")
                    .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(locationTreeRepository).findById(new Long(1));
    }

    /**
     * Test of create method, of class LocationTreeController.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        String expected = "{\"id\":1,\"name\":\"Tiquipaya\",\"information\":\"Arboles\",\"imageLink\":\"arbol_tiqui\",\"subClasification\":{\"id\":1\"name\":\"Arbolito\",\"information\":\"Arboles Cocha\",\"imageLink\":\"imagen_arbol\"}}" ;
        
        LocationTree locationTree = new LocationTree("Tiquipaya", "Arboles", "arbol_tiqui", new SubClasification("Arbolito", "Arboles Cocha", "imagen_arbol"));
                mockMvc.perform(MockMvcRequestBuilders.post("/api/locationTree")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(expected))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    /**
     * Test of update method, of class LocationTreeController.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        LocationTree locationTree = new LocationTree("Tiquipaya", "Arboles", "arbol_tiqui", new SubClasification("Arbolito", "Arboles Cocha", "imagen_arbol"));
        String expected = "{\"id\":1,\"name\":\"Tiquipaya\",\"information\":\"Arboles\",\"imageLink\":\"arbol_tiqui\",\"subClasification\":{\"id\":1\"name\":\"Arbolito\",\"information\":\"Arboles Cocha\",\"imageLink\":\"imagen_arbol\"}}" ;
        locationTree.setId(new Long(1));
        locationTree.setImageLink("imagen_arbol");
        mockMvc.perform(MockMvcRequestBuilders.put("/api/locationTree").contentType(MediaType.APPLICATION_JSON)
                .content(expected)).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)));
            
    }

    /**
     * Test of delete method, of class LocationTreeController.
     */
    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/locationTree/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}