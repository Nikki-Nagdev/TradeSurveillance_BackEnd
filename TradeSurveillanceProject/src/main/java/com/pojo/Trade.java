package com.pojo;

import java.util.Date;

public class Trade {
	int tradeId; // for the trade table
	Date tradeExecutionTime;				// date to be filled
	int orderId;     // Order object to be created at the time of implementation
	String brokerName;
	public int getTradeId() {
		return tradeId;
	}
	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}
	public Date getTradeExecutionTime() {
		return tradeExecutionTime;
	}
	public void setTradeExecutionTime(Date tradeExecutionTime) {
		this.tradeExecutionTime = tradeExecutionTime;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public String getBrokerName() {
		return brokerName;
	}
	public void setBrokerName(String brokerName) {
		this.brokerName = brokerName;
	}
	
	
	
//int customerId;
	
//	String tradeType; // alternate enum Type{}
//	String securityType; 
//	String securityName;
//	int quantity;
//	String brokerName;  // broker name
//	int clientId; // for the customer table
//	
}
