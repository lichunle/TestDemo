package com.example.demo.service.patterns.strategy;

import com.example.demo.service.patterns.factory.CashSuper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CashRebateStrategyHandler implements DiscountCalStrategy {

    private BigDecimal moneyRebate = new BigDecimal("0.1");


    @Override
    public BigDecimal acceptCash(BigDecimal amount) {

        return amount.multiply(moneyRebate);
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        CashContextFactory.register(2, this);
    }
}
