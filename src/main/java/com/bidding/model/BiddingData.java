package com.bidding.model;


//import java.sql.Date;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

@Document
public class BiddingData {
	@Id
	private int bidId;
//	@Autowired
//	private Owner owner;
	private String email;
	private String name;
	private String password;
	private String address;
	private long contact;
	private int bidCost;
	private String status;
	
	
public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

public int getBidCost() {
		return bidCost;
	}

	public void setBidCost(int bidCost) {
		this.bidCost = bidCost;
	}

	//	@Autowired
//	@DateTimeFormat(iso = ISO.DATE_TIME)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date createdDate ;
	private String description;
//	@Autowired
//	@DateTimeFormat(iso = ISO.DATE_TIME)
	@DateTimeFormat(pattern = "yyyy-mm-dd")
	private Date closeDate;
	
	
	
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	private List<Bidder> bidder;
	
	
	public int getBidId() {
		return bidId;
	}
	
//	public Owner getOwner() {
//		return owner;
//	}
//
//	public void setOwner(Owner owner) {
//		this.owner = owner;
//	}

	public void setBidId(int bidId) {
		this.bidId = bidId;
	}

	public List<Bidder> getBidder() {
		return bidder;
	}
	public void setBidder(List<Bidder> bidder) {
		this.bidder = bidder;
	}

	@Override
	public String toString() {
		return "BiddingData [bidId=" + bidId + ", email=" + email + ", name=" + name + ", password=" + password
				+ ", address=" + address + ", contact=" + contact + ", bidCost=" + bidCost + ", status=" + status
				+ ", createdDate=" + createdDate + ", description=" + description + ", closeDate=" + closeDate
				+ ", bidder=" + bidder + "]";
	}

//	@Override
//	public String toString() {
//		return "BiddingData [bidId=" + bidId + ", email=" + email + ", name=" + name + ", password=" + password
//				+ ", address=" + address + ", contact=" + contact + ", bidder=" + bidder + "]";
//	}

	
	
	
	
	
}
