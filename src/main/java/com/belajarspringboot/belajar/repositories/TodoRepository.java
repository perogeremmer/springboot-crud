/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belajarspringboot.belajar.repositories;

import com.belajarspringboot.belajar.models.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Hudya
 */
@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{
    
}
