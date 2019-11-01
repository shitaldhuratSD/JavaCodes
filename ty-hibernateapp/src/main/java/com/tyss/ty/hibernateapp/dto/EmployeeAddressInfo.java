package com.tyss.ty.hibernateapp.dto;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name = "employee_address_info")
public class EmployeeAddressInfo {
	
	@EmbeddedId			// we need id and addType here use @EmbeddedId
	private EmployeeAddressPK addresspk;
	
	@MapsId
	@ManyToOne
	@JoinColumn(name="id")
	private EmployeeInfo info;
	
	@Column	
	private String address1;
	@Column	
	private String address2;
	@Column	
	private String city;
	@Column	
	private String state;
	@Column	
	private int pincode;

}
