package com.example.demo.service.patterns.strategy;

import org.springframework.beans.factory.InitializingBean;

import java.math.BigDecimal;

public interface DiscountCalStrategy extends InitializingBean {

    BigDecimal acceptCash(BigDecimal amount);
}
