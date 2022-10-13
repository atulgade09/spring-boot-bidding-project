package com.bidding.service;

import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.bidding.model.AcceptedBids;
import com.bidding.model.Bidder;
import com.bidding.model.BiddingData;
import com.bidding.model.Owner;
import com.bidding.model.User;
import com.bidding.repository.AcceptBidRepo;
import com.bidding.repository.BidderRepository;
import com.bidding.repository.BiddingDataRepo;
import com.bidding.repository.UserRepo;
import com.bidding.serviceInterface.BiddingServiceInterface;

@Service
public class BiddingService implements BiddingServiceInterface {

	@Autowired
	UserRepo userRepo;
	@Autowired
	BiddingDataRepo bidRepo;
	@Autowired
	BidderRepository bidderRepo;
	static User getUser;
	@Autowired
	AcceptBidRepo acceptRepo;
	@Override
	public User saveUser(User user) {
		return userRepo.insert(user);

	}

	@Override
	public List<User> getUserData() {
		return userRepo.findAll();
	}

	@Override
	public List<BiddingData> getBiddingData() {
		return bidRepo.findAll();
	}

	@Override
	public User updateUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BiddingData updateBiddingData(BiddingData biddingData) {

		return biddingData;
	}

	@Override
	public User deleteUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BiddingData deleteBiddingDataById(int id) {
		BiddingData biddingData = bidRepo.findById(id).get();
		bidRepo.deleteById(id);
		return biddingData;
	}

	@Override
	public User getUserByEmail(String email) {
		getUser = userRepo.findById(email).get();
		return getUser;
	}

	public boolean verifiedUser(User user, String email, String password) {
		if (user.getEmail().equals(email) && user.getPassword().equals(password))
			return true;
		else
			return false;
	}

	@Override
	public BiddingData saveOwnerBid(BiddingData biddingData) {

		System.out.println("Hello" + biddingData);
		// bidRepo.save(biddingData);

		return bidRepo.insert(biddingData);

		// return bidRepo.save(biddingData);
	}

	public Owner createOwnerData(Owner owner) {
		BiddingData bidData = createBiddingDataId();

		System.out.println(owner.getCreatedDate());

		System.out.println(getUser);
		bidData.setName(getUser.getName());
		bidData.setEmail(getUser.getEmail());
		bidData.setAddress(getUser.getAddress());
		bidData.setContact(getUser.getContact());
		bidData.setBidCost(owner.getBidCost());
		bidData.setStatus("active");
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
//		String date=simpleDateFormat.format(owner.getCreatedDate());
//		System.out.println("This is Formatted Date :"+ date);
		bidData.setCreatedDate(owner.getCreatedDate());
		bidData.setCloseDate(owner.getCloseDate());
		bidData.setDescription(owner.getDescription());
//		simpleDateFormat.

//		bidData.setCreatedDate(new Date().from(owner.getCreatedDate()));

		saveOwnerBid(bidData);
		return owner;
	}

	public BiddingData createBiddingDataId() {
		System.out.println("inside bid Creat ID");
		List<BiddingData> bidData = bidRepo.findAll();
		int bidId = 0;
		BiddingData b = null;
		if (bidData.isEmpty()) {
			bidId = 1;
		} else
		{
//			bidId = bidData.get(bidData.size() - 1).getBidId() + 1;
			for (BiddingData bd:bidData) {
				if(bd.getBidId()>bidId) {
					bidId=bd.getBidId();
				}
			}
		}
		bidId=bidId+1;
		b = new BiddingData();
		b.setBidId(bidId);
		return b;
	}

	@Override
	public BiddingData getBiddingDataById(int id) {
		return bidRepo.findById(id).get();
	}

	public BiddingData editBiddingData(BiddingData biddingData) {
		return bidRepo.insert(biddingData);
	}
	
	public Bidder insertBidderData(Bidder bidder) {
		System.out.println("at the end point of insertion");
		return bidderRepo.insert(bidder);
	}
	public List<Bidder> getBidderList(){
		return bidderRepo.findAll();
	}
	public Bidder getBidderById(int id) {
		return bidderRepo.findById(id).get();
	}
	public int BidderIdGenerator() {
		List<Bidder>list=bidderRepo.findAll();
		if(list.isEmpty()) return 0;
		else return list.get(list.size()-1).getBidderId()+1;
	}
	
	public List<Bidder> bidderListByBiddingId(int id){
		try {
			if(bidRepo.findById(id).get().getBidder()==null) {
				System.out.println("Creating new ArrayList");
				return new ArrayList<Bidder>();
			}else {
				System.out.println(bidRepo.findById(id).get().getBidder());
				return bidRepo.findById(id).get().getBidder();
			}
		} catch (Exception e) {
//			return new ArrayList<Bidder>();
			return bidRepo.findById(id).get().getBidder();
		}
	
	}
	
	public AcceptedBids acceptBid(AcceptedBids acceptedBids) {
		return acceptRepo.insert(acceptedBids);	
	}
	public List<AcceptedBids> acceptedList(){
		return acceptRepo.findAll();
	}
	
}
