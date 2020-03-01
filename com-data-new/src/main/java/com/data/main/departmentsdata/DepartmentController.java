package com.data.main.departmentsdata;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class DepartmentController {
	
	@Autowired
	DepartmentServices departmentServices;
	
	//show all departments
	@RequestMapping("/departments")
	public List<Department> showDepartments(){
		return departmentServices.showDepartments();
	}
	
	//find a department
	@RequestMapping("/departments/{departmentId}")
	public Department getDepartment(@PathVariable Integer departmentId) {
		return departmentServices.getDepartment(departmentId);
	}
	
	//create a department
	@RequestMapping(method=RequestMethod.POST, value="/departments")
	public String addDepartment(@RequestBody Department department) {
		departmentServices.addDepartment(department);
		return "Added!";
	}
	
	//update a department
	@RequestMapping(method=RequestMethod.PUT, value="/departments/{departmentId}")
	public String updateDepartment(@PathVariable Integer departmentId, @RequestBody Department department) {
		departmentServices.updateDepartment(department);
		return "Updated!";
	}
	
	//delete a department
	@RequestMapping(method=RequestMethod.DELETE, value="/departments/{departmentId}")
	public String deleteDepartment(@PathVariable Integer departmentId) {
		departmentServices.deleteDepartment(departmentId);
		return "Deleted!";
	}
}
