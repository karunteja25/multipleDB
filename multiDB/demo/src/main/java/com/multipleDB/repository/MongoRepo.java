package com.multipleDB.repository;/*
 **@author karunteja
 **
 **/

import com.multipleDB.mongo.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MongoRepo extends MongoRepository<Customer, String> {
}
