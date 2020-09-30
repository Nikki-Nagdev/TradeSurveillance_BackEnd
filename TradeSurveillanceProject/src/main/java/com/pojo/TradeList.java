package com.pojo;
import java.util.Calendar;

public class TradeList {
	//int[] apple= {101,201,301,401};  //for reference
	Calendar tradeExecutionTime;
	int quantity;
	double price;
	int customerId;
	int security;
	boolean orderType;
	public boolean isChecked;
	public Calendar getTradeExecutionTime() {
		return tradeExecutionTime;
	}
	public void setTradeExecutionTime(Calendar tradeExecutionTime) {
		this.tradeExecutionTime = tradeExecutionTime;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getSecurity() {
		return security;
	}
	public void setSecurity(int security) {
		this.security = security;
	}
	public boolean isOrderType() {
		return orderType;
	}
	public void setOrderType(boolean orderType) {
		this.orderType = orderType;
	}
	public boolean getOrderType() {
		return orderType;
	}
	public boolean isChecked() {
		return isChecked;
	}
	
	public void setChecked(boolean isChecked) {
		this.isChecked = isChecked;
	}
	public TradeList() {
		super();
		this.tradeExecutionTime = Calendar.getInstance();
		this.isChecked = false;
	}
	public TradeList(Calendar tradeExecutionTime, int quantity, double price, int customerId, int security,
			boolean orderType, boolean isChecked) {
		super();
		this.tradeExecutionTime = tradeExecutionTime;
		this.quantity = quantity;
		this.price = price;
		this.customerId = customerId;
		this.security = security;
		this.orderType = orderType;
		this.isChecked = isChecked;
	}
	@Override
	public String toString() {
		return "TradeList [tradeExecutionTime=" + tradeExecutionTime.getTime() + ", quantity=" + quantity + ", price=" + price
				+ ", customerId=" + customerId + ", security=" + security + ", orderType=" + orderType + ", isChecked="
				+ isChecked + "]";
	}
	
	
}
