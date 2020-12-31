package com.example.demo.controller;

import com.example.demo.bean.model.User;
import com.example.demo.dao.UserMapper;
import com.example.demo.service.PeoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/hancheng")
@Scope("prototype")
public class HanchengController {

    private int count;
    @Autowired
    private PeoService peoService;

    @RequestMapping("/hello")
    public String hello() {

        peoService.insertBath();
        return "welcome!!!";
    }

    @RequestMapping("/countVal")
    public int countVal() {
        count++;
        return count;
    }
}
