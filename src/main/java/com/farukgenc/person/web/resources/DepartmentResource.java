package com.farukgenc.person.web.resources;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class DepartmentResource extends ResourceSupport {

	private Long departmentId;

	private String departmentName;

	List<PersonResource> personList;

	public List<PersonResource> getPersonList() {
		return personList;
	}

	public void setPersonList(List<PersonResource> personList) {
		this.personList = personList;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
