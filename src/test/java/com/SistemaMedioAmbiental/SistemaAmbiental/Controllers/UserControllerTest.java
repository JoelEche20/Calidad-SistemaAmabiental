/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SistemaMedioAmbiental.SistemaAmbiental.Controllers;

import com.SistemaMedioAmbiental.SistemaAmbiental.Message.request.LoginForm;
import com.SistemaMedioAmbiental.SistemaAmbiental.Message.request.SignUpForm;
import com.SistemaMedioAmbiental.SistemaAmbiental.Models.User;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.http.ResponseEntity;

/**
 *
 * @author Antonio
 */
public class UserControllerTest {
    
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
    public void testShowUsers() {
        System.out.println("showUsers");
        UserController instance = new UserController();
        List<User> expResult = null;
        List<User> result = instance.showUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of showUser method, of class UserController.
     */
    @Test
    public void testShowUser() {
        System.out.println("showUser");
        Long id = null;
        UserController instance = new UserController();
        User expResult = null;
        User result = instance.showUser(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
