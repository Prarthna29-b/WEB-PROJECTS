package com.hibernate.Mapping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.Mapping.model.Student;
import com.hibernate.Mapping.service.StudentService;

@Controller
public class StudentController {
	@Autowired 
	private StudentService service;

	@RequestMapping(value="/save",method = RequestMethod.POST,produce="application/json")
	public @ResponseBody Student add() {
	     return service.save(student);
	}
}
