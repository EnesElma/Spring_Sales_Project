package com.enes.order.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class User {

    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String cardType;
    private Boolean affiliate;
    private LocalDate created;
}
