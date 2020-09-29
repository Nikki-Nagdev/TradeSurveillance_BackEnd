package com.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity(name="trade")
public class Trade {
	

	@Id
	private int tradeId; // for the trade table
	private Date tradeExecutionTime; // date to be filled
	
	private String brokerName;
	
	
	private int securityId;

	private int security;
	private String securityName;
	private boolean tradeType;
	
	private int marketPrice;
	private int price;
	
	private boolean isChecked;
	
	private int quantity;
	
	
	
	
	@ManyToOne
	private Customer customer;
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

	public Date getTradeExecutionTime() {
		return tradeExecutionTime;
	}

	public void setTradeExecutionTime(Date tradeExecutionTime) {
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	
	
	
	

}
