package com.data.main.employeesdata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeesController {

	@Autowired
	EmployeesServices employeesServices;
	
	@RequestMapping("/departments/{departmentId}/employees")
	public List<Employee> showEmployees(@PathVariable Integer departmentId){
		return employeesServices.showEmployees(departmentId);
	}
	
	@RequestMapping("departments/{departmentId}/employees/{id}")
	public Employee getEmployee(@PathVariable Integer id) {
		return employeesServices.getEmployee(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="departments/{departmentId}/employees")
	public String addEmployee(@RequestBody Employee employee, @PathVariable Integer departmentId) {
		employee.setDepartment(departmentId);
		employeesServices.addEmployee(employee);
		return "Added!";
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="departments/{departmentId}/employees/{id}")
	public String updateEmployee(@PathVariable Integer departmentId, @PathVariable String id, @RequestBody Employee employee) {
		employee.setDepartment(departmentId);
		employeesServices.updateEmployee(employee);
		return "Updated!";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/departments/{departmentId}/employees/{id}")
	public String deleteEmployee(@PathVariable Integer id) {
		employeesServices.deleteEmployee(id);
		return "Deleted!";
	}
}
