package com.cydeo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class UserAccount extends BaseEntity{

    @OneToOne(fetch = FetchType.LAZY)
    private AccountDetails accountDetails;

    private String email;
    private String username;
    private String password;

}
