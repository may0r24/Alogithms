package com.data.main.tasks;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.data.main.employeesdata.Employee;


@RestController
public class TasksController {

	@Autowired
	private TasksServices tasksServices;
	
	//show all tasks based on employee
	@RequestMapping("/employees/{employeeId}/tasks")
	public List<Task> showTasks(@PathVariable Integer employeeId){
		return tasksServices.showTasks(employeeId);
	}
	//show all tasks
	@GetMapping("/tasks")
	public Iterable<Task> showAllTasks(){
		return tasksServices.showAllTasks();
	}
	
	//find a task based on employee
	@RequestMapping("/employees/{employeeId}/tasks/{id}")
	public Task getTasks(@PathVariable Integer id) {
		return tasksServices.getTasks(id);
	}
	
	//create a task
	@RequestMapping(method=RequestMethod.POST, value="/employees/{employeeId}/tasks")
	public String addTasks(@RequestBody Task task, @PathVariable Integer employeeId) {
		task.setEmployee(new Employee(employeeId, "", "", "", null));
		tasksServices.addTasks(task);
		return "Added!";
	}
	
	//update a task
	@RequestMapping(method=RequestMethod.PUT, value="employees/{employeeId}/tasks/{id}")
	public Task updateTasks(@Valid @RequestBody Task taskRequest, @PathVariable Integer employeeId, @PathVariable Integer id) {
		taskRequest.setEmployee(new Employee(employeeId, "", "", "", null));
		System.out.println(employeeId);
		return tasksServices.updateTasks(taskRequest, employeeId, id);
		
	}
	
	//delete a task
	@RequestMapping(method=RequestMethod.DELETE, value="/employees/{employeeId}/tasks/{id}")
	public ResponseEntity<?> deleteTasks(@PathVariable Integer employeeId, @PathVariable Integer taskId) {
		return tasksServices.deleteTasks(employeeId, taskId);
		
	}
}
