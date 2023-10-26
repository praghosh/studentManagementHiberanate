package com.example.studentManagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="EMPL")
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "empID")
	private Integer id;
	
	
	@Column(name = "Salary")
		private Integer salary;
	
	public Integer getId() {
		return id;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name = "empName")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	private String name;

}
