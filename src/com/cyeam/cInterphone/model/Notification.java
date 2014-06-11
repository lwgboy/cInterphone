package com.cyeam.cInterphone.model;

public class Notification {

	private String title = "cInterphone";
	private String description;
	
	public Notification(String description) {
		this.description = description;
	}
	
	public Notification(String title, String description) {
		this.title = title;
		this.description = description;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
