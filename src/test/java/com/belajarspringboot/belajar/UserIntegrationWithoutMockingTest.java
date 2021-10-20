/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belajarspringboot.belajar;

import com.belajarspringboot.belajar.interfaces.UserInterface;
import com.belajarspringboot.belajar.models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author Hudya
 */
@SpringBootTest
public class UserIntegrationWithoutMockingTest {
    
    
//    @Autowired
//    UserInterface userInterface;
//    
//    @Test
//    void createUserTest() throws Exception{
//        User user = new User();
//        user.setEmail("hudya123@mail.com");
//        user.setName("Hudya Ramadhana");
//        user.setPassword("123456");
//        
//        this.userInterface.register(user);
//        
//        User checkUser = this.userInterface.auth("hudya123@mail.com", "123456");
//        
//        Assertions.assertEquals(user.getEmail(), checkUser.getEmail());
//    }
    
}
