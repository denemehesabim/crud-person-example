package com.farukgenc.person.web.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import com.farukgenc.person.domain.Department;
import com.farukgenc.person.domain.Person;
import com.farukgenc.person.web.controller.DepartmentController;
import com.farukgenc.person.web.controller.PersonController;

@Component
public class DepartmentResourceAssembler extends ResourceAssemblerSupport<Department, DepartmentResource> {

	public DepartmentResourceAssembler() {
		super(PersonController.class, DepartmentResource.class);
	}

	@Override
	public DepartmentResource toResource(Department department) {
		List<PersonResource> personResources = new ArrayList<>();

		DepartmentResource departmentResource = new DepartmentResource();
		departmentResource.setDepartmentId(department.getId());
		departmentResource.setDepartmentName(department.getName());

		if (!CollectionUtils.isEmpty(department.getPersons())) {
			for (Person person : department.getPersons()) {
				PersonResource personResource = new PersonResource();
				personResource.setName(person.getName());
				personResource.setPersonId(person.getId());
				personResource.setSurname(person.getSurname());
				personResources.add(personResource);
				departmentResource.setPersonList(personResources);
			}
		}
		
		Link departmentLink = ControllerLinkBuilder.linkTo(DepartmentController.class)
		.slash(department.getId()).withSelfRel();
		departmentResource.add(departmentLink);
		return departmentResource;
	}

}
