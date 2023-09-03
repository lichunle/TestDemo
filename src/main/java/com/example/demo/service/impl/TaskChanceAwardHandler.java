package com.example.demo.service.impl;

import com.example.demo.service.AbstractTaskFinishHandler;
import com.example.demo.service.WardHandlerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TaskChanceAwardHandler extends AbstractTaskFinishHandler {

    @Override
    public String desc(String name) {
        log.info("奖励完成任务次数");
        return "hello";
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        WardHandlerFactory.register("taskChance", this);
    }
}
