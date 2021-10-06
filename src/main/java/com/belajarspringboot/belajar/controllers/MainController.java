/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.belajarspringboot.belajar.controllers;

import com.belajarspringboot.belajar.interfaces.CategoryInterface;
import com.belajarspringboot.belajar.interfaces.TodoInterface;
import com.belajarspringboot.belajar.models.Category;
import com.belajarspringboot.belajar.models.Tags;
import com.belajarspringboot.belajar.models.Todo;
import com.belajarspringboot.belajar.models.User;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Hudya
 */
@Controller
public class MainController {

    @Autowired
    private TodoInterface todoInterface;
    
    @Autowired
    private CategoryInterface categoryInterface;

    @GetMapping("/")
    public String index(Model model,  HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        
        long user_id = (long) session.getAttribute("id");
        
        List<Todo> todos = todoInterface.findByUserId(user_id);
        
        model.addAttribute("todos", todos);
        return "index";
    }

    @GetMapping("/todo/create")
    public String create(Model model) {
        
        List<Category> categories = categoryInterface.getAll();
        model.addAttribute("categories", categories);
        
        List<Category> categories2 = categoryInterface.getAll();
        model.addAttribute("categories2", categories2);
        
        Todo todo = new Todo();
        model.addAttribute("todo", todo);

        return "create";
    }

    @PostMapping("/todo/store")
    public String store(@ModelAttribute("todo") Todo todo, HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        
        User user = new User();
        user.setId((long) session.getAttribute("id"));
        
        todo.setUser(user);

        todoInterface.store(todo);
        return "redirect:/";
    }

    @GetMapping("/todo/{id}/edit")
    public String edit(@PathVariable(value = "id") long id, Model model) {
        List<Category> categories = categoryInterface.getAll();
        model.addAttribute("categories", categories);
        
        Todo todo = todoInterface.getById(id);

        model.addAttribute("todo", todo);
        return "edit";
    }

    @PostMapping("/todo/{id}/delete")
    public String delete(@PathVariable(value = "id") long id) {
        todoInterface.delete(id);
        return "redirect:/";
    }
}
