package com.data.main.employeesdata;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeesServices {

	@Autowired
	EmployeesRepository employeesRepository;
	
	public List<Employee> showEmployees(Integer departmentId) {
		List<Employee> employee = new ArrayList<>();
		employeesRepository.findByDepartmentId(departmentId).forEach(employee::add);
		return employee;
	}

	public Employee getEmployee(Integer employeeId) {
		return employeesRepository.findByEmployeeId(employeeId);
	}

	public void addEmployee(Employee employee) {
		employeesRepository.save(employee);
	}

	public void updateEmployee(Employee employee) {
		employeesRepository.save(employee);
	}

	public void deleteEmployee(Integer id) {
		employeesRepository.delete(id);
	}

	
}
