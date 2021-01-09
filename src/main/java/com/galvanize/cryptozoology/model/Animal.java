package com.galvanize.cryptozoology.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
public class Animal {
	
	@Id
	@GeneratedValue
	private Integer id;
	private String name;
	private String type;
	@JsonProperty("isHappy")
	private boolean isHappy;
	
	public Animal(Integer id, String name, String type) {		
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public boolean isHappy() {
		return isHappy;
	}

	public void setHappy(boolean isHappy) {
		this.isHappy = isHappy;
	}
	
	

}
