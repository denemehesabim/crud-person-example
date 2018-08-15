package com.farukgenc.person.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.farukgenc.person.domain.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

	@Query("select department from Department department left join fetch department.persons person")
	List<Department> findAllDeparment();

}
