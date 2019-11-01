package com.tyss.jpatestapp.manytomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table (name="Courses_info")
public class Courses {

	@Id
	@Column
	private int cid;
	@Column
	private String cname;
	
	@ManyToMany( cascade=CascadeType.ALL, mappedBy = "course")			//	by direction
	private List<Student> student;
	
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	
}
