package com.galvanize.cryptozoology.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Animal {
	
	@Id
	@GeneratedValue
	private int id;
	private String name;
	private String type;	
	
	public Animal(int id, String name, String type) {		
		this.id = id;
		this.name = name;
		this.type = type;
	}

	public Animal() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	

}
