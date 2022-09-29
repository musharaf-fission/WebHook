package com.example.demo.Repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.demo.Model.Student;

public interface StudentRepository extends MongoRepository<Student, String> {

	@Query("{'subjects.teacherName':?0}")
	List<Student> findByTeacherName(String name);
	
	@Query("{'address.city':?0}")
	List<Student> findByCity(String city);

	
}
