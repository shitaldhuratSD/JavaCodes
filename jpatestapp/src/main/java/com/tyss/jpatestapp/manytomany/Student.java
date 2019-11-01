package com.tyss.jpatestapp.manytomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table 
public class Student {

	@Id
	@Column
	private int sid;
	@Column
	private String sname;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="student_courses", joinColumns = @JoinColumn(name ="sid"),
	inverseJoinColumns = @JoinColumn(name= "cid"))
	private List<Courses> courses;
	
	
	public List<Courses> getCourses() {
		return courses;
	}
	public void setCourses(List<Courses> courses) {
		this.courses = courses;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	
	
}
