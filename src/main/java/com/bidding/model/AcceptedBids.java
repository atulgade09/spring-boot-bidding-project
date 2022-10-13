package com.bidding.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class AcceptedBids {
	BiddingData bidData;

	@Override
	public String toString() {
		return "AcceptedBids [bidData=" + bidData + "]";
	}

	public BiddingData getBidData() {
		return bidData;
	}

	public void setBidData(BiddingData bidData) {
		this.bidData = bidData;
	}
	
	
}
