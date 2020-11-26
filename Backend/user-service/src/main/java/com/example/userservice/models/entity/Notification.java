package com.example.userservice.models.entity;

import java.util.Date;


public class Notification {
	

    private Long id;
    private Category category;
    private String title;
    private String message;
	private Date creadtedAt;
	private Date deletedAt;
    
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getCreadtedAt() {
		return creadtedAt;
	}
	public void setCreadtedAt(Date creadtedAt) {
		this.creadtedAt = creadtedAt;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

}
