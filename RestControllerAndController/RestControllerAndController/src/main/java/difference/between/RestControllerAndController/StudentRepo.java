package com.hibernate.Mapping.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hibernate.Mapping.model.Student;

public interface StudentRepo extends JpaRepository<Student,Integer> {

}
