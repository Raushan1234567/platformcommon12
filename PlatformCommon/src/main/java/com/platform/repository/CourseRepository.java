package com.platform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.platform.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
