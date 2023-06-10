//package com.example.demo.service;
//
//import com.example.demo.bean.model.User;
//import com.example.demo.dao.UserMapper;
//import lombok.extern.slf4j.Slf4j;
//import org.redisson.api.RLock;
//import org.redisson.api.RedissonClient;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//
//@Slf4j
//@Service
//public class PeoService {
//
//    private Logger logger = LoggerFactory.getLogger(PeoService.class);
//
//    @Resource
//    private UserService userServiceImpl;
//    @Autowired
//    private UserMapper userMapper;
//    @Autowired
//    private RedissonClient redissonClient;
//
////    @Transactional
////    public void insertBath() {
////
////        User user = new User();
////        user.setUserName("first");
////        user.setPassword("123");
////        userMapper.insertSelective(user);
////        for (int i = 0;i < 10;i++) {
//////            if(i == 9) {
//////                throw new RuntimeException();
//////            }
////            userService.insert();
////            System.out.println("===============execute：[]===================" + i);
////        }
////    }
//    public List<User> queryList() {
//        List<User> users = new ArrayList<>();
//        RLock lockInfo = redissonClient.getLock("user1");
//        try {
//            boolean tryLock = lockInfo.tryLock(60, TimeUnit.SECONDS);
//            if(!tryLock) {
//                log.error("try lock fail");
//                return null;
//            }
//            log.info("execute task ....");
//            users = userServiceImpl.queryList();
//            logger.info("count:", users.size());
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } finally {
//            log.info("unlock...");
//            if(lockInfo.isLocked() && lockInfo.isHeldByCurrentThread()) {
//                lockInfo.unlock();
//            }
//        }
//        return users;
//    }
//}
