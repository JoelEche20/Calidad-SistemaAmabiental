/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SistemaMedioAmbiental.SistemaAmbiental.Controllers;

import com.SistemaMedioAmbiental.SistemaAmbiental.Models.Feedback;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.SistemaMedioAmbiental.SistemaAmbiental.Repositories.FeedbackRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(controllers = FeedbackController.class, secure = false)
@Import(FeedbackController.class)
public class FeedbackControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private FeedbackRepository feedbackRepository;
    public FeedbackControllerTest() {
    }

    /**
     * Test of showFeedbacks method, of class FeedbackController.
     */
    @Test
    public void testShowFeedbacks() throws Exception{
        List<Feedback> feedbacks = new ArrayList<>();
        Feedback f1 = new Feedback("Mauricio","Carnivora","Flor","Fruct","defo","foli");
        Feedback f2 = new Feedback("Mauricio","especie1","Flor1","Fruct1","defo1","foli1");
        f1.setId(new Long(1));
        f1.setImageLink("ImageLink");
        f2.setId(new Long(1));
        f2.setImageLink("ImageLink1");
        feedbacks.add(f1);
        feedbacks.add(f2);
        when(feedbackRepository.findAll()).thenReturn(feedbacks);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/feedback").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result.getResponse().getContentAsString());
        String expected = "[{\"id\":1,\"person\":\"Mauricio\",\"treeSpecies\":\"Carnivora\",\"flowering\":\"Flor\",\"fructification\":\"Fruct\",\"defoliation\":\"defo\",\"foliation\":\"foli\",\"imageLink\":\"ImageLink\"},{\"id\":1,\"person\":\"Mauricio\",\"treeSpecies\":\"especie1\",\"flowering\":\"Flor1\",\"fructification\":\"Fruct1\",\"defoliation\":\"defo1\",\"foliation\":\"foli1\",\"imageLink\":\"ImageLink1\"}]";
        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),false);
    }

    /**
     * Test of showFeedback method, of class FeedbackController.
     */
    @Test
    public void testShowFeedback() throws Exception {
        Feedback feedback = new Feedback("Mauricio","Carnivora","Flor","Fruct","defo","foli");
        feedback.setId(new Long(1));
        feedback.setImageLink("ImageLink");
        when(feedbackRepository.findById(new Long(1))).thenReturn(Optional.ofNullable(feedback));
        RequestBuilder requestBuilder = MockMvcRequestBuilders.get("/api/feedback/1").accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        System.out.println(result.getResponse().getContentAsString());
        String expected = "{\"id\":1,\"person\":\"Mauricio\",\"treeSpecies\":\"Carnivora\",\"flowering\":\"Flor\",\"fructification\":\"Fruct\",\"defoliation\":\"defo\",\"foliation\":\"foli\",\"imageLink\":\"ImageLink\"}";
        JSONAssert.assertEquals(expected,result.getResponse().getContentAsString(),false);
    }

    /**
     * Test of create method, of class FeedbackController.
     */
    @Test
    public void testCreate() throws Exception {
        Feedback feedback = new Feedback("Mauricio","Carnivora","Flor","Fruct","defo","foli");
        feedback.setId(new Long(1));
        feedback.setImageLink("ImageLink");
        String expected = "{\"id\":1,\"person\":\"Mauricio\",\"treeSpecies\":\"Carnivora\",\"flowering\":\"Flor\",\"fructification\":\"Fruct\",\"defoliation\":\"defo\",\"foliation\":\"foli\",\"imageLink\":\"ImageLink\"}";
        when(feedbackRepository.save(feedback)).thenReturn(feedback);
        RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/api/feedback",feedback).accept(MediaType.APPLICATION_JSON).content(expected).contentType(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        MockHttpServletResponse response = result.getResponse();
        assertEquals(HttpStatus.CREATED.value(), response.getStatus());
    }

    /**
     * Test of update method, of class FeedbackController.
     */
    @Test
    public void testUpdate() throws Exception {
        System.out.println("update");
        Long id = null;
        FeedbackController instance = new FeedbackController();
        instance.delete(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delete method, of class FeedbackController.
     */
    @Test
    public void testDelete() {
        System.out.println("delete");
        Long id = null;
        FeedbackController instance = new FeedbackController();
        instance.delete(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
