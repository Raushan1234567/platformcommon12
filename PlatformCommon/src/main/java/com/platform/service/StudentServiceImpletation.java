package com.platform.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.platform.entity.Course;
import com.platform.entity.Student;
import com.platform.exception.CourseNotFoundException;
import com.platform.exception.StudentAllreadyExist;
import com.platform.exception.StudentNotFoundException;
import com.platform.repository.CourseRepository;
import com.platform.repository.StudentRepository;
import com.platform.serviceinterface.StudentServiceInterface;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class StudentServiceImpletation implements StudentServiceInterface {



	private final StudentRepository studentRepository;
	
	private final CourseRepository courseRepository;

	@Override
	public Student registerStudent(Student student) {
		
		Student studentfindByEmail=studentRepository.findByEmail(student.getEmail());
		if(studentfindByEmail !=null) {
			throw new StudentAllreadyExist("Student alredy exist by this email ");
		}
		return studentRepository.save(student);
	}

	    @Override
	    public Student updateStudentById(Long id,String dOB, Student student) {
	      
	        Optional<Student> stu1 = studentRepository.findById(id);
	        if(stu1.isEmpty()) {
	        throw new StudentNotFoundException("Student not found");
	        }
	        Student stu=stu1.get();
	        System.out.println(stu);
	        
	        LocalDate parsedDate = LocalDate.parse(dOB);
	        
	       if(stu.getDateOfBirth().isEqual(parsedDate)) {
	    	   
	       }else {
	    	   throw new StudentNotFoundException("Student ");
	       }
	        stu.setName(student.getName());
	        stu.setDateOfBirth(student.getDateOfBirth());
	        stu.setGender(student.getGender());
	        stu.setAddresses(student.getAddresses());
	        stu.setEmail(student.getEmail());
	        
	       

	    
	        return studentRepository.save(stu);
	    }


	@Override
	public List<Student> getStudentList() {
	
		return studentRepository.findAll();
	}

	@Override
    public List<Student> getStudentByName(String name) {
      
        List<Student> students = studentRepository.findByName(name);
        
       
        if (students.isEmpty()) {
            throw new StudentNotFoundException("Students not found with the given name");
        }
        
        return students;
    }

	@Override 
	public Course getCourseByName(String name, long id, String dob) {
		
		 Optional<Student> stu1 = studentRepository.findById(id);
	        if(stu1.isEmpty()) {
	        throw new StudentNotFoundException("Student not found");
	        }
	        Student stu=stu1.get();
	        LocalDate parsedDate = LocalDate.parse(dob);
	        
		       if(stu.getDateOfBirth().isEqual(parsedDate)) {
		    	   
		       }else {
		    	   throw new StudentNotFoundException("Student ");
		       }
		       
		       List<Course> y= stu.getCourse();
		       for(Course c:y) {
		    	   if(c.getCourseName().equalsIgnoreCase(name)) {
		    		   return c;  
		    	   }
		       }
		      
		      throw new StudentNotFoundException("No name ");
	}

	@Override
	
	public Course delete(long idC, long id, String dob) {
	    Optional<Student> studentOptional = studentRepository.findById(id);
	    
	    if (studentOptional.isEmpty()) {
	        throw new StudentNotFoundException("Student not found");
	    }
	    
	    Student student = studentOptional.get();
	    LocalDate parsedDate = LocalDate.parse(dob);

	    if (student.getDateOfBirth().isEqual(parsedDate)) {
	    	
	        List<Course> updatedCourses = new ArrayList<>();
	        Course deletedCourse = null;

	        for (Course course : student.getCourse()) {
	            if (course.getId() == idC) {
	                deletedCourse = course;
	              
	            } else {
	                updatedCourses.add(course);
	            }
	        }

	        if (deletedCourse != null) {
	           
	            student.setCourse(updatedCourses);
	            
	            Optional<Course> courses =  courseRepository.findById(idC);
	            Course cou=courses.get();
	            List<Student> stud = new ArrayList<>();
	            
	            for (Student stu : cou.getStudents()) {
		            if (stu.getUniqueStudentCode() == id) {
		               
		            } else {
		            	stud.add(stu);
		            }
		        }
	            cou.setStudents(stud);
	            courseRepository.save(cou);
	            
	            studentRepository.save(student);
	            
	            
	            return deletedCourse;
	        } else {
	            throw new CourseNotFoundException("Course not found for deletion");
	        }
	    } else {
	        throw new StudentNotFoundException("Student not found");
	    }
	}



	
}
