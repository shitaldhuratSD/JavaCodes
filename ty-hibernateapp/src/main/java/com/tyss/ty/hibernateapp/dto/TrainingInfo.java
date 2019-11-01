package com.tyss.ty.hibernateapp.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name = "training_info")
public class TrainingInfo {
	
	@Id
	@Column(name="course_id")
	private int courseId;
	@Column(name="course_name")
	private String courseName;
	
	@ManyToMany
	@JoinTable(name="employee_training_info",joinColumns=@JoinColumn(name="course_id"),inverseJoinColumns=@JoinColumn(name="id"))
													// inverseJoinColumns for use id from another table
	
	
	private List<EmployeeInfo> info;

}
