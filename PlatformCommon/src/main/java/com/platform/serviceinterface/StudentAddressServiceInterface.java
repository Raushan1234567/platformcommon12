package com.platform.serviceinterface;

import java.util.List;

import com.platform.entity.StudentAddress;

public interface StudentAddressServiceInterface {
    public StudentAddress addStudentAddress(Long studentId, StudentAddress studentAddress);

    public List<StudentAddress> getAddressesByStudentId(Long studentId);
}

