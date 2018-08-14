package com.farukgenc.person.web.resources;

import java.util.List;

import org.springframework.hateoas.ResourceSupport;

public class AssignmentResource extends ResourceSupport {

	private List<Long> personIdList;

	private Long departmentId;

	public List<Long> getPersonIdList() {
		return personIdList;
	}

	public void setPersonIdList(List<Long> personIdList) {
		this.personIdList = personIdList;
	}

	public Long getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}

}
