package com.bidding.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
@Document
public class Bidder {
//	@Autowired
//	User user;
	@Id
	private int bidderId;
	private int bidAmount;
	private int workRange;
	private int bidId;
	private String email;
	private String name;
public int getBidderId() {
		return bidderId;
	}
	public void setBidderId(int bidderId) {
		this.bidderId = bidderId;
	}
	//	private String address;
//	private long contact;
	public int getBidAmount() {
		return bidAmount;
	}
	public void setBidAmount(int bidAmount) {
		this.bidAmount = bidAmount;
	}
//	@Override
//	public String toString() {
//		return "Bidder [bidAmount=" + bidAmount + ", workRange=" + workRange + ", bidId=" + bidId + ", email=" + email
//				+ ", name=" + name + ", address=" + address + ", contact=" + contact + "]";
//	}
	public int getBidId() {
		return bidId;
	}
	public void setBidId(int bidId) {
		this.bidId = bidId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	public String getAddress() {
//		return address;
//	}
//	public void setAddress(String address) {
//		this.address = address;
//	}
//	public long getContact() {
//		return contact;
//	}
//	public void setContact(long contact) {
//		this.contact = contact;
//	}
	
//	public User getUser() {
//		return user;
//	}
//	public void setUser(User user) {
//		this.user = user;
//	}
	public int getWorkRange() {
		return workRange;
	}
	public void setWorkRange(int workRange) {
		this.workRange = workRange;
	}
@Override
	public String toString() {
		return "Bidder [bidderId=" + bidderId + ", bidAmount=" + bidAmount + ", workRange=" + workRange + ", bidId="
				+ bidId + ", email=" + email + ", name=" + name + "]";
	}
	
	
	

}
