/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tabeldata.pln.controller;

import com.tabeldata.pln.model.User;
import com.tabeldata.pln.model.UserRoles;
import com.tabeldata.pln.model.repository.RoleRepository;
import com.tabeldata.pln.model.repository.UserRepository;
import com.tabeldata.pln.model.repository.UserRolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Diani
 */
@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    UserRepository userRepository;
    
    @Autowired
    RoleRepository roleRepository;
    
    @Autowired
    UserRolesRepository userRolesRepository;
    
    @GetMapping("/new")
    public String newUser(User user, Model model) {
        model.addAttribute("u", user);
        
        return "/user/addUser";
    }
 
     @PostMapping("/new")
    public String submitNewUser(User user) {
        userRepository.save(user);

        System.out.println(user.toString());
        return "redirect:/home";
    }
    
    @GetMapping("/role")
    public String roleUser(UserRoles userRoles, Model model) {
        model.addAttribute("ur", userRoles);
        model.addAttribute("listUser", userRepository.findAll());
        model.addAttribute("listRole", roleRepository.findAll());
        
        return "/user/roleUser";
    }
    
    @PostMapping("/role")
    public String submitRoleUser(UserRoles userRoles) {
        userRolesRepository.save(userRoles);

        System.out.println(userRoles.toString());
        return "redirect:/user/list";
    }
    
    @GetMapping("/aktivasi")
    public String activationUser(@RequestParam(name = "id", required = true) User user, Model model) {
        model.addAttribute("ur", user);
        model.addAttribute("listUser", userRepository.findAll());
                
        return "/user/activationUser";
    }
    
    @PostMapping("/aktivasi")
    public String submitActivationUser(User user) {
        userRepository.save(user);

        System.out.println(user.toString());
        return "redirect:/user/role";
    }
    
     @GetMapping("/list")
    public String indexHtml(Model model) {

        
        model.addAttribute("listUser", userRepository.findAll());

        return "/user/listUser";
    }
}
