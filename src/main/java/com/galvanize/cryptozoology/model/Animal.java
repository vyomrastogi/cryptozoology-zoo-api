package com.galvanize.cryptozoology.model;

import java.util.UUID;

public class Animal {
	private String id;
	private String name;
	private String type;

	public Animal( String name, String type) {
		this.id = UUID.randomUUID().toString();
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	

}
