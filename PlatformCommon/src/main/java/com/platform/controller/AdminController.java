package com.platform.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platform.entity.Admin;
import com.platform.repository.AdminRepository;
import com.platform.serviceinterface.AdminServiceInterface;

@CrossOrigin(originPatterns = "*")
@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminServiceInterface adminServiceInterface;
	
	@Autowired
	private AdminRepository adminRepository;
	
	@Autowired
	private PasswordEncoder PasswordEncoder;
	
	@PostMapping("/register")
	public ResponseEntity<Admin> addRegister(@RequestBody Admin admin){
		admin.setPassword( PasswordEncoder.encode(admin.getPassword()));
		return new ResponseEntity<Admin>(adminServiceInterface.registerAdmin(admin),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/logini")
	public ResponseEntity<String> logInUserHandler(Authentication auth){
		 Admin opt= adminRepository.findByEmail(auth.getName());
		 if(opt==null) throw new RuntimeException("No user found") ;
		 Admin user = opt;
		 return new ResponseEntity<>(user.getUsername()+" Logged In Successfully", HttpStatus.ACCEPTED);
	}
	
}
