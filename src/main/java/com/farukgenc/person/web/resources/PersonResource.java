package com.farukgenc.person.web.resources;

import org.springframework.hateoas.ResourceSupport;

public class PersonResource extends ResourceSupport {

	private Long personId;

	private String name;

	private String surname;

	public Long getPersonId() {
		return personId;
	}

	public void setPersonId(Long personId) {
		this.personId = personId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

}
