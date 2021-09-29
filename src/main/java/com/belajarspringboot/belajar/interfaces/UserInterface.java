/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belajarspringboot.belajar.interfaces;

import com.belajarspringboot.belajar.models.User;

/**
 *
 * @author Hudya
 */
public interface UserInterface {
    void register(User user) throws Exception;
    User auth(String email, String password) throws Exception;
}