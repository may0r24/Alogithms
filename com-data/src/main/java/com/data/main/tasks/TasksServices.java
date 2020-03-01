package com.data.main.tasks;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TasksServices {
	
	@Autowired
	TasksRepository tasksRepository;
	
	public List<Task> showTasks(Integer employeeId){
		List<Task> task = new ArrayList<>();
		tasksRepository.findByEmployeeId(employeeId).forEach(task::add);
		return task;
	}

	public Task getTasks(Integer id) {
		return tasksRepository.findOne(id);
	}

	public void addTasks(Task task) {
		tasksRepository.save(task);
	}

	public void updateTasks(Task task) {
		tasksRepository.save(task);
	}

	public void deleteTasks(Integer id) {
		tasksRepository.delete(id);
	}

}
