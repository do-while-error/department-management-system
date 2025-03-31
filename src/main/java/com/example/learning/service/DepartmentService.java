package com.example.learning.service;

import java.util.List;

import com.example.learning.domain.Department;
import com.example.learning.domain.Person;

public interface DepartmentService {
	
	public List<Department> viewAllDepartment();

	public String deleteDepartment(Long deptID);
	public List<Person> viewPersonByDepartment();

}
