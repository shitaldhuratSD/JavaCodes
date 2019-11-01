package com.tyss.jpatestapp.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity

public class Person {

	@Id
	@Column	
	private int id;
	@Column	
	private String name;
	@Column	
	private int age;
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="v_id")
	
	private VoterCard voterCard;
	
	
	
	public VoterCard getVoterCard() {
		return voterCard;
	}
	public void setVoterCard(VoterCard voterCard) {
		this.voterCard = voterCard;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	
}
