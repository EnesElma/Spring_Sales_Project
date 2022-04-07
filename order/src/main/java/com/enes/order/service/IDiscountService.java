package com.enes.order.service;

import com.enes.order.entity.Product;

public interface IDiscountService {
    int findUserDiscount(Long userId, Long productId);
}
