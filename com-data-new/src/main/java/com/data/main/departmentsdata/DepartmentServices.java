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

	public Department getDepartment(Integer departmentId) {
		return departmentRepository.findOne(departmentId);
	}

	public void addDepartment(Department department) {
		departmentRepository.save(department);
	}

	public void updateDepartment(Department department) {
		departmentRepository.save(department);		
	}

	public void deleteDepartment(Integer departmentId) {
		departmentRepository.delete(departmentId);
	}

}
