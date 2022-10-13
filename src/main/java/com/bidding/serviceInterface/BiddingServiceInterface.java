package com.bidding.serviceInterface;

import java.util.List;

import com.bidding.model.BiddingData;
import com.bidding.model.Owner;
import com.bidding.model.User;

public interface BiddingServiceInterface {

	public User saveUser(User user);
	public BiddingData saveOwnerBid(BiddingData biddingData);
	
	public List<User> getUserData();
	public List<BiddingData> getBiddingData();
	
	public User updateUser(User user);
	public BiddingData updateBiddingData(BiddingData biddingData);
	
	
	public User deleteUser(User user);
	public BiddingData deleteBiddingDataById(int id);
	
	public User getUserByEmail(String email);
	public BiddingData getBiddingDataById(int Id);
}
