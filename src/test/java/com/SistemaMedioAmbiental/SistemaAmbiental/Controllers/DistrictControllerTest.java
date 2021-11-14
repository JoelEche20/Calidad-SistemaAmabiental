/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SistemaMedioAmbiental.SistemaAmbiental.Controllers;

import com.SistemaMedioAmbiental.SistemaAmbiental.Models.District;
import java.util.List;
import java.util.Optional;

import com.SistemaMedioAmbiental.SistemaAmbiental.Repositories.DistrictRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
/**
 *
 * @author Antonio
 */

@RunWith(SpringRunner.class)
@WebMvcTest(value = DistrictController.class, secure = false)

public class DistrictControllerTest {
    
    @Autowired
    private  MockMvc mockMvc;

    @MockBean
    private DistrictRepository districtRepository;
    
    public DistrictControllerTest() {
    }

    /**
     * Test of showClasification method, of class DistrictController.
     */
    /*@Test
    public void testShowClasification_0args() {
        System.out.println("showClasification");
        DistrictController instance = new DistrictController();
        List<District> expResult = null;
        List<District> result = instance.showClasification();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of showClasification method, of class DistrictController.
     */
    @Test
    public void testShowClasification_Long() throws Exception {
        District district = new District("Plaza Ex combatientes", "Plaza reconosida");
        district.setImageLink("asddasda");
        district.setId(new Long(1));
        System.out.println("showClasification2");
        when(districtRepository.findById(new Long(1))).thenReturn(Optional.ofNullable(district));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/district/1").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "{\"id\":1,\"name\":\"Plaza Ex combatientes\",\"information\":\"Plaza reconosida\",\"imageLink\":\"asddasda\"}";
        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(), false);
    }

    /**
     * Test of create method, of class DistrictController.
     */
    /*@Test
    public void testCreate() {
        System.out.println("create");
        District ds = null;
        DistrictController instance = new DistrictController();
        District expResult = null;
        District result = instance.create(ds);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of update method, of class DistrictController.
     */
    /*@Test
    public void testUpdate() {
        System.out.println("update");
        Long id = null;
        District cl = null;
        DistrictController instance = new DistrictController();
        District expResult = null;
        District result = instance.update(id, cl);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/

    /**
     * Test of delete method, of class DistrictController.
     */
    /*@Test
    public void testDelete() {
        System.out.println("delete");
        Long id = null;
        DistrictController instance = new DistrictController();
        instance.delete(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
