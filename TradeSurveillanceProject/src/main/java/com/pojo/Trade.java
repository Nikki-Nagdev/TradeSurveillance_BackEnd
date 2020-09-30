package com.pojo;

import java.util.Calendar;
import java.util.Date;


import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;



@Entity(name="trade")
public class Trade {
	

	@Id
	private int tradeId; // for the trade table
	 
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	    
	private Calendar tradeExecutionTime; // date to be filled
	
	private String brokerName;
	
	
	private int securityId;

	private int security;
	private String securityName;
	private boolean tradeType;
	
	private double marketPrice;
	private double price;
	
	private boolean isChecked;
	
	private int quantity;
	
	private int customerId;
	
	
	//@ManyToOne

	//private Customer customer;
	//int customerId=customer.getCustomerId();

	public Trade() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getTradeId() {
		return tradeId;
	}

	public void setTradeId(int tradeId) {
		this.tradeId = tradeId;
	}

	
	public Calendar getTradeExecutionTime() {
		return tradeExecutionTime;
	}

	public void setTradeExecutionTime(Calendar tradeExecutionTime) {
		this.tradeExecutionTime = tradeExecutionTime;
	}

	public String getBrokerName() {
		return brokerName;
	}

	public void setBrokerName(String brokerName) {
		this.brokerName = brokerName;
	}

	public int getSecurityId() {
		return securityId;
	}

	public void setSecurityId(int securityId) {
		this.securityId = securityId;
	}

	public int getSecurity() {
		return security;
	}

	public void setSecurity(int security) {
		this.security = security;
	}

	public String getSecurityName() {
		return securityName;
	}

	public void setSecurityName(String securityName) {
		this.securityName = securityName;
	}

	public boolean isTradeType() {
		return tradeType;
	}

	public void setTradeType(boolean tradeType) {
		this.tradeType = tradeType;
	}

	public int getMarketPrice() {
		return marketPrice;
	}

	public void setMarketPrice(int marketPrice) {
		this.marketPrice = marketPrice;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public boolean isChecked() {
		return isChecked;
	}

	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Trade(int tradeId, Calendar tradeExecutionTime, String brokerName, int securityId, int security,
			String securityName, boolean tradeType, int marketPrice, int price, boolean isChecked, int quantity,
			int customerId) {
		super();
		this.tradeId = tradeId;
		this.tradeExecutionTime = tradeExecutionTime;
		this.brokerName = brokerName;
		this.securityId = securityId;
		this.security = security;
		this.securityName = securityName;
		this.tradeType = tradeType;
		this.marketPrice = marketPrice;
		this.price = price;
		this.isChecked = isChecked;
		this.quantity = quantity;
		this.customerId = customerId;
	}

	@Override
	public String toString() {
		return "Trade [tradeId=" + tradeId + ", tradeExecutionTime=" + tradeExecutionTime + ", brokerName=" + brokerName
				+ ", securityId=" + securityId + ", security=" + security + ", securityName=" + securityName
				+ ", tradeType=" + tradeType + ", marketPrice=" + marketPrice + ", price=" + price + ", isChecked="
				+ isChecked + ", quantity=" + quantity + ", customerId=" + customerId + "]";
	}


	
	
	
	

}
