package com.pojo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;


@Entity(name = "marketlist")
public class MarketList {

	@Id
	private int securityId;
	


	@Column

	private int security;
	private String securityName;

	private Date marketTimestamp;

	private double currentMarketPrice;

	public MarketList() {
		super();
		// TODO Auto-generated constructor stub
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

	public Date getMarketTimestamp() {
		return marketTimestamp;
	}

	public void setMarketTimestamp(Date marketTimestamp) {
		this.marketTimestamp = marketTimestamp;
	}

	public double getCurrentMarketPrice() {
		return currentMarketPrice;
	}

	public void setCurrentMarketPrice(double currentMarketPrice) {
		this.currentMarketPrice = currentMarketPrice;
	}

	public MarketList(int securityId, int security, String securityName, Date marketTimestamp,
			double currentMarketPrice) {
		super();
		this.securityId = securityId;
		this.security = security;
		this.securityName = securityName;
		this.marketTimestamp = marketTimestamp;
		this.currentMarketPrice = currentMarketPrice;
	}

	

	

}
