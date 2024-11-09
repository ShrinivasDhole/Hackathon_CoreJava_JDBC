package com.pizza.entity;

import java.util.Date;

public class PizzaOrders {
	int poId;
	int cId;
	Date orderTime;
	String status;
	public PizzaOrders(int poId, int cId, Date orderTime, String status) {
		super();
		this.poId = poId;
		this.cId = cId;
		this.orderTime = orderTime;
		this.status = status;
	}
	public int getPoId() {
		return poId;
	}
	public void setPoId(int poId) {
		this.poId = poId;
	}
	public int getcId() {
		return cId;
	}
	public void setcId(int cId) {
		this.cId = cId;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "PizzaOrders [poId=" + poId + ", cId=" + cId + ", orderTime=" + orderTime + ", status=" + status + "]";
	}
	
	

}
