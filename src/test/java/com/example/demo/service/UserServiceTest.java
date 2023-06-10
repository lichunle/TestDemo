package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.DemoApplication;
import com.example.demo.bean.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoApplication.class})
public class UserServiceTest {


    @Autowired
    private UserService userServiceImpl;

    @Transactional(rollbackFor = Throwable.class)
    @Test
    public void testSave() {

//        for (int i = 0; i < 100 ; i++) {
            User u1 = new User();
            u1.setUserName("bob");
            u1.setSex("male");
            userServiceImpl.save(u1);

//        }
        int i = 1/0;
        System.out.println("===========================");
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
