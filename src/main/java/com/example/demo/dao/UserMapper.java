package com.example.demo.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.bean.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
public interface UserMapper extends BaseMapper<User> {

//    int insertSelective(User user);

    List<User> queryList();
}
