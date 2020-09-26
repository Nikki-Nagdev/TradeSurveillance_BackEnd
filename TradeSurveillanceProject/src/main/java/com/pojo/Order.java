package com.pojo;

import java.util.Date;

public class Order {
	int customerId;
	String tradeType;  // Buy sell
	String securityType; // es, futures, call, put
	String securityName; // Apple Walmart Fb
	int currentMarketPrice;  
	int orderPrice;
	int quantity;
	Date orderPlacedTime;   // time of the order - to be added
	int orderId;
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getTradeType() {
		return tradeType;
	}
	public void setTradeType(String tradeType) {
		this.tradeType = tradeType;
	}
	public String getSecurityType() {
		return securityType;
	}
	public void setSecurityType(String securityType) {
		this.securityType = securityType;
	}
	public String getSecurityName() {
		return securityName;
	}
	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}
	public int getCurrentMarketPrice() {
		return currentMarketPrice;
	}
	public void setCurrentMarketPrice(int currentMarketPrice) {
		this.currentMarketPrice = currentMarketPrice;
	}
	public int getOrderPrice() {
		return orderPrice;
	}
	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public Date getOrderPlacedTime() {
		return orderPlacedTime;
	}
	public void setOrderPlacedTime(Date orderPlacedTime) {
		this.orderPlacedTime = orderPlacedTime;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Order(int customerId, String tradeType, String securityType, String securityName, int currentMarketPrice,
			int orderPrice, int quantity, Date orderPlacedTime, int orderId) {
		super();
		this.customerId = customerId;
		this.tradeType = tradeType;
		this.securityType = securityType;
		this.securityName = securityName;
		this.currentMarketPrice = currentMarketPrice;
		this.orderPrice = orderPrice;
		this.quantity = quantity;
		this.orderPlacedTime = orderPlacedTime;
		this.orderId = orderId;
	}
	
	
	
}
