package com.farukgenc.person.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farukgenc.person.domain.Department;
import com.farukgenc.person.exception.DepartmentNotFoundException;
import com.farukgenc.person.repository.DepartmentRepository;
import com.farukgenc.person.web.resources.DepartmentResource;
import com.farukgenc.person.web.resources.SuccessResource;

@Service
public class DepartmentService {

	private DepartmentRepository departmentRepository;

	@Autowired
	public DepartmentService(DepartmentRepository departmentRepository) {
		this.departmentRepository = departmentRepository;
	}

	public Department addDepartment(DepartmentResource departmentResource) {
		Department department = new Department();
		department.setId(departmentResource.getDepartmentId());
		department.setName(departmentResource.getDepartmentName());
		return departmentRepository.save(department);
	}

	public Department updateDepartment(DepartmentResource departmentResource) throws DepartmentNotFoundException {
		Optional<Department> tempDepartment = departmentRepository.findById(departmentResource.getDepartmentId());
		if (tempDepartment.isPresent()) {
			Department department = new Department();
			department.setId(departmentResource.getDepartmentId());
			department.setName(departmentResource.getDepartmentName());
			return departmentRepository.save(department);
		}
		throw new DepartmentNotFoundException("404", "Department Not Found Brooo!");
	}

	public Department getDepartment(Long departmentId) throws DepartmentNotFoundException {
		Optional<Department> department = departmentRepository.findById(departmentId);
		if (department.isPresent()) {
			return department.get();
		} else {
			throw new DepartmentNotFoundException("404", "Department Not Found Brooo!");
		}
	}

	public SuccessResource deleteDepartment(Long departmentId) throws DepartmentNotFoundException {
		Optional<Department> department = departmentRepository.findById(departmentId);
		if (department.isPresent()) {
			departmentRepository.deleteById(departmentId);
			SuccessResource resource = new SuccessResource();
			resource.setSuccessCode("204");
			resource.setDescription("Department is deleted...");
			return resource;
		}
		throw new DepartmentNotFoundException("404", "Department Not Found ! ");
	}

	public List<Department> getAllDepartment() {
		return departmentRepository.findAll();
	}

}
