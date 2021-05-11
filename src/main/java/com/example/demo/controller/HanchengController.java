package com.example.demo.controller;

import com.example.demo.bean.model.User;
import com.example.demo.common.exception.ServiceException;
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

//    @Autowired
    private PeoService peoService;

    @RequestMapping("/hello")
    public String hello() throws ServiceException {
        try {
            int i = 8 / 0;
        } catch (Exception e) {
            throw new ServiceException("B0001");
        }
        return "welcome!!!";
    }

    @RequestMapping("/countVal")
    public int countVal() {
        count++;
        return count;
    }

    @RequestMapping("countVal1")
    public int countVal1() {
        return count++;
    }

    public PeoService getPeoService() {
        return peoService;
    }

    public void setPeoService(PeoService peoService) {
        this.peoService = peoService;
    }
}
