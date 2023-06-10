package com.example.demo.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class DemoJob {

    private Logger logger = LoggerFactory.getLogger(DemoJob.class);

    private final AtomicInteger counts = new AtomicInteger();

//    @Scheduled(fixedRate = 2000L)
    public void execute() {
        logger.info("execute 定时执行第{}次", counts.incrementAndGet());
    }
}
