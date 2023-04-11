package com.example.demo.service;

import com.example.demo.common.enums.ChannelRuleEnum;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Classname ChannelRuleServiceTest
 * @Description TODO
 * @Date 2021/6/7 18:05
 * @Created by lichunle
 */
@SpringBootTest
public class ChannelRuleServiceTest {

    @Test
    public void test() {
        String name = "TENCENT";

        ChannelRuleEnum channel = ChannelRuleEnum.parseFromCode(name);
        GeneralChannelRule rule = channel.getChannel();
        rule.process();
    }
}
