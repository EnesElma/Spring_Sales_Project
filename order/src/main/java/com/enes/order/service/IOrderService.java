package com.enes.order.service;

import com.enes.order.entity.Order;

import java.util.List;

public interface IOrderService {
    Order create(Order order);

    List<Order> list();
}
