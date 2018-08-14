package com.farukgenc.person.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.farukgenc.person.domain.Department;
import com.farukgenc.person.domain.Person;
import com.farukgenc.person.repository.DepartmentRepository;
import com.farukgenc.person.repository.PersonRepository;
import com.farukgenc.person.web.resources.AssignmentResource;
import com.farukgenc.person.web.resources.DepartmentResource;
import com.farukgenc.person.web.resources.PersonResource;

@Service
public class AssignmentService {

	// private static final Logger logger =
	// LoggerFactory.getLogger(AssignmentService.class);

	private PersonRepository personRepository;
	private DepartmentRepository departmentRepository;

	@Autowired
	public AssignmentService(PersonRepository personRepository, DepartmentRepository departmentRepository) {
		this.personRepository = personRepository;
		this.departmentRepository = departmentRepository;
	}

	@Transactional
	public DepartmentResource assignDepartmentSuccess(AssignmentResource assignmentResource) {
		// ---->> personFromDB içinde person1 , person2, person3 , person4 vb... var
		// List şeklinde tutuyor.
		// Bize verilen IdList'ten [1,2,3]'den getirdi.

		List<Person> personFromDB = personRepository.findByIdIn(assignmentResource.getPersonIdList());

		// department içerisinde assignmentResource'den gelen departmentId'mize göre
		// bunu databaseden getirdi.

		Optional<Department> department = departmentRepository.findById(assignmentResource.getDepartmentId());

		// Departman'ın içinde List<Person> içine bizim verdiğimiz değerler aktarıldı
		// [person1, person2, person3].

		department.get().setPersons(personFromDB);

		DepartmentResource departmentResource = new DepartmentResource();
		List<PersonResource> personResourceList = new ArrayList<>();
		for (Person p : personFromDB) {
			PersonResource personResource = new PersonResource();
			p.setDepartment(department.get());
			personRepository.save(p);
			personResource.setName(p.getName());
			personResource.setPersonId(p.getId());
			personResource.setSurname(p.getSurname());
			personResourceList.add(personResource);

		}
		departmentRepository.save(department.get());
		departmentResource.setDepartmentId(department.get().getId());
		departmentResource.setDepartmentName(department.get().getName());
		departmentResource.setPersonList(personResourceList);

		return departmentResource;
	}

}
