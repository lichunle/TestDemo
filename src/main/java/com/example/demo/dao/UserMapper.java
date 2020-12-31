package com.example.demo.dao;

import com.example.demo.bean.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {

    public int insertSelective(User user);
}
