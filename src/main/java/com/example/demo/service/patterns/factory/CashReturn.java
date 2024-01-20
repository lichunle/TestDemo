package com.example.demo.service.patterns.factory;

import java.math.BigDecimal;

public class CashReturn extends CashSuper {

    private BigDecimal returnCondition = new BigDecimal("100");
    private BigDecimal returnMoney = new BigDecimal("10");


    public CashReturn(BigDecimal returnCondition, BigDecimal returnMoney) {
        this.returnCondition = returnCondition;
        this.returnMoney = returnMoney;
    }

    @Override
    public BigDecimal acceptCash(BigDecimal amount) {

        if (amount.compareTo(returnCondition) > 0) {
            return amount.subtract(returnMoney);
        }

        return amount;
    }
}
