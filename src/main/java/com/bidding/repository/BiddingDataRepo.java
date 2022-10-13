package com.bidding.repository;



import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Repository;

import com.bidding.model.BiddingData;
@Repository
public interface BiddingDataRepo extends MongoRepository<BiddingData, Integer>{
	
	@Override
	public List<BiddingData>findAll();
}
