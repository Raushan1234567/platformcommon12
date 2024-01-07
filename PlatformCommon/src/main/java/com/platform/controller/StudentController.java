package com.platform.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.platform.entity.Course;
import com.platform.entity.Student;
import com.platform.serviceinterface.StudentServiceInterface;

@RestController
@RequestMapping("/students")
public class StudentController {
 
    @Autowired
    private StudentServiceInterface studentService;

    @PostMapping("/register")
    public ResponseEntity<Student> registerStudent(@RequestBody Student student) {
        Student registeredStudent = studentService.registerStudent(student);
        return ResponseEntity.ok(registeredStudent);
    }

    @PostMapping("/update/{id}/{DOB}")
    public ResponseEntity<Student> updateStudentById(@PathVariable Long id,@PathVariable String DOB, @RequestBody Student student) {
        Student updatedStudent = studentService.updateStudentById(id,DOB, student);
        return ResponseEntity.ok(updatedStudent);
    }

    @GetMapping("/list")
    public ResponseEntity<List<Student>> getStudentList() {
        List<Student> students = studentService.getStudentList();
        return ResponseEntity.ok(students);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Student>> getStudentsByName(@RequestParam String name) {
        List<Student> students = studentService.getStudentByName(name);
        return ResponseEntity.ok(students);
    }
    
    @GetMapping("/search/course/{name}/{uniqueStudentCode}/{dob}")
    public ResponseEntity<Course> getCourseByName(@RequestParam String name,@RequestParam long id,@RequestParam String dob) {
        Course students = studentService.getCourseByName(name,id,dob);
        return ResponseEntity.ok(students);
    }
    
    @DeleteMapping("/remove/course/{id}/{uniqueStudentCode}/{dob}")
    public ResponseEntity<Course> delete(@RequestParam long idC,@RequestParam long id,@RequestParam String dob) {
        Course students = studentService.delete(idC,id,dob); 
        return ResponseEntity.ok(students);
    }
}
