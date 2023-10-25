package com.multipleDB.controller;/*
 **@author karunteja
 **
 **/

import com.multipleDB.dto.CustomerDTO;
import com.multipleDB.mongo.Customer;
import com.multipleDB.repository.MongoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private MongoRepo mongoRepo;

    @PostMapping("/save")
    public Customer save(@RequestBody CustomerDTO user){
        Customer customer=new Customer();
        customer.setEmail(user.getEmail());
        customer.setName(user.getEmail());
        customer.setPhoneNo(user.getPhoneNo());
        return mongoRepo.save(customer);
    }
    @GetMapping("/find-all")
    public List<Customer> getAll(){
        return mongoRepo.findAll();
    }
}
