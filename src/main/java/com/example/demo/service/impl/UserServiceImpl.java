package com.example.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.bean.model.User;
import com.example.demo.common.utils.RedisCacheUtils;
import com.example.demo.dao.UserMapper;
import com.example.demo.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

//    @Autowired
//    private UserMapper userMapper;
//    @Autowired
//    private RedisCacheUtils redisCacheUtils;
//
//    @Transactional(propagation = Propagation.REQUIRED)
//    @Override
//    public void insert() {
////        User user = new User();
////        user.setUserName("ian");
////        user.setPassword("PKN");
////        userMapper.insertSelective(user);
//    }
//
//    @Override
//    public List<User> queryList() {
//
//        String key = "user:list";
//        String userListStr = (String) redisCacheUtils.get(key);
//        if(StringUtils.isNoneEmpty(userListStr)) {
//            return JSONArray.parseArray(userListStr, User.class);
//        }
//        List<User> users = userMapper.queryList();
//        redisCacheUtils.set(key, JSONObject.toJSONString(users), 60L);
//        return users;
//    }
}
