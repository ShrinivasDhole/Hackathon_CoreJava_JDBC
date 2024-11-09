package com.pizza.entity;

public class Pizza_Items {
	
	private int piId;
	private String name;
	private String type;
	private String category;
	private String description;
	public Pizza_Items(int id, String name, String type, String category, String description) {
		super();
		this.piId = id;
		this.name = name;
		this.type = type;
		this.category = category;
		this.description = description;
	}
	@Override
	public String toString() {
		return "Pizza_Items [id=" + piId + ", name=" + name + ", type=" + type + ", category=" + category
				+ ", description=" + description + "]";
	}
	public int getId() {
		return piId;
	}
	public void setId(int id) {
		this.piId = id;
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
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	

}
