package com.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.platform.entity.StudentAddress;

public interface StudentAddressrepository extends JpaRepository<StudentAddress,Long> {

}
