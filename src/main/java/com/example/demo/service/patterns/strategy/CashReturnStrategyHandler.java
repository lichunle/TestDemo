package com.example.demo.service.patterns.strategy;

import com.example.demo.service.patterns.factory.CashSuper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CashReturnStrategyHandler implements DiscountCalStrategy {

    private BigDecimal returnCondition = new BigDecimal("100");
    private BigDecimal returnMoney = new BigDecimal("10");



    @Override
    public BigDecimal acceptCash(BigDecimal amount) {

        if (amount.compareTo(returnCondition) > 0) {
            return amount.subtract(returnMoney);
        }

        return amount;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        CashContextFactory.register(3, this);
    }
}
