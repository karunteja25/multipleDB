package com.multipleDB.controller;/*
 **@author karunteja
 **
 **/

import com.multipleDB.dto.ProductDTO;
import com.multipleDB.postgres.Product;
import com.multipleDB.repository.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductRepo productRepo;

    @PostMapping("/save")
    public Product save(@RequestBody ProductDTO productDTO){
        Product product=new Product();
        product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setIsAvailable(productDTO.getIsAvailable());
        return productRepo.save(product);
    }
    @GetMapping("/find-all")
    public List<Product> findAll(){
        return productRepo.findAll();
    }
}
