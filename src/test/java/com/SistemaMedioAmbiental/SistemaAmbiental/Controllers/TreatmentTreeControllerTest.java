/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SistemaMedioAmbiental.SistemaAmbiental.Controllers;

import com.SistemaMedioAmbiental.SistemaAmbiental.Models.*;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.SistemaMedioAmbiental.SistemaAmbiental.Repositories.LocationTreeRepository;
import com.SistemaMedioAmbiental.SistemaAmbiental.Repositories.TreatmentTreeRepository;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;

/**
 *
 * @author Mauricio
 */
@RunWith(SpringRunner.class)
public class TreatmentTreeControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    TreatmentTreeController treatmentTreeController;

    @InjectMocks
    LocationTreeController locationTreeController;

    @Mock
    TreatmentTreeRepository treatmentTreeRepository;

    @Mock
    LocationTreeRepository locationTreeRepository;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(treatmentTreeController).build();
    }

    /**
     * Test of showTretmentsTree method, of class TreatmentTreeController.
     */
    @Test
    public void testShowTretmentsTree() throws Exception {
        TreatmentTree treatmentTree = new TreatmentTree("pruning","sugest","treatment");
        treatmentTree.setTree(new Tree("cc","cc","cc",5,5,"cc","cc","cc",new LocationTree("ee","ee","ee",new SubClasification("bb","bb","bb"))));
        treatmentTree.setLocationTree(new LocationTree("ee","ee","ee",new SubClasification("bb","bb","bb")));
        List<TreatmentTree> treatmentTrees = Arrays.asList(treatmentTree);
        Mockito.when(treatmentTreeRepository.findAll()).thenReturn(treatmentTrees);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/treatmentTree"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Test of showTretmentsTreeLocation method, of class TreatmentTreeController.
     */
    @Test
    public void testShowTretmentsTreeLocation() throws Exception {
        TreatmentTree treatmentTree = new TreatmentTree("pruning","sugest","treatment");
        treatmentTree.setTree(new Tree("cc","cc","cc",5,5,"cc","cc","cc",new LocationTree("ee","ee","ee",new SubClasification("bb","bb","bb"))));
        treatmentTree.setLocationTree(new LocationTree("ee","ee","ee",new SubClasification("bb","bb","bb")));
        List<TreatmentTree> replacementOfTrees = Arrays.asList(treatmentTree);
        Mockito.when(treatmentTreeRepository.findAll()).thenReturn(replacementOfTrees);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/1/treatmentTree")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Test of showTreatmentTree method, of class TreatmentTreeController.
     */
    @Test
    public void testShowTreatmentTree() throws Exception {
        TreatmentTree treatmentTree = new TreatmentTree("pruning","sugest","treatment");
        treatmentTree.setTree(new Tree("cc","cc","cc",5,5,"cc","cc","cc",new LocationTree("ee","ee","ee",new SubClasification("bb","bb","bb"))));
        treatmentTree.setLocationTree(new LocationTree("ee","ee","ee",new SubClasification("bb","bb","bb")));
        Mockito.when(treatmentTreeRepository.findById(new Long(1))).thenReturn(Optional.of(treatmentTree));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/treatmentTree/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(treatmentTreeRepository).findById(new Long(1));
    }

    /**
     * Test of create method, of class TreatmentTreeController.
     */
    @Test
    public void testCreate() throws Exception {

        TreatmentTree treatmentTree = new TreatmentTree("pruning","sugest","treatment");
        treatmentTree.setTree(new Tree("cc","cc","cc",5,5,"cc","cc","cc",new LocationTree("ee","ee","ee",new SubClasification("bb","bb","bb"))));
        treatmentTree.setLocationTree(new LocationTree("ee","ee","ee",new SubClasification("bb","bb","bb")));

        LocationTree locationTree = new LocationTree("Tiquipaya", "Arboles", "arbol_tiqui", new SubClasification("Arbolito", "Arboles Cocha", "imagen_arbol"));
        locationTree.setId(new Long(1));
        String expected = "{ \"id\": 1, \"realizedTreatment\": \"test\", \"typeOfPruning\": \"test\" }";
        Mockito.when(locationTreeRepository.save(locationTree)).thenReturn(locationTree);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/1/treatmentTree")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(expected))
                .andExpect(MockMvcResultMatchers.status().isOk());
        System.out.println(MockMvcResultMatchers.content());
    }

    /**
     * Test of update method, of class TreatmentTreeController.
     */
    @Test
    public void testUpdate() throws Exception {
        TreatmentTree treatmentTree = new TreatmentTree("pruning","sugest","treatment");
        treatmentTree.setTree(new Tree("cc","cc","cc",5,5,"cc","cc","cc",new LocationTree("ee","ee","ee",new SubClasification("bb","bb","bb"))));
        treatmentTree.setLocationTree(new LocationTree("ee","ee","ee",new SubClasification("bb","bb","bb")));
        LocationTree locationTree = new LocationTree("Tiquipaya", "Arboles", "arbol_tiqui", new SubClasification("Arbolito", "Arboles Cocha", "imagen_arbol"));
        Mockito.when(treatmentTreeRepository.save(treatmentTree)).thenReturn(treatmentTree);

        String expected = "{\"realizedTreatment\": \"test\", \"typeOfPruning\": \"test\" }";

        mockMvc.perform(MockMvcRequestBuilders.put("/api/treatmentTree/1").contentType(MediaType.APPLICATION_JSON)
                        .content(expected)).andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)));
    }
    /**
     * Test of delete method, of class TreatmentTreeController.
     */
    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/treatmentTree/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
}
