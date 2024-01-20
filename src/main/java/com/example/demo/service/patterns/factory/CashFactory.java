package com.example.demo.service.patterns.factory;

import java.math.BigDecimal;

public class CashFactory {

    public static CashSuper createCashAccept(Integer type) {

        CashSuper cs = null;

        switch (type) {
            case 1 :
                cs = new CashNormal();
                break;
            case 2:
                cs = new CashRebate(new BigDecimal("0.9"));
                break;
            case 3:
                cs = new CashReturn(new BigDecimal("300"), new BigDecimal("100"));
                break;
        }

        return cs;
    }
}
