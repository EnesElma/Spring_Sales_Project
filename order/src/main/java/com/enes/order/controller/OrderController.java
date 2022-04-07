package com.enes.order.controller;

import com.enes.order.entity.Order;
import com.enes.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("order")
public class OrderController {

    @Autowired
    private IOrderService orderService;

    @PostMapping("create")
    public ResponseEntity<?> createOrder(@RequestBody Order order){
        return ResponseEntity.ok(orderService.create(order));
    }

    @GetMapping("listAll")
    public ResponseEntity<?> listAllOrder(){
        return ResponseEntity.ok(orderService.list());
    }
}
