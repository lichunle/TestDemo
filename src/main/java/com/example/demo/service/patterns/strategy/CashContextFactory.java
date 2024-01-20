package com.example.demo.service.patterns.strategy;

import java.util.HashMap;
import java.util.Map;

public class CashContextFactory {

    private static Map<Integer, DiscountCalStrategy> strategyMap = new HashMap<>();

    public static DiscountCalStrategy getStrategy(Integer type) {
        return strategyMap.get(type);
    }

    public static void register(Integer type, DiscountCalStrategy strategy) {
        strategyMap.put(type, strategy);
    }
}
