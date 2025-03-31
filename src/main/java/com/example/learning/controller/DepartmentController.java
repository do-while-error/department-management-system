package com.example.learning.controller;

import java.util.ArrayList;
import java.util.List;

import com.example.learning.domain.Person;
import com.example.learning.service.PublicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.learning.domain.Department;
import com.example.learning.service.DepartmentService;

@RestController
@RequestMapping("dept")
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;

	@Autowired
	private PublicService publicService;
	
//	@PostMapping("/create-dept")
//	public ResponseEntity<Department> createDepartemt(@RequestBody Department department){
//		return new ResponseEntity<>(publicService.createDepartment(department), HttpStatus.OK);
//	}
	
	@GetMapping("/view-all")
	public ResponseEntity<List<Department>> viewAllDepartment(){
		return new ResponseEntity<>(departmentService.viewAllDepartment(), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete-dept-id/{deptID}")
	public ResponseEntity<String> deleteDepartmentByID(@PathVariable Long deptID){
		try {
			return new ResponseEntity<>(departmentService.deleteDepartment(deptID),HttpStatus.OK);
			
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("Department not found!!",HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping("/department-specific-user")
	public ResponseEntity<List<Person>> getAllPersonFromSpecificDepartment() {
		System.out.println("inside getAllPersonFromSpecificDepartment");
		try {
			return new ResponseEntity<>(departmentService.viewPersonByDepartment(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(new ArrayList<>(),HttpStatus.NOT_FOUND);
		}
	}

}
