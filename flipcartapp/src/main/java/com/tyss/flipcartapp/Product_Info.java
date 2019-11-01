package com.tyss.flipcartapp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Product_Info2")
public class Product_Info {
	
	@Id
	@Column
	private int PId;
	@Column
	private String PName;
	@Column
	private int PCost;
	@Column
	private String PColor;
	@Column
	private String Description;
	
	public int getPId() {
		return PId;
	}
	public void setPId(int pId) {
		PId = pId;
	}
	public String getPName() {
		return PName;
	}
	public void setPName(String pName) {
		PName = pName;
	}
	public int getPCost() {
		return PCost;
	}
	public void setPCost(int pCost) {
		PCost = pCost;
	}
	public String getPColor() {
		return PColor;
	}
	public void setPColor(String pColor) {
		PColor = pColor;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	

}
