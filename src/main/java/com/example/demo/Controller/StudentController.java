package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Model.Student;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService studentService;
	
	//this is to get all students
	@GetMapping("/students")
	public ResponseEntity<List<Student>> getAllStudents() {
		return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
	}
	
	
	@PostMapping("/student")
	public ResponseEntity<String> addStudent(@RequestBody Student student) {
		studentService.addStudent(student);
		return ResponseEntity.status(HttpStatus.CREATED).body("Added");
	}
	
	
	@GetMapping("/students/{city}")
	public ResponseEntity<List<Student>> getAllStudentsWithCity(@PathVariable String city) {
		return ResponseEntity.status(HttpStatus.OK).body(studentService.getByCityName(city));
	}

	@GetMapping("/get/{teacher}")
	public ResponseEntity<List<Student>> getAllStudentsWithTeacherName(@PathVariable String teacher) {
		return ResponseEntity.status(HttpStatus.OK).body(studentService.getByTeacherName(teacher));
	}
	
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<Student> getAllStudentsById(@PathVariable String id) {
		return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentById(id));
	}
	
}
