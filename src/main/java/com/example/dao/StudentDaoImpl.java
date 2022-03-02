package com.example.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.example.model.Student;

@Repository
@Transactional

public class StudentDaoImpl implements StudentDao {
	//connection with data base
	@PersistenceContext
	private EntityManager entityManager;
	

	@Override
	public Student createStudent(Student stu) {
		return entityManager.merge(stu);
	}


	@Override
	public Student findStudentById(int stuId) {
		return entityManager.find(Student.class, stuId);
	}

	@Override
	public List<Student> findAllStudents() {
		Query q = entityManager.createQuery("select s from Student s");
		List<Student> list = q.getResultList();
		return list;
	}
	
	@Override
	public Student updateStudent(Student stu) {
		Student student = findStudentById(stu.getStuId());
		student.setStuName(stu.getStuName());
		student.setStuGra(stu.getStuGra());
		student = entityManager.merge(student);
		return student;
	}
	

	@Override
	public void deleteStudent(int stuId) {
		Student stu = entityManager.find(Student.class, stuId);
		entityManager.remove(stu);
	}

}
