package com.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.platform.entity.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long>{
	
  public Admin findByEmail(String email);
}
