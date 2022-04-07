package com.enes.product.service;

import com.enes.product.entity.Product;
import com.enes.product.repo.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;

    @Override
    public Product create(Product product){
        return productRepository.save(product);
    }

    @Override
    public void delete(Long id){
        productRepository.deleteById(id);
    }

    @Override
    public List<Product> list(){
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findProduct(Long id){
        return productRepository.findById(id);
    }
}
