/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belajarspringboot.belajar.interfaces;

import com.belajarspringboot.belajar.models.Todo;
import java.util.List;

/**
 *
 * @author Hudya
 */
public interface TodoInterface {
    List<Todo> getAll();
    void store(Todo todo);
    Todo getById(long id);
    void delete(long id);
}
