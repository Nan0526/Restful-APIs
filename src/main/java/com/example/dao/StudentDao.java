package com.example.dao;

import java.util.List;

import com.example.model.Student;


public interface StudentDao {
	//CURD - create/update/read/delete
	//create
	Student createStudent(Student stu);
	//read
	Student findStudentById(int stuId);
	List<Student> findAllStudents();
	
	//update
	Student updateStudent(Student stu);
		
	//delete
	void deleteStudent(int stuId);

	
}
