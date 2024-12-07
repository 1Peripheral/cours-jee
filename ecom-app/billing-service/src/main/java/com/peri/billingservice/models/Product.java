package com.peri.billingservice.models;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private String name;
    private Double price;
    private int quantity;

}
