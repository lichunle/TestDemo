package com.example.demo.service;

import com.example.demo.bean.model.User;
import com.example.demo.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PeoService {

    @Autowired
    private UserService userService;
    @Autowired
    private UserMapper userMapper;

    @Transactional
    public void insertBath() {

        User user = new User();
        user.setUserName("first");
        user.setPassword("123");
        userMapper.insertSelective(user);
        for (int i = 0;i < 10;i++) {
//            if(i == 9) {
//                throw new RuntimeException();
//            }
            userService.insert();
            System.out.println("===============execute：[]===================" + i);
        }
    }
}
