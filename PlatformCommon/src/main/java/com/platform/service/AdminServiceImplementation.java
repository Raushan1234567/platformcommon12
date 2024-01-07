package com.platform.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.entity.Admin;
import com.platform.exception.AdminAlreadyExistException;
import com.platform.repository.AdminRepository;
import com.platform.serviceinterface.AdminServiceInterface;

@Service
public class AdminServiceImplementation implements AdminServiceInterface{

	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public Admin registerAdmin(Admin admin) {
	    // Check if an admin with the same id already exists
	    Optional<Admin> optionalAdmin = adminRepository.findById(admin.getId());
	    
	    if (optionalAdmin.isPresent()) {
	        throw new AdminAlreadyExistException("Admin already exists with id: " + admin.getId());
	    }

	    // Save the new admin
	    return adminRepository.save(admin);
	}

}
