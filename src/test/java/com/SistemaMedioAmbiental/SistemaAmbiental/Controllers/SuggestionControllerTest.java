/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SistemaMedioAmbiental.SistemaAmbiental.Controllers;

import com.SistemaMedioAmbiental.SistemaAmbiental.Models.Suggestion;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.SistemaMedioAmbiental.SistemaAmbiental.Repositories.SuggestionRepository;
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
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

/**
 *
 * @author Antonio
 */

@RunWith(SpringRunner.class)
@WebMvcTest(value = SuggestionController.class, secure = false)

public class SuggestionControllerTest {
    
        @Autowired
    private  MockMvc mockMvc;
    
    @MockBean
    private SuggestionRepository suggestionRepository;
    
    /*public SuggestionControllerTest() {
    }*/

    /**
     * Test of showSuggestions method, of class SuggestionController.
     */
    @Test
    public void testShowSuggestions() throws Exception{
        List<Suggestion> suggestionList = new ArrayList<>();
        Suggestion d1 = new Suggestion("Antonio", "Mejora", "Mejorar atencion");
        d1.setId(new Long(1));
        Suggestion d2 = new Suggestion("Mauricio", "Atencion", "Atencion al cliente deficiente");
        d2.setId(new Long(2));
        suggestionList.add(d1);
        suggestionList.add(d2);
        
        //when(complaintRepository.findById(new Long(1))).thenReturn(Optional.ofNullable(complaint));
        
        when(suggestionRepository.findAll()).thenReturn(suggestionList);
        
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/suggestion").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "[{\"id\":1,\"person\":\"Antonio\",\"information\":\"Mejorar atencion\",\"type\":\"Mejora\"},"
                + "{\"id\":2,\"person\":\"Mauricio\",\"information\":\"Atencion al cliente deficiente\",\"type\":\"Atencion\"}]"  ;
        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(), true);
        
    }

    /**
     * Test of showSuggestion method, of class SuggestionController.
     */
    @Test
    public void testShowSuggestion() throws Exception{
        Suggestion suggestion = new Suggestion("Antonio", "Mejora", "Mejorar atencion");
        suggestion.setId(new Long(1));
        System.out.println("showComplaints");
        when(suggestionRepository.findById(new Long(1))).thenReturn(Optional.ofNullable(suggestion));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/suggestion/1").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "{\"id\":1,\"person\":\"Antonio\",\"information\":\"Mejorar atencion\",\"type\":\"Mejora\"}" ;
        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(), true);
    }

    /**
     * Test of create method, of class SuggestionController.
     */
    @Test
    public void testCreate() throws Exception{
        System.out.println("create");
        Suggestion suggestion = new Suggestion("Antonio", "Mejora", "Mejorar atencion");
        suggestion.setId(new Long(1));
        
        String expected = "{\"id\":1,\"person\":\"Antonio\",\"information\":\"Mejorar atencion\",\"type\":\"Mejora\"}" ;
        when(suggestionRepository.save(suggestion)).thenReturn(suggestion);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/suggestion", suggestion)
                .accept(MediaType.APPLICATION_JSON).content(expected)
                .contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        System.out.println(result.getResponse().getContentAsString());
        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
    }

    /**
     * Test of update method, of class SuggestionController.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Suggestion suggestion = new Suggestion("Antonio", "Mejora", "Mejorar atencion");
        suggestion.setId(new Long(1));
        
        when(suggestionRepository.findById(new Long(1))).thenReturn(Optional.ofNullable(suggestion));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/suggestion/1").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        String expected = "{\"id\":1,\"person\":\"Antonio\",\"information\":\"Mejorar atencion\",\"type\":\"Mejora\"}" ;
        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(), true);
    }

    /**
     * Test of delete method, of class SuggestionController.
     */
    @Test
    public void testDelete() throws Exception{
        System.out.println("delete");
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/suggestion/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
    
}
