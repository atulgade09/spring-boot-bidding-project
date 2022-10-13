package com.bidding.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.bidding.model.Bidder;

public interface BidderRepository extends MongoRepository<Bidder, Integer>{

}
