package com.proyecto.warmisitAI.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.proyecto.warmisitAI.models.UserDTO;
import com.proyecto.warmisitAI.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserDetailsService userDetailsService;
	
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/registration")
	public String getRegistrationPage(@ModelAttribute("user") UserDTO userDTO) {
		return "register";
	}
	
	@PostMapping("/registration")
	public String saveUser(@ModelAttribute("user") UserDTO userDTO, Model model) {
		userDTO.setRole("USER");
		
		userService.save(userDTO);
		
		model.addAttribute("user", "Registered Successfuly!");
	    model.addAttribute("user", new UserDTO());
		
	    return "register";
	}
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("user-page")
	public String userPage (Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		return "menu";
	}
	
	@GetMapping("admin-page")
	public String adminPage (Model model, Principal principal) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
		model.addAttribute("user", userDetails);
		return "admin";
	}
}