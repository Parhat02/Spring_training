package com.cydeo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class UserAccount extends BaseEntity{

    @OneToOne
    private AccountDetails accountDetails;

    private String email;
    private String userName;
    private String password;

}
