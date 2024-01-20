package com.example.demo.design.patterns;

import com.example.demo.DemoApplication;
import com.example.demo.service.patterns.strategy.CashContextFactory;
import com.example.demo.service.patterns.strategy.DiscountCalStrategy;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoApplication.class})
public class StrategyTest {

    @Test
    public void test() {

        BigDecimal amount = new BigDecimal("1000");
        DiscountCalStrategy strategy1 = CashContextFactory.getStrategy(1);
        amount = strategy1.acceptCash(amount);
        System.out.println("strategy1: " + amount);
        log.info("strategy1:{}", amount);

        DiscountCalStrategy strategy2 = CashContextFactory.getStrategy(2);
        amount = strategy2.acceptCash(amount);
        System.out.println("strategy2: " + amount);
        log.info("strategy2:{}", amount);

    }
}
