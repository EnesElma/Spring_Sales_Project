package com.enes.product.service;

import com.enes.product.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {
    Product create(Product product);

    void delete(Long id);

    List<Product> list();

    Optional<Product> findProduct(Long id);
}
