package com.bidding.model;

import java.sql.Date;

//import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

public class Owner {

	
//	@Autowired
//	User user;
//	@Autowired
//	@DateTimeFormat(iso = ISO.DATE_TIME)
//	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date createdDate ;
	private String description;
	private int bidCost;
public int getBidCost() {
		return bidCost;
	}
	public void setBidCost(int bidCost) {
		this.bidCost = bidCost;
	}
	//	@Autowired
//	@DateTimeFormat(iso = ISO.DATE_TIME)
//	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date closeDate;
	
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCloseDate() {
		return closeDate;
	}
	public void setCloseDate(Date closeDate) {
		this.closeDate = closeDate;
	}
	@Override
	public String toString() {
		return "Owner [createdDate=" + createdDate + ", description=" + description + ", bidCost=" + bidCost
				+ ", closeDate=" + closeDate + "]";
	}
	
	

}
