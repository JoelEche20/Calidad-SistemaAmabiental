/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SistemaMedioAmbiental.SistemaAmbiental.Controllers;

import com.SistemaMedioAmbiental.SistemaAmbiental.Models.District;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.SistemaMedioAmbiental.SistemaAmbiental.Repositories.DistrictRepository;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 *
 * @author Joel
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
    @Test
    public void testShowClasification_0args() throws Exception {
        System.out.println("showClasification");
        List<District> districtList = new ArrayList<>();
        District d1 = new District("Distrito 1", "distrito de cocha");
        d1.setId(new Long(1));
        d1.setImageLink("asdasd");
        District d2 = new District("Distrito 2", "distrito de tiquipaya");
        d2.setId(new Long(2));
        d2.setImageLink("asdasd");
        districtList.add(d1);
        districtList.add(d2);
        when(districtRepository.findAll()).thenReturn(districtList);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/district").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "[{\"id\":1,\"name\":\"Distrito 1\",\"information\":\"distrito de cocha\",\"imageLink\":\"asdasd\"},{\"id\":2,\"name\":\"Distrito 2\",\"information\":\"distrito de tiquipaya\",\"imageLink\":\"asdasd\"}]";
        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(), false);
    }

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
    @Test
    public void testCreate() throws Exception{
        System.out.println("create");
        District district = new District("Plaza Ex combatientes", "Plaza reconosida");
        district.setImageLink("asddasda");
        district.setId(new Long(1));
        System.out.println("showClasification2");
        String expected = "{\"id\":1,\"name\":\"Plaza Ex combatientes\",\"information\":\"Plaza reconosida\",\"imageLink\":\"asddasda\"}";
        when(districtRepository.save(district)).thenReturn(district);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/district", district)
                .accept(MediaType.APPLICATION_JSON).content(expected)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        System.out.println(result.getResponse().getContentAsString());
        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
    }

    /**
     * Test of update method, of class DistrictController.
     */
    @Test
    public void testUpdate() throws Exception{
        District district = new District("Distrito 21", "distrito de cochabamba");
        district.setImageLink("asddasda");
        district.setId(new Long(1));
        System.out.println("showClasification2");
        String expected = "{\"id\":1,\"name\":\"Distrito 21\",\"information\":\"distrito de cochabamba\",\"imageLink\":\"asddasda\"}";
        mockMvc.perform(MockMvcRequestBuilders.put("/api/district/1/",district)
                .contentType(MediaType.APPLICATION_JSON)
                .content(expected))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.id", Matchers.is(1)))
                .andExpect(MockMvcResultMatchers.jsonPath("$.name",Matchers.is("Plaza Ex combatientes")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.information",Matchers.is("Plaza reconosida")))
                .andExpect(MockMvcResultMatchers.jsonPath("$.imageLink", Matchers.is("asddasda")));
    }

    /**
     * Test of delete method, of class DistrictController.
     */
    @Test
    public void testDelete() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/district/1")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
}