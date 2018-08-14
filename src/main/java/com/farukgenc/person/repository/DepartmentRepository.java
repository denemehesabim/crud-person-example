package com.farukgenc.person.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.farukgenc.person.domain.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
