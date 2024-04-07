package com.cydeo.loosely;

import java.math.BigDecimal;

public class BalanceService {

    public boolean checkout(Balance balance, BigDecimal checkoutAmount){

        BigDecimal balanceAmount = balance.getAmount();

        //if we have enough money to checkout, proceed and return true, if not return false
        if (balanceAmount.subtract(checkoutAmount).compareTo(BigDecimal.ZERO) >=0){
            balance.setAmount(balanceAmount.subtract(checkoutAmount));
            return true;
        }

        return false;
    }

}
