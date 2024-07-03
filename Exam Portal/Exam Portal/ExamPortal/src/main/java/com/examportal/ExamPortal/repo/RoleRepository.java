package com.examportal.ExamPortal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examportal.ExamPortal.models.Role;

public interface RoleRepository extends JpaRepository<Role,Long> {

}
