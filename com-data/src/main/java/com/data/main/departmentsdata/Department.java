package com.data.main.departmentsdata;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import javax.persistence.Column;

@Entity
@Table(name = "department")
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "department_id")
	private Integer departmentId;
	
	@Column(name = "name")
	private String name;
	
	public Department() {
		
	}

	public Department(Integer departmentId, String name) {
		
		this.departmentId = departmentId;
		this.name = name;
	}

	public Integer getId() {
		return departmentId;
	}

	public void setId(Integer departmentId) {
		this.departmentId = departmentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
}
