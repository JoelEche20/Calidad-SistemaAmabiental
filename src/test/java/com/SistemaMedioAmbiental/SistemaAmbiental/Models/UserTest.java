/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SistemaMedioAmbiental.SistemaAmbiental.Models;

import java.util.Set;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

/**
 *
 * @author Antonio
 */
@RunWith(SpringRunner.class)
public class UserTest {
    
    /*private MockMvc mockMvc;
    @InjectMocks
    User user;*/
    User user = new User("Antonio", "antoniomexd", "123", "123", "antonio@gmail.com", "911", 123L, "Cbba", "antonio_image" );

    /*public UserTest() {
    }*/

    /**
     * Test of getId method, of class User.
     */
    @Test
    public void testGetId() throws Exception {
        System.out.println("getId");
        Long expResult = null;
        Long result = user.getId();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setId method, of class User.
     */
    @Test
    public void testSetId() {
        System.out.println("setId");
        long id = 0L;
        User instance = new User();
        instance.setId(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class User.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        user.setName("Mauricio");
        assertEquals("Mauricio", user.getName());
    }

    /**
     * Test of setUsername method, of class User.
     */
    @Test
    public void testSetUsername() {
        System.out.println("setName");
        user.setUsername("maugv");
        assertEquals("maugv", user.getUsername());
    }

    /**
     * Test of setPassword method, of class User.
     */
    @Test
    public void testSetPassword() {
        System.out.println("setPassword");
        user.setPassword("123m");
        assertEquals("123m", user.getPassword());
    }

    /**
     * Test of setPasswordConfirm method, of class User.
     */
    @Test
    public void testSetPasswordConfirm() {
        System.out.println("setPasswordConfirm");
        user.setPasswordConfirm("123");
        assertEquals("123", user.getPasswordConfirm());
    }

    /**
     * Test of setEmail method, of class User.
     */
    @Test
    public void testSetEmail() {
        System.out.println("setEmail");
        user.setEmail("maugv@gmail.com");
        assertEquals("maugv@gmail.com", user.getEmail());
    }

    /**
     * Test of setPhone method, of class User.
     */
    @Test
    public void testSetPhone() {
        System.out.println("setPhone");
        user.setPhone("110");
        assertEquals("110", user.getPhone());
    }

    /**
     * Test of setCi method, of class User.
     */
    @Test
    public void testSetCi() {
        System.out.println("setCi");
        user.setCi(Long.valueOf(456));
        assertEquals(Long.valueOf(456), user.getCi());
    }

    /**
     * Test of setAddress method, of class User.
     */
    @Test
    public void testSetAddress() {
        System.out.println("setAddress");
        user.setAddress("Tiquipaya");
        assertEquals("Tiquipaya", user.getAddress());
    }

    /**
     * Test of setImageLink method, of class User.
     */
    @Test
    public void testSetImageLink() {
        System.out.println("setImageLink");
        user.setImageLink("Img_Mau");
        assertEquals("Img_Mau", user.getImageLink());
    }

    
}
