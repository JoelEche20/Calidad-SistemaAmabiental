/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SistemaMedioAmbiental.SistemaAmbiental.Controllers;

import com.SistemaMedioAmbiental.SistemaAmbiental.Models.Feedback;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.SistemaMedioAmbiental.SistemaAmbiental.Repositories.FeedbackRepository;
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

@RunWith(SpringRunner.class)
public class FeedbackControllerTest {

    private MockMvc mockMvc;
    @InjectMocks
    FeedbackController feedbackController;

    @Mock
    FeedbackRepository feedbackRepository;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(feedbackController).build();
    }

    @Test
    public void testShowFeedbacks() throws Exception {
        List<Feedback> feedbacks = Arrays.asList(new Feedback("Mauricio","Carnivora","Flor","Fruct","defo","foli"));
        Mockito.when(feedbackRepository.findAll()).thenReturn(feedbacks);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/feedback"))
                .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void testShowFeedback() throws Exception {
        Feedback feedback = new Feedback("Mauricio","Carnivora","Flor","Fruct","defo","foli");
        Mockito.when(feedbackRepository.findById(new Long(1))).thenReturn(Optional.of(feedback));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/feedback/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(feedbackRepository).findById(new Long(1));
    }

    @Test
    public void testCreate() throws Exception {
        String expected = "{\"id\":1,\"person\":\"Mauricio\",\"treeSpecies\":\"Carnivora1\",\"flowering\":\"Flor1\",\"fructification\":\"Fruct1\",\"defoliation\":\"defo1\",\"foliation\":\"foli1\",\"imageLink\":\"ImageLink1\"}";
        Feedback feedback = new Feedback("Mauricio","Carnivora","Flor","Fruct","defo","foli");
        mockMvc.perform(MockMvcRequestBuilders.post("/api/feedback")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(expected))
                .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    public void testUpdate() throws Exception {
        Feedback feedback = new Feedback("Mauricio","Carnivora","Flor","Fruct","defo","foli");
        String expected = "{\"id\":1,\"person\":\"Mauricio\",\"treeSpecies\":\"Carnivora1\",\"flowering\":\"Flor1\",\"fructification\":\"Fruct1\",\"defoliation\":\"defo1\",\"foliation\":\"foli1\",\"imageLink\":\"ImageLink1\"}";
        feedback.setId(new Long(1));
        feedback.setImageLink("ImageLink");
        mockMvc.perform(MockMvcRequestBuilders.put("/api/feedback/1").contentType(MediaType.APPLICATION_JSON)
                .content(expected)).andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    public void testDelete() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/api/feedback/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }


}
