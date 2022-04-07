package com.enes.product.entity;

import lombok.Data;

import javax.persistence.*;

@Entity(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,unique = true)
    private String name;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private int stock;

    public void setStock(int stock) {
        this.stock = Math.max(stock, 0);
    }
}
