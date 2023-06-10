package com.example.demo.design;

public class SingletonTest {

    private volatile static SingletonTest instance;

    public SingletonTest getInstance() {

        if(null == instance) {
            synchronized (SingletonTest.class) {
                if(null == instance) {
                    instance = new SingletonTest();
                }
            }
        }
        return instance;
    }
}
