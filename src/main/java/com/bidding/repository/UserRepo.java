package com.bidding.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bidding.model.User;
@Repository
public interface UserRepo extends MongoRepository<User, String>{
	@Override
	List<User> findAll();	

}
