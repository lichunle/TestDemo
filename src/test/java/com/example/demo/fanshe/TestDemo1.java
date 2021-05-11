package com.example.demo.fanshe;

import com.example.demo.controller.HanchengController;
import com.example.demo.service.PeoService;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @Classname TestDemo1
 * @Description TODO
 * @Date 2021/4/23 14:38
 * @Created by lichunle
 */
public class TestDemo1 {

    @Test
    public void test() throws Exception {
        HanchengController hanchengController = new HanchengController();

        System.out.println("output:{}" + hanchengController.getPeoService());

        PeoService peoService = new PeoService();
        // 创建对象
        Class<? extends HanchengController> clazz = hanchengController.getClass();
        // 获取所有的属性
        Field serviceFiled = clazz.getDeclaredField("peoService");
        serviceFiled.setAccessible(true);
        String name = serviceFiled.getName();
        System.out.println(name);

        name = name.substring(0,1).toUpperCase()+name.substring(1,name.length());
        System.out.println(name);
        String setMethodName = "set" + name;
        // 通过方法注入属性的对象
        Method method = clazz.getMethod(setMethodName, HanchengController.class);

        method.invoke(hanchengController, peoService);
        System.out.println(hanchengController.getPeoService());
    }
}
