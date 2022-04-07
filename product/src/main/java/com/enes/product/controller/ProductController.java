package com.enes.product.controller;

import com.enes.product.entity.Product;
import com.enes.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("product")
public class ProductController {

    @Autowired
    private IProductService productService;

    @PostMapping("create")
    public ResponseEntity<?> createProduct(@RequestBody Product product){
        return ResponseEntity.ok(productService.create(product));
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id){
        productService.delete(id);
        return new ResponseEntity<>("Product delete successful", HttpStatus.ACCEPTED);
    }

    @GetMapping("listAll")
    public ResponseEntity<?> listAllProduct(){
        return ResponseEntity.ok(productService.list());
    }

    @GetMapping("find/{id}")
    public ResponseEntity<?> findUser(@PathVariable Long id){
        return ResponseEntity.ok(productService.findProduct(id));
    }
}
