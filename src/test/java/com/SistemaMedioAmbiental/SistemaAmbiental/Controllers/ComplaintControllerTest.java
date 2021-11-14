/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SistemaMedioAmbiental.SistemaAmbiental.Controllers;

import com.SistemaMedioAmbiental.SistemaAmbiental.Models.Complaint;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.SistemaMedioAmbiental.SistemaAmbiental.Repositories.ComplaintRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;

import org.springframework.beans.factory.annotation.Autowired;
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

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
/**
 *
 * @author Antonio
 */

@RunWith(SpringRunner.class)
@WebMvcTest(value = ComplaintController.class, secure = false)

public class ComplaintControllerTest {
    
    @Autowired
    private  MockMvc mockMvc;
    
    @MockBean
    private ComplaintRepository complaintRepository;
    
    /*public ComplaintControllerTest() {
    }*/

    /**
     * Test of showComplaints method, of class ComplaintController.
     */
    @Test
    public void testShowComplaints() throws Exception {
        /*Complaint complaint = new Complaint("Antonio","Reporte", "Arboles sin regar" , 1.0f, 1.0f);
        complaint.setImageLink("imagen_arbolito");
        complaint.setId(new Long(1));
        System.out.println("showComplaints");*/
        
        List<Complaint> complaintList = new ArrayList<>();
        Complaint d1 = new Complaint("Antonio","Reporte", "Arboles sin regar" , 1.0f, 1.0f);
        d1.setId(new Long(1));
        d1.setImageLink("imagen_arbolito");
        Complaint d2 = new Complaint("Mauricio","Infome", "Arboles Talados" , 1.0f, 1.0f);
        d2.setId(new Long(2));
        d2.setImageLink("arbol_talado");
        complaintList.add(d1);
        complaintList.add(d2);
        
        //when(complaintRepository.findById(new Long(1))).thenReturn(Optional.ofNullable(complaint));
        
        when(complaintRepository.findAll()).thenReturn(complaintList);
        
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/complaint").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "[{\"id\":1,\"whistleblower\":\"Antonio\",\"information\":\"Arboles sin regar\",\"type\":\"Reporte\",\"imageLink\":\"imagen_arbolito\",\"latitude\":1,\"longitude\":1},"
                + "{\"id\":2,\"whistleblower\":\"Mauricio\",\"information\":\"Arboles Talados\",\"type\":\"Infome\",\"imageLink\":\"arbol_talado\",\"latitude\":1,\"longitude\":1}]" ;
        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(), true);
    }

    /**
     * Test of showComplaint method, of class ComplaintController.
     */
    @Test
    public void testShowComplaint() throws Exception{
        Complaint complaint = new Complaint("Antonio","Reporte", "Arboles sin regar" , 1.0f, 1.0f);
        complaint.setImageLink("imagen_arbolito");
        complaint.setId(new Long(1));
        System.out.println("showComplaints");
        when(complaintRepository.findById(new Long(1))).thenReturn(Optional.ofNullable(complaint));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/complaint/1").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "{\"id\":1,\"whistleblower\":\"Antonio\",\"information\":\"Arboles sin regar\",\"type\":\"Reporte\",\"imageLink\":\"imagen_arbolito\",\"latitude\":1,\"longitude\":1}" ;
        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(), true);
    }

    /**
     * Test of create method, of class ComplaintController.
     */
    @Test
    public void testCreate() throws Exception {
        System.out.println("create");
        Complaint complaint = new Complaint("Antonio","Reporte", "Arboles sin regar" , 1.0f, 1.0f);
        complaint.setImageLink("imagen_arbolito");
        complaint.setId(new Long(1));

        String expected = "{\"id\":1,\"whistleblower\":\"Antonio\",\"information\":\"Arboles sin regar\",\"type\":\"Reporte\",\"imageLink\":\"imagen_arbolito\",\"latitude\":1,\"longitude\":1}" ;
        when(complaintRepository.save(complaint)).thenReturn(complaint);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/complaint", complaint)
                .accept(MediaType.APPLICATION_JSON).content(expected)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        System.out.println(result.getResponse().getContentAsString());
        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
    }

    /**
     * Test of update method, of class ComplaintController.
     */
    @Test
    public void testUpdate() throws Exception{
        System.out.println("update");
        Complaint complaint = new Complaint("Antonio","Reporte", "Arboles sin regar" , 1.0f, 1.0f);
        complaint.setImageLink("imagen_arbolito");
        complaint.setId(new Long(1));
        
        when(complaintRepository.findById(new Long(1))).thenReturn(Optional.ofNullable(complaint));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/complaint/1").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "{\"id\":1,\"whistleblower\":\"Antonio\",\"information\":\"Arboles sin regar\",\"type\":\"Reporte\",\"imageLink\":\"imagen_arbolito\",\"latitude\":1,\"longitude\":1}" ;
        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(), true);
        
    }

    /**
     * Test of delete method, of class ComplaintController.
     */
    /*@Test
    public void testDelete() {
        System.out.println("delete");
        Long id = null;
        ComplaintController instance = new ComplaintController();
        instance.delete(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }*/
    
}
