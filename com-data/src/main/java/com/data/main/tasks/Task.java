package com.data.main.tasks;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "task")
public class Task {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "task_id")
	private Integer taskId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	//@ManyToOne
	@Column(name = "employee_id")
	private Integer employeeId;
	
	public Task() {
		
	}

	public Task(Integer taskId, String name, String description, Integer employeeId) {
		this.taskId = taskId;
		this.name = name;
		this.description = description;
		this.employeeId = employeeId;
	}

	public Integer getId() {
		return taskId;
	}

	public void setId(Integer taskId) {
		this.taskId = taskId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return description;
	}

	public void setDesc(String description) {
		this.description = description;
	}

	public Integer getEmployee() {
		return employeeId;
	}

	public void setEmployee(Integer employeeId) {
		this.employeeId = employeeId;
	}
}
