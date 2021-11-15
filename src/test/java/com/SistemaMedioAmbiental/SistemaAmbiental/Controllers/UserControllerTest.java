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
    public void testAuthenticateUser() {
        System.out.println("authenticateUser");
        LoginForm loginRequest = null;
        UserController instance = new UserController();
        ResponseEntity expResult = null;
        ResponseEntity result = instance.authenticateUser(loginRequest);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of registerUser method, of class UserController.
     */
    @Test
    public void testRegisterUser() {
        System.out.println("registerUser");
        SignUpForm signUpRequest = null;
        UserController instance = new UserController();
        ResponseEntity expResult = null;
        ResponseEntity result = instance.registerUser(signUpRequest);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of acceptRequest method, of class UserController.
     */
    @Test
    public void testAcceptRequest() {
        System.out.println("acceptRequest");
        Long id = null;
        UserController instance = new UserController();
        User expResult = null;
        User result = instance.acceptRequest(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of denyRequest method, of class UserController.
     */
    @Test
    public void testDenyRequest() {
        System.out.println("denyRequest");
        Long id = null;
        UserController instance = new UserController();
        instance.denyRequest(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
