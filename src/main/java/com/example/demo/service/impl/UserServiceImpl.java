package com.example.demo.service.impl;

import com.example.demo.bean.model.User;
import com.example.demo.dao.UserMapper;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Transactional(propagation = Propagation.REQUIRED)
    @Override
    public void insert() {
        User user = new User();
        user.setUserName("ian");
        user.setPassword("PKN");
        userMapper.insertSelective(user);
    }
}
