package com.pizza.entity;

public class Pizza_Customers {
	
	int cId;
	String name;
	String password;
	String mobile;
	String address;
	String email;
	public Pizza_Customers(int cId, String name, String password, String mobile, String address, String email) {
		super();
		this.cId = cId;
		this.name = name;
		this.password = password;
		this.mobile = mobile;
		this.address = address;
		this.email = email;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Pizza_Customers [cId=" + cId + ", name=" + name + ", password=" + password + ", mobile=" + mobile
				+ ", address=" + address + ", email=" + email + "]";
	}
	
	

}
