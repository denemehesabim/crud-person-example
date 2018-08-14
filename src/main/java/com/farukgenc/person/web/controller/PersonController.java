package com.farukgenc.person.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farukgenc.person.exception.PersonNotFoundException;
import com.farukgenc.person.service.PersonService;
import com.farukgenc.person.web.resources.PersonResource;
import com.farukgenc.person.web.resources.PersonResourceAssembler;
import com.farukgenc.person.web.resources.SuccessResource;

@RestController
@RequestMapping(value = "/person")
public class PersonController {

	private PersonService personService;
	private PersonResourceAssembler personResourceAssembler;

	@Autowired
	public PersonController(PersonService personService, PersonResourceAssembler personResourceAssembler) {
		this.personService = personService;
		this.personResourceAssembler = personResourceAssembler;
	}

	@GetMapping
	public ResponseEntity<List<PersonResource>> getPersons() {
		return ResponseEntity.ok().body(personResourceAssembler.toResources(personService.getPersons()));
	}

	@GetMapping(value = "/{personId}")
	public ResponseEntity<PersonResource> getPersonById(@PathVariable Long personId) throws PersonNotFoundException {
		return ResponseEntity.ok().body(personResourceAssembler.toResource(personService.getPersonById(personId)));
	}

	@PostMapping
	public ResponseEntity<PersonResource> addPerson(@RequestBody PersonResource personResource) {
		return ResponseEntity.ok().body(personResourceAssembler.toResource(personService.addPerson(personResource)));
	}

	@PutMapping
	public ResponseEntity<PersonResource> updatePerson(@RequestBody PersonResource personResource)
			throws PersonNotFoundException {
		return ResponseEntity.ok().body(personResourceAssembler.toResource(personService.updatePerson(personResource)));
	}

	@DeleteMapping(value = "/{personId}")
	public ResponseEntity<SuccessResource> deletePerson(@PathVariable Long personId) throws PersonNotFoundException {
		return ResponseEntity.ok().body(personService.deletePerson(personId));
	}

}
