package com.example.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Student;
import com.example.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@RestController
@RequestMapping(value="/student")
public class StudentController {
	@Autowired
	private StudentService service;
	
	private static final Logger logger = LogManager.getLogger(StudentController.class);
	//Create
	@PostMapping(path="/create")
	public ResponseEntity<Boolean> createStudent(@RequestBody Student stu) {
		service.createStudent(stu);
		ResponseEntity<Boolean> responseEntity = new ResponseEntity<Boolean>(true, HttpStatus.OK);
		System.out.println("response entity=" + responseEntity);
		return responseEntity;
	}
	
	//Read
	@GetMapping(path="/getdetails/{stuId}")
	public ResponseEntity<Student> findStudentbyId(@PathVariable("stuId") int stuId) {
		Student stu = service.findStudentById(stuId);
		return new ResponseEntity<Student>(stu, new HttpHeaders(), HttpStatus.OK);

	}
	
	//Read All
	@GetMapping(path="/getAll")
	public ResponseEntity<List<Student>> findAll() {
		logger.info("Getting students!");
		List<Student> list = service.findAllStudents();
		
		return new ResponseEntity<List<Student>>(list, new HttpHeaders(), HttpStatus.OK);
	}
	
	
	//Update
	@PutMapping(path="/update")
	public ResponseEntity<Student> updateStudent(@RequestBody Student stu) {
		stu = service.updateStudent(stu);
		return new ResponseEntity<Student>(stu, new HttpHeaders(), HttpStatus.OK);
	}
	
	
	//Delete
	public String deleteStudent(@PathVariable("stuId") int stuId) {
		service.deleteStudent(stuId);
		return "Deleted";
	}
	

}
