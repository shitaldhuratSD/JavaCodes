package com.tyss.jpatestapp.onetoone;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="PencilBox")
public class PencileBox {

	@Id
	@Column
	private int pid;
	@Column
	private String pname;
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinColumn(name="pid",nullable=false)
	List<Pencile> pencil;
	
	public List<Pencile> getPencil() {
		return pencil;
	}
	public void setPencil(List<Pencile> pencil) {
		this.pencil = pencil;
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
