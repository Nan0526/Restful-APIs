package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.StudentDao;
import com.example.model.Student;


@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	
	private StudentDao dao;
	
	@Override
	public Student createStudent(Student stu) {
		return dao.createStudent(stu);
	}


	@Override
	public Student findStudentById(int stuId) {
		return dao.findStudentById(stuId);
	}

	@Override
	public List<Student> findAllStudents() {
		return dao.findAllStudents();
	}
	
	@Override
	public Student updateStudent(Student stu) {
		return dao.updateStudent(stu);
	}

	@Override
	public void deleteStudent(int stuId) {
		dao.deleteStudent(stuId);

	}

}
