/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belajarspringboot.belajar;

import com.belajarspringboot.belajar.models.User;
import com.belajarspringboot.belajar.repositories.UserRepository;
import com.belajarspringboot.belajar.services.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 *
 * @author Hudya
 */
@SpringBootTest
public class UserIntegrationTests {

    @InjectMocks
    @Autowired
    UserService userService;

    @Mock
    UserRepository userRepository;

    @Test
    public void createUserTest() throws Exception {
        User user = new User();
        user.setEmail("test@email.com");
        user.setName("Hudya");
        user.setPassword("123456");

        when(userRepository.save(user)).thenReturn(user);
        userService.register(user);

        when(userRepository.findByEmail("test@mail.com")).thenReturn(user);

        User checkUser = this.userRepository.findByEmail("test@mail.com");

        Assertions.assertEquals(user, checkUser);
    }

    @Test
    public void createUserTestWithEmptyName() throws Exception {
        User user = new User();
        user.setEmail("test@email.com");
        user.setName("");
        user.setPassword("123456");

        when(userRepository.save(user)).thenReturn(user);
        userService.register(user);

        when(userRepository.findByEmail("test@mail.com")).thenReturn(user);

        User checkUser = this.userRepository.findByEmail("test@mail.com");

        Assertions.assertEquals(user, checkUser);
    }

    @Test
    public void createUserTestWithEmptyEmail() throws Exception {

        Throwable e = null;
        String message = null;

        try {
            User user = new User();
            user.setEmail("");
            user.setName("Test");
            user.setPassword("123456");

            when(userRepository.save(user))
                    .thenThrow(new Exception("Email cannot be null!"));
            
            userService.register(user);
        } catch (Exception ex) {
            e = ex;
            message = ex.getMessage();
        }

        Assertions.assertTrue(e instanceof Exception);
//        Assertions.assertEquals("Email cannot be null!", message);
    }

}
