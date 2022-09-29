package com.example.demo.Model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "SchoolData")
public class Student {

	@Id
	private String id;
	private String name;
	private Integer rollNo;
	private List<Subject> subjects;
	private Address address;
}
