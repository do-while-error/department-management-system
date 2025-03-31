package com.example.learning.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.learning.domain.Person;
import com.example.learning.repository.DepartmentRepository;
import com.example.learning.repository.PersonRepository;
import com.example.learning.service.PersonService;

import jakarta.transaction.Transactional;

@Service
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	@Transactional
	public Person addPerson(Person person) {
		System.out.println("inside addPerson");

//		if(personRepository.findById(person.getId()).isEmpty()) {
		System.out.println("dept" + person.getDepartment());
		person.setDepartment(departmentRepository.findById(person.getDepartment().getDeptId()).orElseThrow(() -> new RuntimeException("Department not found with ID:")));
		personRepository.save(person);
		return person;
//		}
//		throw new RuntimeException("ID already exist. Please change the ID and try again...");

	}

	@Override
	public List<Person> getAllPerson() {
		return personRepository.findAll();
	}

	@Override
	public Person getPersonById(Long id) {
		return personRepository.findById(id).orElseThrow(() -> new RuntimeException("Person not found with ID: " + id));
	}

	@Override
	public void deleteById(Long id) {
		Optional<Person> person = personRepository.findById(id);
		
		personRepository.delete(person.get());
		
		
//		personRepository.deleteById(id);
		
	}

}
