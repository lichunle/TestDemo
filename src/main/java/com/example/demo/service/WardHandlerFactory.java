package com.example.demo.service;

import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class WardHandlerFactory {

    private static Map<String, AbstractTaskFinishHandler> map = new HashMap<>();

    public static AbstractTaskFinishHandler getInvokeStrategy(String name) {
        return map.get(name);
    }

    public static void register(String name, AbstractTaskFinishHandler strategy) {

        if(StringUtils.isEmpty(name) || null == strategy) {
            return;
        }
        map.put(name, strategy);
    }
}
