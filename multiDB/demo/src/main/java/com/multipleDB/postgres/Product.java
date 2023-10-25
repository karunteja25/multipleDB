package com.multipleDB.postgres;/*
 **@author karunteja
 **
 **/

import jakarta.persistence.*;
import lombok.Data;

import java.util.UUID;

@Entity
@Table(name = "product" , schema = "public")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Double price;
    @Column(name = "is_available")
    private Boolean isAvailable;
}
