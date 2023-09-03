package com.example.demo.design;

import com.example.demo.DemoApplication;
import com.example.demo.service.AbstractTaskFinishHandler;
import com.example.demo.service.ITaskFinishStrategy;
import com.example.demo.service.WardHandlerFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoApplication.class})
public class StrategyTestDemo {

    @Test
    public void test() {
//        String name = "Haibei";
//        AbstractTaskFinishHandler haibeiHandler = WardHandlerFactory.getInvokeStrategy(name);
//        haibeiHandler.doWard(name);
//        haibeiHandler.desc(name);

        String name = "taskChance";
        System.out.println(Objects.nonNull(name));
//        AbstractTaskFinishHandler taskChanceHandler = WardHandlerFactory.getInvokeStrategy(name);
//        taskChanceHandler.desc(name);
    }
}
