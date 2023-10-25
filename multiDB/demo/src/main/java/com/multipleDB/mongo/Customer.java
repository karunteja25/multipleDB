package com.multipleDB.mongo;/*
 **@author karunteja
 **
 **/

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.UUID;

@Document(collection = "customers")
@Data
public class Customer {
    @Id
//    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Field
    private String name;
    @Field
    private String email;
    @Field
    private String phoneNo;
}
