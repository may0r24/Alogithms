package com.data.main.tasks;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface TasksRepository extends CrudRepository<Task, Integer>{
	
	public List<Task> findByEmployeeId(Integer employeeId);
	
	public boolean exists(Integer employeeId);

	public Task findById(Integer taskId);
}
