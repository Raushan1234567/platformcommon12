package com.platform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.platform.entity.StudentAddress;
import com.platform.serviceinterface.StudentAddressServiceInterface;

@RestController
@RequestMapping("/student-addresses")
public class StudentAddressController {

    @Autowired
    private StudentAddressServiceInterface studentAddressService;

    @PostMapping("/add/{studentId}")
    public ResponseEntity<StudentAddress> addStudentAddress( @PathVariable Long studentId,
            @RequestBody StudentAddress studentAddress) {
        StudentAddress addedAddress = studentAddressService.addStudentAddress(studentId, studentAddress);
        return new ResponseEntity<>(addedAddress, HttpStatus.CREATED);
    }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<StudentAddress>> getAddressesByStudentId(@PathVariable Long studentId) {
        List<StudentAddress> addresses = studentAddressService.getAddressesByStudentId(studentId);
        return new ResponseEntity<>(addresses, HttpStatus.OK);
    }
}
