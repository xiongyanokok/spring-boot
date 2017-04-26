package com.xy.model;

import java.io.Serializable;

public class Order implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer orderId;
	
	private Integer userId;
	
	public Integer getOrderId() {
		return orderId;
	}
	
	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
	
	public Integer getUserId() {
		return userId;
	}
	
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
}
