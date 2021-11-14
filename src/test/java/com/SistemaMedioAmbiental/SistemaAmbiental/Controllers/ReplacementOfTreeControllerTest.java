/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SistemaMedioAmbiental.SistemaAmbiental.Controllers;

import com.SistemaMedioAmbiental.SistemaAmbiental.Models.LocationTree;
import com.SistemaMedioAmbiental.SistemaAmbiental.Models.ReplacementOfTree;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.spi.LocaleServiceProvider;

import com.SistemaMedioAmbiental.SistemaAmbiental.Models.SubClasification;
import com.SistemaMedioAmbiental.SistemaAmbiental.Models.Tree;
import com.SistemaMedioAmbiental.SistemaAmbiental.Repositories.LocationTreeRepository;
import com.SistemaMedioAmbiental.SistemaAmbiental.Repositories.ReplacementOfTreeRepository;
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
 * @author Mauricio
 */
@RunWith(SpringRunner.class)
public class ReplacementOfTreeControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    ReplacementOfTreeController replacementOfTreeController;
    //LocationTreeController locationTreeController;
    @Mock
    ReplacementOfTreeRepository replacementOfTreeRepository;
    //LocationTreeRepository locationTreeRepository;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(replacementOfTreeController)
                .build();
    }

    @Test
    public void testShowReplacementsOfTrees() throws Exception {
        List<ReplacementOfTree> replacementOfTrees = Arrays.asList(new ReplacementOfTree("type","elim","date","reason"));
        Mockito.when(replacementOfTreeRepository.findAll()).thenReturn(replacementOfTrees);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/replacementOfTree"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Test of showReplacementsOfTreesLocations method, of class ReplacementOfTreeController.
     */
    @Test
    public void testShowReplacementsOfTreesLocations() throws Exception {
        ReplacementOfTree rep = new ReplacementOfTree("type","elim","date","reason");
        rep.setDateOfReplacement("5/5/2021");
        rep.setReasonForTheReplacement("reason");
        rep.setId(new Long(1));
        rep.setLocationTree(new LocationTree("aa","aa","aaa",new SubClasification("bb","bb","bb")));
        rep.setTree(new Tree("cc","cc","cc",5,5,"cc","cc","cc",new LocationTree("ee","ee","ee",new SubClasification("bb","bb","bb"))));
        List<ReplacementOfTree> replacementOfTrees = Arrays.asList(rep);
        Mockito.when(replacementOfTreeRepository.findAll()).thenReturn(replacementOfTrees);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/1/replacementOfTree")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Test of showReplacementTree method, of class ReplacementOfTreeController.
     */
    @Test
    public void testShowReplacementTree() throws Exception {
        ReplacementOfTree replacementOfTree = new ReplacementOfTree("type","elim","date","reason");
        Mockito.when(replacementOfTreeRepository.findById(new Long(1))).thenReturn(Optional.of(replacementOfTree));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/replacementOfTree/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(replacementOfTreeRepository).findById(new Long(1));
    }

    /**
     * Test of create method, of class ReplacementOfTreeController.
     */
    @Test
    public void testCreate() throws Exception {
        ReplacementOfTree rep = new ReplacementOfTree("type","elim","date","reason");
        LocationTree locationTree = new LocationTree("ee","ee","ee",new SubClasification("bb","bb","bb"));
        locationTree.setId(new Long(1));
        rep.setDateOfReplacement("5/5/2021");
        rep.setReasonForTheReplacement("reason");
        rep.setId(new Long(1));
        rep.setTree(new Tree("cc","cc","cc",5,5,"cc","cc","cc",locationTree));
        rep.setLocationTree(locationTree);

        String expected = "{\"id\":1,\"person\":\"Mauricio\",\"treeSpecies\":\"Carnivora1\",\"flowering\":\"Flor1\",\"fructification\":\"Fruct1\",\"defoliation\":\"defo1\",\"foliation\":\"foli1\",\"imageLink\":\"ImageLink1\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/api/" + locationTree.getId().toString() +"/replacementOfTree")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(expected))
                .andExpect(MockMvcResultMatchers.status().isCreated());
        System.out.println(MockMvcResultMatchers.content());

    }

    /**
     * Test of update method, of class ReplacementOfTreeController.
     */
    @Test
    public void testUpdate() {
        System.out.println("update");
        Long id = null;
        ReplacementOfTree cl = null;
        ReplacementOfTreeController instance = new ReplacementOfTreeController();
        ReplacementOfTree expResult = null;
        ReplacementOfTree result = instance.update(id, cl);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class ReplacementOfTreeController.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Long id = null;
        ReplacementOfTreeController instance = new ReplacementOfTreeController();
        instance.delete(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
