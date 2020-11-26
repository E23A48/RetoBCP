package com.example.userservice.models.entity;

import java.util.Date;

public class Category {
	

    private Long id;
	private String Name;
	private Date creadtedAt;
	
	public String getName() {
		return Name;
	}
	
	public void setName(String name) {
		Name = name;
	}
	public Date getCreadtedAt() {
		return creadtedAt;
	}
	public void setCreadtedAt(Date creadtedAt) {
		this.creadtedAt = creadtedAt;
	}

}
