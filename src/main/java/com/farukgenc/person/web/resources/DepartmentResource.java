package com.farukgenc.person.web.resources;

import java.util.List;

import org.springframework.hateoas.Link;
import org.springframework.hateoas.ResourceSupport;

public class DepartmentResource extends ResourceSupport {

	private Link Id;

	private Long objId;

	public Long getObjId() {
		return objId;
	}

	public void setObjId(Long objId) {
		this.objId = objId;
	}

	private String departmentName;

	public Link getId() {
		return Id;
	}

	public void setId(Link id) {
		Id = id;
	}

	List<PersonResource> personList;

	public List<PersonResource> getPersonList() {
		return personList;
	}

	public void setPersonList(List<PersonResource> personList) {
		this.personList = personList;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

}
