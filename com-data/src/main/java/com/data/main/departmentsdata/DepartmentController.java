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
	
	@RequestMapping("/departments")
	public List<Department> showDepartments(){
		return departmentServices.showDepartments();
	}
	
	@RequestMapping("/departments/{id}")
	public Department getDepartment(@PathVariable Integer id) {
		return departmentServices.getDepartment(id);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/departments")
	public String addDepartment(@RequestBody Department employee) {
		departmentServices.addDepartment(employee);
		return "Added!";
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/departments/{id}")
	public String updateDepartment(@PathVariable String id, @RequestBody Department employee) {
		departmentServices.updateDepartment(employee);
		return "Updated!";
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/departments/{id}")
	public String deleteDepartment(@PathVariable Integer id) {
		departmentServices.deleteDepartment(id);
		return "Deleted!";
	}
}
