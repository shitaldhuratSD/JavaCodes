package com.tyss.ty.hibernateapp.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Id;

import lombok.Data;

@Data
@Embeddable
public class EmployeeAddressPK implements Serializable{
	
	private int id;			// composite key
	@Column	
	private String addType;

}
