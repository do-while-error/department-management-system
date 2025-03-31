package com.example.learning.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import com.example.learning.domain.Person;
import com.example.learning.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.learning.domain.Department;
import com.example.learning.repository.DepartmentRepository;
import com.example.learning.service.DepartmentService;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentRepository departmentRepository;

	@Autowired
	private PersonRepository personRepository;





	@Override
	public String deleteDepartment(Long deptID) {
		departmentRepository.delete(departmentRepository.findById(deptID).orElseThrow(() -> new RuntimeException("Department not found...!!")));
		return "Department with id: " + deptID + " is deleted!!";
	}

	@Override
	public List<Person> viewPersonByDepartment() {
		System.out.println("inside viewPersonByDepartment");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("authentication name:: " + authentication.getName());
		Department department = departmentRepository.findBydName(authentication.getName());
		System.out.println("department: " + department + " department id:" + department.getDeptId());

		List<Person> personList = new ArrayList<>();
		Department dept = departmentRepository.findById(department.getDeptId()).orElseThrow(() -> new RuntimeException("Department not found"));
        return personRepository.findByDepartment(dept);

	}

	@Override
	public List<Department> viewAllDepartment() {
		return departmentRepository.findAll();
	}

}
