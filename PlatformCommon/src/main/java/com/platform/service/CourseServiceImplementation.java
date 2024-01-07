package com.platform.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.entity.Course;
import com.platform.entity.Student;
import com.platform.exception.CourseNotFoundException;
import com.platform.exception.StudentNotFoundException;
import com.platform.repository.CourseRepository;
import com.platform.repository.StudentRepository;
import com.platform.serviceinterface.CourseServiceInterface;

@Service
public class CourseServiceImplementation implements CourseServiceInterface {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course getCourseById(Long courseId) {
        return courseRepository.findById(courseId)
                .orElseThrow(() -> new CourseNotFoundException("Course not found with id: " + courseId));
    }

    @Override
    public void assignStudentsToCourse(Long courseId, Long uniqueStudentCode) {
        Course course = getCourseById(courseId);
        Optional<Student> studentOptional = studentRepository.findById(uniqueStudentCode);

        if (studentOptional.isPresent()) {
            Student student = studentOptional.get();

            if (!course.getStudents().contains(student)) {
                course.getStudents().add(student);
                courseRepository.save(course);
            }
        } else {
            throw new StudentNotFoundException("Student not found");
        }
    }

    
   

        @Override
        public List<Course> getCoursesByStudentId(Long studentId) {
            Student student = studentRepository.findById(studentId)
                    .orElseThrow(() -> new StudentNotFoundException("Student not found with id: " + studentId));

            return student.getCourse();
        }
        
        @Override
        public List<Student> getStudentsAssignedToCourse(Long courseId) {
            Optional<Course> courseOptional = courseRepository.findById(courseId);

            if (courseOptional.isEmpty()) {
                throw new CourseNotFoundException("Course not found");
            }

            Course course = courseOptional.get();
            return new ArrayList<>(course.getStudents());
        }
    
}
