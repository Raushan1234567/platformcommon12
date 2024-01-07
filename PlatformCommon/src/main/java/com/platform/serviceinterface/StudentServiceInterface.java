package com.platform.serviceinterface;

import java.util.List;

import com.platform.entity.Course;
import com.platform.entity.Student;

public interface StudentServiceInterface {
	
	public Student registerStudent(Student student);
	
	public Student updateStudentById(Long Id,String dOB, Student student);
	
	public List<Student> getStudentList();
	


	List<Student> getStudentByName(String name);

	public Course getCourseByName(String name, long id, String dob);

	public Course delete(long idC, long id, String dob);

}
