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

import com.farukgenc.person.exception.DepartmentNotFoundException;
import com.farukgenc.person.service.DepartmentService;
import com.farukgenc.person.web.resources.DepartmentResource;
import com.farukgenc.person.web.resources.DepartmentResourceAssembler;
import com.farukgenc.person.web.resources.SuccessResource;

@RestController
@RequestMapping("/department")
public class DepartmentController {

	private DepartmentService departmentService;
	private DepartmentResourceAssembler departmentResourceAssembler;

	@Autowired
	public DepartmentController(DepartmentService departmentService,
			DepartmentResourceAssembler departmentResourceAssembler) {
		this.departmentService = departmentService;
		this.departmentResourceAssembler = departmentResourceAssembler;
	}

	@GetMapping
	public ResponseEntity<List<DepartmentResource>> getAllDepartment() {
		return ResponseEntity.ok().body(departmentResourceAssembler.toResources(departmentService.getAllDepartment()));
	}

	@PostMapping
	public ResponseEntity<DepartmentResource> addDepartment(@RequestBody DepartmentResource departmentResource) {
		return ResponseEntity.ok()
				.body(departmentResourceAssembler.toResource(departmentService.addDepartment(departmentResource)));
	}

	@PutMapping
	public ResponseEntity<DepartmentResource> updateDepartment(@RequestBody DepartmentResource departmentResource)
			throws DepartmentNotFoundException {
		return ResponseEntity.ok()
				.body(departmentResourceAssembler.toResource(departmentService.updateDepartment(departmentResource)));
	}

	@GetMapping(value = "/{departmentId}")
	public ResponseEntity<DepartmentResource> getDepartment(@PathVariable Long departmentId)
			throws DepartmentNotFoundException {
		return ResponseEntity.ok()
				.body(departmentResourceAssembler.toResource(departmentService.getDepartment(departmentId)));
	}

	@DeleteMapping("/{departmentId}")
	public ResponseEntity<SuccessResource> deleteDepartment(@PathVariable Long departmentId)
			throws DepartmentNotFoundException {
		return ResponseEntity.ok().body(departmentService.deleteDepartment(departmentId));
	}

}
