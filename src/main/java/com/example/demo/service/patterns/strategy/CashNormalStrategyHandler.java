package com.example.demo.service.patterns.strategy;

import com.example.demo.service.patterns.factory.CashSuper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class CashNormalStrategyHandler implements DiscountCalStrategy {

    @Override
    public BigDecimal acceptCash(BigDecimal amount) {
        return amount;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        CashContextFactory.register(1, this);
    }
}
