package com.cydeo.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@NoArgsConstructor
@Data
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;
    private String name;
    private String email;
    private String lastName;
    private String userName;

    @OneToMany(mappedBy = "customer")
    private List<Payment> payment;

    public Customer(String address, String name, String email, String lastName, String userName) {
        this.address = address;
        this.name = name;
        this.email = email;
        this.lastName = lastName;
        this.userName = userName;
    }
}
