package com.SistemaMedioAmbiental.SistemaAmbiental.Controllers;

import com.SistemaMedioAmbiental.SistemaAmbiental.Message.request.SignUpForm;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class SignUpFormTest {
    public static final String EXPECTED_NAME= "Juan";
    public static final String EXPECTED_PHONE= "88127738";
    public static final String EXPECTED_EMAIL= "juan@gmail.com";
    public static final String EXPECTED_PASSWOR= "holahola";
    public static final String EXPECTED_PASSWORDCONFIRM= "holahola";
    public static final String EXPECTED_ADDRESS= "Calle Melchor";
    public static final String EXPECTED_IMAGELINK= "asdasd";
    public static final String EXPECTED_USERNAME= "Juan123";
    public static final boolean EXPECTED_STATUS= true;
    private SignUpForm signUpForm;

    @Before
    public void setUp() throws Exception {
        signUpForm = new SignUpForm();
        signUpForm.setAddress("Calle Melchor");
        signUpForm.setCi(new Long(1234566));
        signUpForm.setEmail("juan@gmail.com");
        signUpForm.setImageLink("asdasd");
        signUpForm.setName("Juan");
        signUpForm.setPhone("88127738");
        signUpForm.setPassword("holahola");
        signUpForm.setPasswordConfirm("holahola");
        signUpForm.setUsername("Juan123");
        signUpForm.setStatus(true);
    }


    @Test
    public void testUserDetails() throws Exception {
        Assert.assertEquals(EXPECTED_ADDRESS, signUpForm.getAddress());
        Assert.assertEquals(EXPECTED_EMAIL, signUpForm.getEmail());
        Assert.assertEquals(new Long(1234566), signUpForm.getCi());
        Assert.assertEquals(EXPECTED_IMAGELINK, signUpForm.getImageLink());
        Assert.assertEquals(EXPECTED_NAME, signUpForm.getName());
        Assert.assertEquals(EXPECTED_PASSWOR, signUpForm.getPassword());
        Assert.assertEquals(EXPECTED_PASSWORDCONFIRM, signUpForm.getPasswordConfirm());
        Assert.assertEquals(EXPECTED_PHONE, signUpForm.getPhone());
        Assert.assertEquals(EXPECTED_USERNAME, signUpForm.getUsername());
        Assert.assertEquals(EXPECTED_STATUS, signUpForm.getStatus());
    }
}
