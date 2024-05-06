package com.cydeo.entity;

import com.cydeo.enums.UserRole;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class AccountDetails extends BaseEntity{

    private String name;
    private String address;
    private String country;
    private String city;
    private String state;
    private String postalCode;
    private Integer age;

    @Enumerated(EnumType.STRING)
    private UserRole userRole;

}
