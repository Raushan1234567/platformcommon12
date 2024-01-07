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

import com.platform.entity.Course;
import com.platform.entity.Student;
import com.platform.serviceinterface.CourseServiceInterface;

@RestController
@RequestMapping("/courses")
public class CourseController {

    @Autowired
    private CourseServiceInterface courseService;

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        Course createdCourse = courseService.createCourse(course);
        return new ResponseEntity<>(createdCourse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        List<Course> courses = courseService.getAllCourses();
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }

    @GetMapping("/{courseId}")
    public ResponseEntity<Course> getCourseById(@PathVariable Long courseId) {
        Course course = courseService.getCourseById(courseId);
        return new ResponseEntity<>(course, HttpStatus.OK);
    }

    @PostMapping("/assignStudents/{courseId}/{uniqueStudentCode}")
    public ResponseEntity<String> assignStudentsToCourse(@PathVariable Long courseId,@PathVariable Long uniqueStudentCode) {
        courseService.assignStudentsToCourse(courseId, uniqueStudentCode);
        return new ResponseEntity<>("Students assigned successfully to the course.", HttpStatus.OK);
    }
    
    @GetMapping("/student/{uniqueStudentCode}")
    public ResponseEntity<List<Course>> getCoursesByStudentId(@PathVariable Long uniqueStudentCode) {
        List<Course> courses = courseService.getCoursesByStudentId(uniqueStudentCode);
        return new ResponseEntity<>(courses, HttpStatus.OK);
    }
    
    @GetMapping("/{courseId}/students")
    public ResponseEntity<List<Student>> getStudentsAssignedToCourse(@PathVariable Long courseId) {
        List<Student> students = courseService.getStudentsAssignedToCourse(courseId);
        return ResponseEntity.ok(students);
    }
}
