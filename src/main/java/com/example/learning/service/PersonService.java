package com.example.learning.service;

import java.util.List;

import com.example.learning.domain.Person;

public interface PersonService {
	
	public Person addPerson(Person person);
	public List<Person> getAllPerson();
	public Person getPersonById(Long id);
	public void deleteById(Long id);
	
	
}
