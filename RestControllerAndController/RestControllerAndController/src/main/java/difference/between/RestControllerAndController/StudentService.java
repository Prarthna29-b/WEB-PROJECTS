package com.hibernate.Mapping.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.Mapping.model.Student;
import com.hibernate.Mapping.repo.StudentRepo;


	@Service
	@Transactional
	public class StudentService {
		@Autowired
		private StudentRepo repo;
	public List<Student> listAll()
	{
		return repo.findAll();
		
	}
	 public void save(Student student) {
        repo.save(student);
    }
}
