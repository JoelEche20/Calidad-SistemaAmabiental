/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SistemaMedioAmbiental.SistemaAmbiental.Controllers;

import com.SistemaMedioAmbiental.SistemaAmbiental.Message.request.LoginForm;
import com.SistemaMedioAmbiental.SistemaAmbiental.Message.request.SignUpForm;
import com.SistemaMedioAmbiental.SistemaAmbiental.Models.Feedback;
import com.SistemaMedioAmbiental.SistemaAmbiental.Models.User;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.SistemaMedioAmbiental.SistemaAmbiental.Repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 *
 * @author Antonio
 */
@RunWith(SpringRunner.class)
public class UserControllerTest {

    private MockMvc mockMvc;
    @InjectMocks
    UserController userController;

    @Mock
    UserRepository userRepository;

    @Before
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    public UserControllerTest() {
    }

    /**
     * Test of authenticateUser method, of class UserController.
     */
    @Test
    public void testAuthenticateUser() throws Exception {
        User user = new User("Mauricio","maugv3","123456","123456","maugv_77@hotmail.com","65347729",new Long(9353864),"calle los pinos","link");
        user.setId(new Long(1));
        String expected = "{ \"password\": \"maugv3\", \"username\": \"123456\" }";
        Mockito.when(userRepository.findById(new Long(1))).thenReturn(Optional.of(user));
        mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/signin")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(expected))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Test of registerUser method, of class UserController.
     */
    @Test
    public void testRegisterUser() throws Exception {
        User user = new User("Mauricio","maugv3","123456","123456","maugv_77@hotmail.com","65347729",new Long(9353864),"calle los pinos","link");
        user.setId(new Long(1));
        String expected = "{ \"address\": \"casa\", \"ci\": 9353864, \"email\": \"maugv_77@hotmail.com\", \"imageLink\": \"link\", \"name\": \"Mauricio Guevara\", \"password\": \"123456\", \"passwordConfirm\": \"123456\", \"phone\": \"65347729\", \"role\": [ \"ROLE_ADMIN\" ], \"status\": true, \"username\": \"maugv3\"}";
        mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/signup")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(expected))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Test of acceptRequest method, of class UserController.
     */
    @Test
    public void testAcceptRequest() throws Exception {
        User user = new User("Mauricio","maugv3","123456","123456","maugv_77@hotmail.com","65347729",new Long(9353864),"calle los pinos","link");
        user.setId(new Long(1));
        String expected = "{ \"address\": \"casa\", \"ci\": 9353864, \"email\": \"maugv_77@hotmail.com\", \"imageLink\": \"link\", \"name\": \"Mauricio Guevara\", \"password\": \"123456\", \"passwordConfirm\": \"123456\", \"phone\": \"65347729\", \"role\": [ \"ROLE_ADMIN\" ], \"status\": true, \"username\": \"maugv3\"}";
        //Mockito.when(userRepository.findById(new Long(1)).orElseGet(null));
        mockMvc.perform(MockMvcRequestBuilders.put("/api/auth/acceptRequest/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Test of denyRequest method, of class UserController.
     */
    @Test
    public void testDenyRequest() throws Exception {
        User user = new User("Mauricio","maugv3","123456","123456","maugv_77@hotmail.com","65347729",new Long(9353864),"calle los pinos","link");
        user.setId(new Long(1));
        String expected = "{ \"address\": \"casa\", \"ci\": 9353864, \"email\": \"maugv_77@hotmail.com\", \"imageLink\": \"link\", \"name\": \"Mauricio Guevara\", \"password\": \"123456\", \"passwordConfirm\": \"123456\", \"phone\": \"65347729\", \"role\": [ \"ROLE_ADMIN\" ], \"status\": true, \"username\": \"maugv3\"}";
        //Mockito.when(userRepository.findById(new Long(1)).orElseGet(null));
        mockMvc.perform(MockMvcRequestBuilders.put("/api/auth/denied/1")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Test of showUsers method, of class UserController.
     */
    @Test
    public void testShowUsers() throws Exception {
        User user = new User("Mauricio","maugv","maugv1234","maugv1234","maugv_77@hotmail.com","65347729",new Long(9353864),"calle los pinos","link");
        List<User> userList = Arrays.asList(user);
        Mockito.when(userRepository.findAll()).thenReturn(userList);
        mockMvc.perform(MockMvcRequestBuilders.get("/api/auth/users"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

    /**
     * Test of showUser method, of class UserController.
     */
    @Test
    public void testShowUser() throws Exception {
        User user = new User("Mauricio","maugv","maugv1234","maugv1234","maugv_77@hotmail.com","65347729",new Long(9353864),"calle los pinos","link");
        Mockito.when(userRepository.findById(new Long(1))).thenReturn(Optional.of(user));
        mockMvc.perform(MockMvcRequestBuilders.get("/api/auth/user/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk());
        Mockito.verify(userRepository).findById(new Long(1));
    }
}
