package com.example.demo.service.patterns.factory;

import java.math.BigDecimal;

public class CashNormal extends CashSuper {

    @Override
    public BigDecimal acceptCash(BigDecimal amount) {
        return amount;
    }
}
