package com.data.main.employeesdata;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.data.main.departmentsdata.Department;

@RestController
public class EmployeesController {

	@Autowired
	EmployeesServices employeesServices;
	
	//show all employees based on departments
	@RequestMapping("departments/{departmentId}/employees")
	public List<Employee> showEmployees(@PathVariable Integer departmentId){
		return employeesServices.showEmployees(departmentId);
	}
	
	//find an employee based department
	@RequestMapping("departments/{departmentId}/employees/{id}")
	public Employee getEmployee(@PathVariable Integer id) {
		return employeesServices.getEmployee(id);
	}
	
	//create an employee
	@RequestMapping(method=RequestMethod.POST, value="departments/{departmentId}/employees")
	public String addEmployee(@RequestBody Employee employee, @PathVariable Integer departmentId) {
		employee.setDepartment(new Department(departmentId, ""));
		employeesServices.addEmployee(employee);
		return "Added!";
	}
	
	//update an employee
	@RequestMapping(method=RequestMethod.PUT, value="departments/{departmentId}/employees/{id}")
	public Employee updateEmployee(@PathVariable Integer departmentId, @Valid @RequestBody Employee employeeRequest, @PathVariable Integer id) {
		employeeRequest.setDepartment(new Department(departmentId, ""));
		return employeesServices.updateEmployee(employeeRequest, departmentId, id);
		
	}
	
	//delete an employee
	@RequestMapping(method=RequestMethod.DELETE, value="/departments/{departmentId}/employees/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable Integer departmentId, @PathVariable Integer id) {
		return employeesServices.deleteEmployee(departmentId, id);
		 
	}
}
