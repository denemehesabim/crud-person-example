package com.farukgenc.person.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.farukgenc.person.service.AssignmentService;
import com.farukgenc.person.web.resources.AssignmentResource;
import com.farukgenc.person.web.resources.DepartmentResource;

@RestController
@RequestMapping("/person")
public class AssignmentController {

	private AssignmentService assignmentService;

	@Autowired
	public AssignmentController(AssignmentService assignmentService) {
		this.assignmentService = assignmentService;
	}

	@PostMapping("/addDepartment")
	public ResponseEntity<DepartmentResource> assignmentDepartmentSuccess(
			@RequestBody AssignmentResource assignmentResource) {
		return ResponseEntity.ok().body(assignmentService.assignDepartmentSuccess(assignmentResource));
	}

}
