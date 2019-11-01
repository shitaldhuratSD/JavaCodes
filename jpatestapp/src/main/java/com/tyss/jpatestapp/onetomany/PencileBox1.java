package com.tyss.jpatestapp.onetomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.tyss.jpatestapp.onetoone.Pencile;

@Entity
@Table (name="PencilBox1")
public class PencileBox1 {
	
	@Id
	@Column
	private int pid;
	@Column
	private String pname;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="pid",nullable=false)
	List<Pencile1> pencil1;
	
	
	public List<Pencile1> getPencil1() {
		return pencil1;
	}
	public void setPencil1(List<Pencile1> pencil1) {
		this.pencil1 = pencil1;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	

}
