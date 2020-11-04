package com.example.demo.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hancheng")
@Scope("prototype")
public class HanchengController {

    private int count;

    @RequestMapping("/hello")
    public String hello() {
        return "welcome!!!";
    }

    @RequestMapping("/countVal")
    public int countVal() {
        count++;
        return count;
    }
}
