/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.SistemaMedioAmbiental.SistemaAmbiental.Controllers;

import com.SistemaMedioAmbiental.SistemaAmbiental.Models.Role;
import com.SistemaMedioAmbiental.SistemaAmbiental.Models.RoleName;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.fail;

/**
 *
 * @author mAURICIO
 */
public class roleModelTest {

    @Test
    public void getRoleId() throws Exception {
        Role role = new Role();
        role.setId(new Long(1));
        System.out.println(role);
        Assert.assertEquals(new Long(1),role.getId());
    }
}
