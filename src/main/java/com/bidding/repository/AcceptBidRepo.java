package com.bidding.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.bidding.model.AcceptedBids;
@Repository
public interface AcceptBidRepo extends MongoRepository<AcceptedBids, Integer>{
	@Override
	public List<AcceptedBids>findAll();
}
