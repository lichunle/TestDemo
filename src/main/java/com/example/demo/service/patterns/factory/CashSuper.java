package com.example.demo.service.patterns.factory;

import java.math.BigDecimal;

/**
 * 现金收费抽象类
 *
 */
public abstract class CashSuper {

    public abstract BigDecimal acceptCash(BigDecimal amount);
}
