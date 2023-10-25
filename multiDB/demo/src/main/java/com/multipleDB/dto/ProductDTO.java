package com.multipleDB.dto;/*
 **@author karunteja
 **
 **/

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
public class ProductDTO {

    private UUID id;
    private String name;
    private Double price;
    private Boolean isAvailable;
}
