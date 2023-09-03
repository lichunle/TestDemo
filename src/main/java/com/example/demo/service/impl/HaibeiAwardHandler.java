package com.example.demo.service.impl;

import com.example.demo.service.AbstractTaskFinishHandler;
import com.example.demo.service.WardHandlerFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class HaibeiAwardHandler extends AbstractTaskFinishHandler {

    @Override
    public void doWard(String name) {
        log.info("发放海贝================");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        WardHandlerFactory.register("Haibei", this);
    }
}
