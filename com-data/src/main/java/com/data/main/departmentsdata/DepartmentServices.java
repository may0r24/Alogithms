package com.data.main.departmentsdata;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServices {
	
	@Autowired
	DepartmentRepository departmentRepository;

	public List<Department> showDepartments() {
		List<Department> department = new ArrayList<>();
		departmentRepository.findAll().forEach(department::add);
		return department;
	}

	public Department getDepartment(Integer id) {
		return departmentRepository.findOne(id);
	}

	public void addDepartment(Department employee) {
		departmentRepository.save(employee);
	}

	public void updateDepartment(Department employee) {
		departmentRepository.save(employee);		
	}

	public void deleteDepartment(Integer id) {
		departmentRepository.delete(id);
	}

}
