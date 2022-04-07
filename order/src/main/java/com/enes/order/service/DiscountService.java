package com.enes.order.service;

import com.enes.order.entity.Product;
import com.enes.order.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Component
public class DiscountService implements IDiscountService {

    @Value("${user.find.url}")
    private String user_find_url;

    @Value("${product.find.url}")
    private String product_find_url;

    @Autowired
    private WebClient.Builder builder;

    @Override
    public int findUserDiscount(Long userId, Long productId){
        User user = findUser(userId);
        System.out.println(user.getEmail());
        Product product = findProduct(productId);
        System.out.println(product.getName());
        int discount = 0;

        if (!product.getCategory().equals("phone")){
            if (user.getCardType().equals("gold")) discount = 30;
            else if (user.getCardType().equals("silver")) discount = 20;
            else if (user.getAffiliate()) discount = 10;
            else if (membershipDate(user.getCreated())) discount = 5;
        }

        return discount;
    }

    private boolean membershipDate(LocalDate date){
        return ChronoUnit.YEARS.between(date, LocalDate.now()) >= 2; //if membership more than 2 years
    }

    private User findUser(Long userId){
        return builder.build()
                .get().uri(user_find_url+userId)
                .retrieve()
                .bodyToMono(User.class).block();
    }

    private Product findProduct(Long productId){
        return builder.build()
                .get().uri(product_find_url+productId)
                .retrieve()
                .bodyToMono(Product.class).block();
    }
}
