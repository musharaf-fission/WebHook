package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Model.Student;
import com.example.demo.Model.Subject;
import com.example.demo.Repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepo;

	public List<Student> getAllStudents() {
		return studentRepo.findAll();
	}

	public void addStudent(Student student) {
		studentRepo.save(student);
	}

	
	public List<Subject> getAllTeachersByName() {
		List<Student> students = studentRepo.findAll();
		List<Subject> subjects = new ArrayList<>();
		
		for (Student stu : students) {
			subjects.addAll(stu.getSubjects());
		}
		return subjects;
	}

	public List<Student> getByCityName(String city) {
		return studentRepo.findByCity(city);
	}

	public List<Student> getByTeacherName(String teacher) {
		return studentRepo.findByTeacherName(teacher);
	}

	public Student getStudentById(String id) {
		return studentRepo.findById(id).orElse(null);
	}

}
