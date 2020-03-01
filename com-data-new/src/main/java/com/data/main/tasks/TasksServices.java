package com.data.main.tasks;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.data.main.ResourceNotFoundException;
import com.data.main.employeesdata.EmployeesRepository;

@Service
public class TasksServices {
	
	@Autowired
	TasksRepository tasksRepository;
	
	@Autowired
	EmployeesRepository employeesRepository;
	
	public List<Task> showTasks(Integer employeeId){
		List<Task> task = new ArrayList<>();
		tasksRepository.findByEmployeeId(employeeId).forEach(task::add);
		return task;
	}

	public Task getTasks(Integer taskId) {
		return tasksRepository.findOne(taskId);
	}

	public void addTasks(Task task) {
		tasksRepository.save(task);
	}

	public Task updateTasks(Task taskRequest, Integer employeeId, Integer id) {
		if(!employeesRepository.exists(employeeId)){
			throw new ResourceNotFoundException("employeeId " + employeeId + " Not Found");
		}
		Task task = tasksRepository.findById(id);
		if(task == null) {
			throw new ResourceNotFoundException("taskId" + id + "Not Found");
		}
			task.setName(taskRequest.getName());
			task.setDescription(taskRequest.getDescription());
			return tasksRepository.save(task);
	}

	public ResponseEntity<?> deleteTasks(Integer employeeId, Integer id) {
		if(!tasksRepository.exists(employeeId)) {
			throw new ResourceNotFoundException("employeeId" + employeeId + "Not Found");
		}
		if(!tasksRepository.exists(id)) {
			throw new ResourceNotFoundException("taskId " + id + " Not Found");
		}
		Task task = tasksRepository.findOne(id);
		tasksRepository.delete(task);
		return ResponseEntity.ok().build();
	}

	public Iterable<Task> showAllTasks() {
		return tasksRepository.findAll();
	}

}
