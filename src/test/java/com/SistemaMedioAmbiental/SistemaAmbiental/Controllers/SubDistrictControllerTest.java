/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SistemaMedioAmbiental.SistemaAmbiental.Controllers;

import com.SistemaMedioAmbiental.SistemaAmbiental.Models.District;
import com.SistemaMedioAmbiental.SistemaAmbiental.Models.SubDistrict;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.SistemaMedioAmbiental.SistemaAmbiental.Repositories.DistrictRepository;
import com.SistemaMedioAmbiental.SistemaAmbiental.Repositories.SubDistrictRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 *
 * @author Joel
 */

@RunWith(SpringRunner.class)
//@WebMvcTest(value = SubDistrictController.class, excludeAutoConfiguration = SecurityAutoConfiguration.class)
public class SubDistrictControllerTest {

    private MockMvc mockMvc;

    @InjectMocks
    SubDistrictController subDistrictController;

    @Mock
    private SubDistrictRepository subDistrictRepository;

    @Mock
    private DistrictRepository districtRepository;

    @Before
    public void setUp (){
        mockMvc = MockMvcBuilders.standaloneSetup(subDistrictController).build();
    }
    public SubDistrictControllerTest() {
    }

    /**
     * Test of showSubDistrict method, of class SubDistrictController.
     */
    @Test
    public void testShowSubDistrict_0args() throws Exception{
        System.out.println("showClasification");
        District district = new District("Distrito 1", "distrito de cocha");
        district.setImageLink("asdasd");
        district.setId(new Long(1));
        List<SubDistrict> subDistrictList = new ArrayList<>();
        SubDistrict sd1 = new SubDistrict("SubDistrito1", "SD1","sub distrito", "asddasda", district);
        sd1.setId(new Long(1));
        SubDistrict sd2 = new SubDistrict("SubDistrito2", "SD2","sub distrito", "asddasda", district);
        sd2.setId(new Long(2));
        subDistrictList.add(sd1);
        subDistrictList.add(sd2);
        when(subDistrictRepository.findAll()).thenReturn(subDistrictList);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/subDistrict").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "[{\"id\":1,\"name\":\"SubDistrito1\",\"cod\":\"SD1\",\"information\":\"sub distrito\",\"imageLink\":\"asddasda\",\"district\":{\"id\":1,\"name\":\"Distrito 1\",\"information\":\"distrito de cocha\",\"imageLink\":\"asdasd\"}},{\"id\":2,\"name\":\"SubDistrito2\",\"cod\":\"SD2\",\"information\":\"sub distrito\",\"imageLink\":\"asddasda\",\"district\":{\"id\":1,\"name\":\"Distrito 1\",\"information\":\"distrito de cocha\",\"imageLink\":\"asdasd\"}}]";
        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(), false);
    }

    /**
     * Test of showSubDistrict method, of class SubDistrictController.
     */
    @Test
    public void testShowSubDistrict_Long() throws Exception{
        System.out.println("showSubDistrict");
        District district = new District("Distrito 1", "distrito de cocha");
        district.setImageLink("asdasd");
        district.setId(new Long(1));
        SubDistrict subDistrict = new SubDistrict("SubDistrito1", "SD1","sub distrito", "asddasda", district);
        subDistrict.setId(new Long(1));
        when(subDistrictRepository.findById(new Long(1))).thenReturn(Optional.ofNullable(subDistrict));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/subDistrict/1").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "{\"id\":1,\"name\":\"SubDistrito1\",\"cod\":\"SD1\",\"information\":\"sub distrito\",\"imageLink\":\"asddasda\",\"district\":{\"id\":1,\"name\":\"Distrito 1\",\"information\":\"distrito de cocha\",\"imageLink\":\"asdasd\"}}";
        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(), false);
    }

    /**
     * Test of showSubDistrictsOfDistrict method, of class SubDistrictController.
     */
    @Test
    public void testShowSubDistrictsOfDistrict() throws Exception{
        System.out.println("showSubDistrictsOfDistrict");
        District district = new District("Distrito 1", "distrito de cocha");
        district.setImageLink("asdasd");
        district.setId(new Long(1));
        districtRepository.save(district);
        List<SubDistrict> subDistrictList = new ArrayList<>();
        SubDistrict sd1 = new SubDistrict("SubDistrito1", "SD1","sub distrito", "asddasda", district);
        sd1.setId(new Long(1));
        SubDistrict sd2 = new SubDistrict("SubDistrito2", "SD2","sub distrito", "asddasda", district);
        sd2.setId(new Long(2));
        subDistrictList.add(sd1);
        subDistrictList.add(sd2);
        when(subDistrictRepository.findAll()).thenReturn(subDistrictList);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/1/subDistrict").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "[{\"id\":1,\"name\":\"SubDistrito1\",\"cod\":\"SD1\",\"information\":\"sub distrito\",\"imageLink\":\"asddasda\",\"district\":{\"id\":1,\"name\":\"Distrito 1\",\"information\":\"distrito de cocha\",\"imageLink\":\"asdasd\"}},{\"id\":2,\"name\":\"SubDistrito2\",\"cod\":\"SD2\",\"information\":\"sub distrito\",\"imageLink\":\"asddasda\",\"district\":{\"id\":1,\"name\":\"Distrito 1\",\"information\":\"distrito de cocha\",\"imageLink\":\"asdasd\"}}]";
        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(), false);
    }

    /**
     * Test of create method, of class SubDistrictController.
     */
    @Test
    public void testCreate() throws Exception{
        District district = new District("Distrito 1", "distrito de cocha");
        district.setImageLink("asdasd");
        district.setId(new Long(1));
        SubDistrict subDistrict = new SubDistrict("SubDistrito1", "SD1","sub distrito", "asddasda", district);
        subDistrict.setId(new Long(1));
        when(subDistrictRepository.save(subDistrict)).thenReturn(subDistrict);
        String expected = "{\"id\":1,\"name\":\"SubDistrito1\",\"cod\":\"SD1\",\"information\":\"sub distrito\",\"imageLink\":\"asddasda\",\"district\":{\"id\":1,\"name\":\"Distrito 1\",\"information\":\"distrito de cocha\",\"imageLink\":\"asdasd\"}}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/1/subDistrict", subDistrict)
                .accept(MediaType.APPLICATION_JSON).content(expected)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
    }

    /**
     * Test of update method, of class SubDistrictController.
     */
    @Test
    public void testUpdate() throws Exception{
        System.out.println("update");
        District district = new District("Distrito 1", "distrito de cocha");
        district.setImageLink("asdasd");
        district.setId(new Long(1));
        SubDistrict subDistrict = new SubDistrict("SubDistrito1", "SD1","sub distrito", "asddasda", district);
        subDistrict.setId(new Long(1));
        when(subDistrictRepository.findById(new Long(1))).thenReturn(Optional.of(subDistrict));
        String expected = "{\"id\":1,\"name\":\"SubDistrito1\",\"cod\":\"SD1\",\"information\":\"sub distrito\",\"imageLink\":\"asddasda\",\"district\":{\"id\":1,\"name\":\"Distrito 1\",\"information\":\"distrito de cocha\",\"imageLink\":\"asdasd\"}}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/1/subDistrict", subDistrict)
                .accept(MediaType.APPLICATION_JSON).content(expected)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.OK.value(), response.getStatus());
    }

    /**
     * Test of delete method, of class SubDistrictController.
     */
    @Test
    public void testDelete() throws Exception{
        System.out.println("delete");
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/subDistrict/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
}
