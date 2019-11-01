
package com.tyss.jpatestapp.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "Movie")

public class Movie {		//Pojo class
	
	@Id
	@Column	
private int id;
	@Column
private  String name;
	@Column
private  String rating;

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
public String getRating() {
	return rating;
}
public void setRating(String rating) {
	this.rating = rating;
}



}
