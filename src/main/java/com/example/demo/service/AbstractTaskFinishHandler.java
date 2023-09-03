package com.example.demo.service;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

@Service
public abstract class AbstractTaskFinishHandler implements InitializingBean {

    public void doWard(String name) {
        throw new UnsupportedOperationException();
    }

    public String desc(String name) {
        throw new UnsupportedOperationException();
    }
}
