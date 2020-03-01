package com.data.main.tasks;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class TasksController {

	@Autowired
	private TasksServices tasksServices;
	
	@RequestMapping("employees/{employeeId}/tasks")
	public List<Task> showTasks(@PathVariable Integer employeeId){
		return tasksServices.showTasks(employeeId);
	}
	@RequestMapping("employees/{employeeId}/tasks/{id}")
	public Task getTasks(@PathVariable Integer id) {
		return tasksServices.getTasks(id);
	}
	@RequestMapping(method=RequestMethod.POST, value="employees/{employeeId}/tasks")
	public String addTasks(@RequestBody Task task, @PathVariable Integer employeeId) {
		task.setEmployee(employeeId);
		tasksServices.addTasks(task);
		return "Added!";
	}
	@RequestMapping(method=RequestMethod.PUT, value="employees/{employeeId}/tasks/{id}")
	public String updateTasks(@RequestBody Task task, @PathVariable Integer employeeId) {
		task.setEmployee(employeeId);
		tasksServices.updateTasks(task);
		return "Updated!";
	}
	@RequestMapping(method=RequestMethod.DELETE, value="employees/{employeeId}/tasks/{id}")
	public String deleteTasks(@PathVariable Integer id) {
		tasksServices.deleteTasks(id);
		return "Deleted!";
	}
}
