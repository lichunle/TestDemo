package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.DemoApplication;
import com.example.demo.bean.model.User;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoApplication.class})
public class UserServiceTest {


    @Autowired
    private UserService userServiceImpl;

//    @Transactional(rollbackFor = Throwable.class)
    @Test
    public void testSave() {

        List<User> list = new ArrayList<>();
//        for (int i = 0; i < 100 ; i++) {
            User u1 = new User();
            u1.setId(1L);
            u1.setUserName("bob");
            u1.setSex("male");
            User u2 = new User();
            u2.setId(2L);
            u2.setUserName("Ian");
            u2.setSex("male");
//            userServiceImpl.save(u1);
        list.add(u2);
        list.add(u1);
        String id = list.stream()
                .map(User :: getId)
                .map(String::valueOf)
                .filter(s -> !StringUtils.isEmpty(s))
                .collect(Collectors.joining(","));

//        }
//        int i = 1/0;
        System.out.println("===========================" + id);
    }

    @Test
    public void testGetById() {
        Long id = 1664234997239988225L;
        User user = userServiceImpl.getById(id);
        System.out.println(user.toString());
    }

    @Test
    public void testQueryList() {

        List<User> list = userServiceImpl.list();
        list.stream().forEach((u)->{
            System.out.println(u.toString());
        });
    }

    @Test
    public void testQueryWrapper() {
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>();
//        queryWrapper.eq(User::getUserName, "bob1");
        queryWrapper.in(User::getUserName,new String[]{"bob1","bob4","bob2"});
        List<User> list = userServiceImpl.list(queryWrapper);
        list.stream().forEach((u)->{
            System.out.println(u.toString());
        });
    }
}
