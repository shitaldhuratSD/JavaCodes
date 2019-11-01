package com.tyss.ty.hibernateapp.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table (name = "employee_info")
public class EmployeeInfo {			// pojo class plane java object

	@Id
	@Column	
	private int id;
	@Column	
	private String name;
	@Column	
	private String email;
	@Column	
	private String gender;
	
	@OneToOne(mappedBy="info", cascade=CascadeType.ALL)
	private EmployeeOtherInfo otherinfo;
	
	@OneToMany(mappedBy="info",cascade=CascadeType.ALL)
	private List<EmployeeAddressInfo> addressinfo;
	
	@ManyToMany(mappedBy="info",cascade=CascadeType.ALL)
	private  List<TrainingInfo>trininginfo;
	
	private List<EmployeeInfo> list;
	
}
