package com.examportal.ExamPortal.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.examportal.ExamPortal.models.PortalUser;

public interface UserRepository extends JpaRepository<PortalUser,Long> {

	PortalUser findByUsername(String username);

}
