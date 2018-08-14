package com.farukgenc.person.web.resources;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

import com.farukgenc.person.domain.Person;
import com.farukgenc.person.web.controller.DepartmentController;
import com.farukgenc.person.web.controller.PersonController;

@Component
public class PersonResourceAssembler extends ResourceAssemblerSupport<Person, PersonResource> {

	public PersonResourceAssembler() {
		super(PersonController.class, PersonResource.class);
	}

	@Override
	public PersonResource toResource(Person person) {
		PersonResource personResource = new PersonResource();
		personResource.setPersonId(person.getId());
		personResource.setName(person.getName());
		personResource.setSurname(person.getSurname());

		Link selfLink = ControllerLinkBuilder.linkTo(PersonController.class).slash(person.getId()).withSelfRel();
		Link selfRel = ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(PersonController.class).getPersons())
				.withRel("rel");

		Link departmentLink = ControllerLinkBuilder
				.linkTo(ControllerLinkBuilder.methodOn(DepartmentController.class).getAllDepartment())
				.withRel("department");

		personResource.add(selfLink);
		personResource.add(selfRel);
		personResource.add(departmentLink);
		return personResource;
	}

}
