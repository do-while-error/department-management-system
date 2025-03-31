package com.example.learning.controller;

import com.example.learning.domain.Department;
import com.example.learning.service.PublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("public")
public class PublicController {

	@Autowired
	PublicService publicService;

	@PostMapping("/create-dept")
	public ResponseEntity<Department> createDepartment(@RequestBody Department department){
		return new ResponseEntity<>(publicService.createDepartment(department), HttpStatus.OK);
	}

}
