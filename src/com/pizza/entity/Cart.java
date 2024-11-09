package com.pizza.entity;


public class Cart {

	String name;
	int ppId;
	int itemId;
	String size;
	double price;
	public Cart(String name ,int ppId, int itemId, String size, double price) {
		super();
		this.name = name;
		this.ppId = ppId;
		this.itemId = itemId;
		this.size = size;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPpId() {
		return ppId;
	}
	public void setPpId(int ppId) {
		this.ppId = ppId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Cart [name=" + name + ", ppId=" + ppId + ", itemId=" + itemId + ", size=" + size + ", price=" + price
				+ "]";
	}
	
	
	
	
	
	
}
