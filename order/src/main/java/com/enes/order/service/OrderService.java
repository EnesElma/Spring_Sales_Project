package com.enes.order.service;

import com.enes.order.entity.Order;
import com.enes.order.entity.Product;
import com.enes.order.exception.CustomException;
import com.enes.order.repo.IOrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Service
public class OrderService implements IOrderService{

    @Autowired
    private IOrderRepository orderRepository;

    @Autowired
    private IDiscountService discountService;

    @Autowired
    private WebClient.Builder builder;


    @Override
    public Order create(Order order){
        if (findProduct(order.getProductId()).getStock()<=0) throw new CustomException("Not enough stock");

        int discountPercentage = discountService.findUserDiscount(order.getUserId(),order.getProductId());
        int discountBill =  ((int)(order.getGrandTotal()/200)*5);

        double total = order.getGrandTotal()*(100-discountPercentage)/100;
        total = total - discountBill;
        order.setGrandTotal(total);

        return orderRepository.save(order);
    }

    @Override
    public List<Order> list(){
        return orderRepository.findAll();
    }

    private Product findProduct(Long productId){
        return builder.build()
                .get().uri("localhost:8081/product/find/"+productId)
                .retrieve()
                .bodyToMono(Product.class).block();
    }
}
