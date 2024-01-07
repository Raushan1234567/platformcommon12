package com.platform.serviceinterface;

import java.util.List;

import com.platform.entity.Course;
import com.platform.entity.Student;

public interface CourseServiceInterface {
   public  Course createCourse(Course course);
    List<Course> getAllCourses();
    Course getCourseById(Long courseId);
    List<Course> getCoursesByStudentId(Long uniqueStudentCode);
    public void assignStudentsToCourse(Long courseId, Long uniqueStudentCode);
	List<Student> getStudentsAssignedToCourse(Long courseId);
}
