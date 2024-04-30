package com.cydeo.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@MappedSuperclass //do not need to create table from this account class, this class's purpose is for inheritance
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String owner;
    private BigDecimal balance;
    private BigDecimal interestRate;

}
