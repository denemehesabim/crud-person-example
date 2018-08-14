package com.farukgenc.person.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farukgenc.person.domain.Person;
import com.farukgenc.person.exception.PersonNotFoundException;
import com.farukgenc.person.repository.PersonRepository;
import com.farukgenc.person.web.resources.PersonResource;
import com.farukgenc.person.web.resources.SuccessResource;

@Service
public class PersonService {

	private PersonRepository personRepository;

	@Autowired
	public PersonService(PersonRepository personRepository) {
		this.personRepository = personRepository;
	}

	public List<Person> getPersons() {
		return personRepository.findAll();
	}

	public Person addPerson(PersonResource personResource) {
		Person person = new Person();
		person.setId(personResource.getPersonId());
		person.setName(personResource.getName());
		person.setSurname(personResource.getSurname());
		personRepository.save(person);
		return person;
	}

	public Person getPersonById(Long personId) throws PersonNotFoundException {
		Optional<Person> tempPerson = personRepository.findById(personId);
		if (tempPerson.isPresent()) {
			return tempPerson.get();
		} else {
			throw new PersonNotFoundException("404", "Person Not Found Bro !");
		}
	}

	public Person updatePerson(PersonResource personResource) throws PersonNotFoundException {
		Optional<Person> tempPerson = personRepository.findById(personResource.getPersonId());
		if (tempPerson.isPresent()) {
			tempPerson.get().setName(personResource.getName());
			tempPerson.get().setSurname(personResource.getSurname());
			return personRepository.save(tempPerson.get());
		}
		throw new PersonNotFoundException("404", "Person Not Found Brooo!");
	}

	public SuccessResource deletePerson(Long personId) throws PersonNotFoundException {
		Optional<Person> tempPerson = personRepository.findById(personId);
		if (tempPerson.isPresent()) {
			personRepository.deleteById(personId);
			SuccessResource resource = new SuccessResource();
			resource.setSuccessCode("204");
			resource.setDescription("Person is deleted...");
			return resource;
		}
		throw new PersonNotFoundException("404", "Person Not Found Broooooo!");
	}

}
