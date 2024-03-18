package com.cydeo.tightlyCoupled;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DellCase {

    private String model;
    private String manufacturer;
    private String powerSupply;

    public void pressPowerButton() {
        System.out.println("Power button pressed");
    }

}
