package com.pizza.entity;

public class PizzaOrderDetails {
	
	int podId ;
	int oId;
	int ppId;
	public PizzaOrderDetails(int piId, int oId, int ppId) {
		super();
		this.podId = piId;
		this.oId = oId;
		this.ppId = ppId;
	}
	public int getPiId() {
		return podId;
	}
	public void setPiId(int piId) {
		this.podId = piId;
	}
	public int getoId() {
		return oId;
	}
	public void setoId(int oId) {
		this.oId = oId;
	}
	public int getPpId() {
		return ppId;
	}
	public void setPpId(int ppId) {
		this.ppId = ppId;
	}
	@Override
	public String toString() {
		return "PizzaOrderDetails [piId=" + podId + ", oId=" + oId + ", ppId=" + ppId + "]";
	}
	
	

}
