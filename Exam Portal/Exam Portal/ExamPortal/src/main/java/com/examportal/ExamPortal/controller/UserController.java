package com.examportal.ExamPortal.controller;

import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.examportal.ExamPortal.models.PortalUser;
import com.examportal.ExamPortal.models.UserRoles;
import com.examportal.ExamPortal.service.UserService;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
	@Autowired
	UserService userservice;

	@PostMapping("/create")
	public PortalUser create(@RequestBody PortalUser portalUser) throws Exception {
		Set<UserRoles> set = new HashSet<>();

		return userservice.create(portalUser, set);
	}

	@GetMapping("/{username}")
	public PortalUser get(@PathVariable String username) {
		return userservice.get(username);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		userservice.delete(id);
	}

	@PutMapping("/{email}")
	public ResponseEntity<?> update(@RequestBody PortalUser portalUser, @PathVariable String email) {
		try {
			PortalUser existuser = userservice.get(email);
			userservice.save(portalUser);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/list")
	public List<PortalUser> list() {
		return userservice.listAll();
	}
}