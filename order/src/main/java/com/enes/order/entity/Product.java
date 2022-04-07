package com.enes.order.entity;

import lombok.Data;

@Data
public class Product {
    private Long id;
    private String name;
    private String category;
    private int stock;
}
