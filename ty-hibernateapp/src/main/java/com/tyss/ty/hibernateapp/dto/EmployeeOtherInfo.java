package com.tyss.ty.hibernateapp.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name = "employee_other_info")
public class EmployeeOtherInfo {
	
	@Id
	private int id;			// id is primary key for this table and foreign key for other table
	
	@MapsId				// by using @MapsId we can give Id primary key
	@OneToOne
	@JoinColumn(name="id")
	private EmployeeInfo info;
	
	@Column	
	private String password;
	@Column	
	private Date dob;
	@Column	
	private long contact_no;
	

}
