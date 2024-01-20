package com.example.demo.service.patterns.factory;

import java.math.BigDecimal;

public class CashRebate extends CashSuper {

    private BigDecimal moneyRebate = new BigDecimal("0.1");

    public CashRebate(BigDecimal moneyRebate) {
        this.moneyRebate = moneyRebate;
    }

    @Override
    public BigDecimal acceptCash(BigDecimal amount) {

        return amount.multiply(moneyRebate);
    }
}
