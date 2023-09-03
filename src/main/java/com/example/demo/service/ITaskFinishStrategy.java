package com.example.demo.service;

import org.springframework.beans.factory.InitializingBean;

public interface ITaskFinishStrategy extends InitializingBean {

    void doAward(String name);
}
