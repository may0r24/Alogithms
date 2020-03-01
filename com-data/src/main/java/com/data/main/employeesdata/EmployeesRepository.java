package com.data.main.employeesdata;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface EmployeesRepository extends CrudRepository<Employee, Integer> {

	
	public List<Employee> findByDepartmentId(Integer id);

	public Employee findByEmployeeId(Integer employeeId);
}
