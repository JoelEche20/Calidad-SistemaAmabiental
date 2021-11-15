/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SistemaMedioAmbiental.SistemaAmbiental.Controllers;

import com.SistemaMedioAmbiental.SistemaAmbiental.Models.Clasification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.SistemaMedioAmbiental.SistemaAmbiental.Models.District;
import com.SistemaMedioAmbiental.SistemaAmbiental.Models.Feedback;
import com.SistemaMedioAmbiental.SistemaAmbiental.Models.SubDistrict;
import com.SistemaMedioAmbiental.SistemaAmbiental.Repositories.ClasificationRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
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
        District district = new District("Distrito 1", "distrito de cocha");
        district.setImageLink("asdasd");
        district.setId(new Long(1));
        SubDistrict sd1 = new SubDistrict("SubDistrito1", "SD1","sub distrito", "asddasda", district);
        sd1.setId(new Long(1));
        Clasification c2 = new Clasification("Class1", "class1");
        c2.setId(new Long(1));
        c2.setImageLink("asdasd");
        c2.setSubDistrict(sd1);
        Clasification c1 = new Clasification("Class2", "class2");
        c1.setId(new Long(2));
        c1.setImageLink("asdasd");
        c1.setSubDistrict(sd1);
        List<Clasification> clasifications = new ArrayList<>();
        clasifications.add(c1);
        clasifications.add(c2);
        String expected = "[{\"id\":1,\"name\":\"Class1\",\"information\":\"class1\",\"imageLink\":\"asdasd\",\"subDistrict\":{\"id\":1,\"name\":\"SubDistrito1\",\"cod\":\"SD1\",\"information\":\"sub distrito\",\"imageLink\":\"asddasda\",\"district\":{\"id\":1,\"name\":\"Distrito 1\",\"information\":\"distrito de cocha\",\"imageLink\":\"asdasd\"}}},{\"id\":2,\"name\":\"Class2\",\"information\":\"class2\",\"imageLink\":\"asdasd\",\"subDistrict\":{\"id\":1,\"name\":\"SubDistrito1\",\"cod\":\"SD1\",\"information\":\"sub distrito\",\"imageLink\":\"asddasda\",\"district\":{\"id\":1,\"name\":\"Distrito 1\",\"information\":\"distrito de cocha\",\"imageLink\":\"asdasd\"}}}]";
        when(clasificationRepository.findAll()).thenReturn(clasifications);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/clasification").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(), false);
    }

    /**
     * Test of showClasification method, of class ClasificationController.
     */
    @Test
    public void testShowClasification_Long() throws Exception{
        System.out.println("showClasification");
        District district = new District("Distrito 1", "distrito de cocha");
        district.setImageLink("asdasd");
        district.setId(new Long(1));
        SubDistrict subDistrict = new SubDistrict("SubDistrito1", "SD1","sub distrito", "asddasda", district);
        subDistrict.setId(new Long(1));
        Clasification clasification = new Clasification("Class1", "class1");
        clasification.setId(new Long(1));
        clasification.setImageLink("asdasd");
        clasification.setSubDistrict(subDistrict);
        when(clasificationRepository.findById(new Long(1))).thenReturn(Optional.ofNullable(clasification));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/clasification/1").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "{\"id\":1,\"name\":\"Class1\",\"information\":\"class1\",\"imageLink\":\"asdasd\",\"subDistrict\":{\"id\":1,\"name\":\"SubDistrito1\",\"cod\":\"SD1\",\"information\":\"sub distrito\",\"imageLink\":\"asddasda\",\"district\":{\"id\":1,\"name\":\"Distrito 1\",\"information\":\"distrito de cocha\",\"imageLink\":\"asdasd\"}}}";
        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(), false);
    }

    /**
     * Test of showClasificationsSubDistrict method, of class ClasificationController.
     */
    @Test
    public void testShowClasificationsSubDistrict() throws Exception{
        System.out.println("showClasificationsSubDistrict");
        District district = new District("Distrito 1", "distrito de cocha");
        district.setImageLink("asdasd");
        district.setId(new Long(1));
        SubDistrict sd1 = new SubDistrict("SubDistrito1", "SD1","sub distrito", "asddasda", district);
        sd1.setId(new Long(1));
        Clasification c2 = new Clasification("Class1", "class1");
        c2.setId(new Long(1));
        c2.setImageLink("asdasd");
        c2.setSubDistrict(sd1);
        Clasification c1 = new Clasification("Class2", "class2");
        c1.setId(new Long(2));
        c1.setImageLink("asdasd");
        c1.setSubDistrict(sd1);
        List<Clasification> clasifications = new ArrayList<>();
        clasifications.add(c1);
        clasifications.add(c2);
        String expected = "[{\"id\":1,\"name\":\"Class1\",\"information\":\"class1\",\"imageLink\":\"asdasd\",\"subDistrict\":{\"id\":1,\"name\":\"SubDistrito1\",\"cod\":\"SD1\",\"information\":\"sub distrito\",\"imageLink\":\"asddasda\",\"district\":{\"id\":1,\"name\":\"Distrito 1\",\"information\":\"distrito de cocha\",\"imageLink\":\"asdasd\"}}},{\"id\":2,\"name\":\"Class2\",\"information\":\"class2\",\"imageLink\":\"asdasd\",\"subDistrict\":{\"id\":1,\"name\":\"SubDistrito1\",\"cod\":\"SD1\",\"information\":\"sub distrito\",\"imageLink\":\"asddasda\",\"district\":{\"id\":1,\"name\":\"Distrito 1\",\"information\":\"distrito de cocha\",\"imageLink\":\"asdasd\"}}}]";
        when(clasificationRepository.findAll()).thenReturn(clasifications);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/1/clasification").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(), false);
    }

    /**
     * Test of create method, of class ClasificationController.
     */
    @Test
    public void testCreate() throws Exception{
        System.out.println("create");
        District district = new District("Distrito 1", "distrito de cocha");
        district.setImageLink("asdasd");
        district.setId(new Long(1));
        SubDistrict subDistrict = new SubDistrict("SubDistrito1", "SD1","sub distrito", "asddasda", district);
        subDistrict.setId(new Long(1));
        Clasification clasification = new Clasification("Class1", "class1");
        clasification.setId(new Long(1));
        clasification.setImageLink("asdasd");
        clasification.setSubDistrict(subDistrict);
        when(clasificationRepository.save(clasification)).thenReturn(clasification);
        String expected = "{\"id\":1,\"name\":\"SubDistrito1\",\"cod\":\"SD1\",\"information\":\"sub distrito\",\"imageLink\":\"asddasda\",\"district\":{\"id\":1,\"name\":\"Distrito 1\",\"information\":\"distrito de cocha\",\"imageLink\":\"asdasd\"}}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/1/clasification", clasification)
                .accept(MediaType.APPLICATION_JSON).content(expected)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
    }

    /**
     * Test of update method, of class ClasificationController.
     */
    @Test
    public void testUpdate() throws Exception{
        System.out.println("update");
        System.out.println("create");
        District district = new District("Distrito 1", "distrito de cocha");
        district.setImageLink("asdasd");
        district.setId(new Long(1));
        SubDistrict subDistrict = new SubDistrict("SubDistrito1", "SD1","sub distrito", "asddasda", district);
        subDistrict.setId(new Long(1));
        Clasification clasification = new Clasification("Class1", "class1");
        clasification.setId(new Long(1));
        clasification.setImageLink("asdasd");
        clasification.setSubDistrict(subDistrict);
        when(clasificationRepository.findById(new Long(1))).thenReturn(Optional.of(clasification));
        String expected = "{\"id\":1,\"name\":\"SubDistrito1\",\"cod\":\"SD1\",\"information\":\"sub distrito\",\"imageLink\":\"asddasda\",\"district\":{\"id\":1,\"name\":\"Distrito 1\",\"information\":\"distrito de cocha\",\"imageLink\":\"asdasd\"}}";
        RequestBuilder requestBuilder = MockMvcRequestBuilders.put("/api/1/clasification", clasification)
                .accept(MediaType.APPLICATION_JSON).content(expected)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
    }

    /**
     * Test of delete method, of class ClasificationController.
     */
    @Test
    public void testDelete() throws Exception{
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/clasification/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
}
