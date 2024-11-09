package com.pizza.entity;

public class PizzaPricing {

	int ppId;
	int itemId;
	String size;
	double price;
	public PizzaPricing(int ppId, int itemId, String size, double price) {
		super();
		this.ppId = ppId;
		this.itemId = itemId;
		this.size = size;
		this.price = price;
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
		return "PizzaPricing [ppId=" + ppId + ", itemId=" + itemId + ", size=" + size + ", price=" + price + "]";
	}
	
	
	
	
}
