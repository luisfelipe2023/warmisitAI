package com.proyecto.warmisitAI.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.proyecto.warmisitAI.models.User;
import com.proyecto.warmisitAI.models.UserDTO;
import com.proyecto.warmisitAI.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User save(UserDTO userDTO) {
		User user = new User(userDTO.getEmail(), passwordEncoder.encode(userDTO.getPassword()) , userDTO.getRole(), userDTO.getFullname());
		return userRepository.save(user);
	}
}
