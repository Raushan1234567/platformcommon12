package com.platform.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.entity.Student;
import com.platform.entity.StudentAddress;
import com.platform.exception.StudentNotFoundException;
import com.platform.repository.StudentAddressrepository;
import com.platform.repository.StudentRepository;
import com.platform.serviceinterface.StudentAddressServiceInterface;

@Service
public class StudentAddressServiceImplementation implements StudentAddressServiceInterface{

    @Autowired
    private StudentAddressrepository studentAddressRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentAddress addStudentAddress(Long studentId, StudentAddress studentAddress) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + studentId));

        studentAddress.setStudent(student);
        return studentAddressRepository.save(studentAddress);
    }

    @Override
    public List<StudentAddress> getAddressesByStudentId(Long studentId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + studentId));

        return student.getAddresses();
    }

}
