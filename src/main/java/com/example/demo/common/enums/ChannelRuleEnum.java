package com.example.demo.common.enums;

import com.example.demo.service.GeneralChannelRule;
import com.example.demo.service.impl.TencentGeneralChannelRule;
import com.example.demo.service.impl.TouTiaoGeneralChannelRule;

import java.util.Objects;

/**
 * @Classname ChannelRuleEnum
 * @Description
 * @Date 2021/6/7 17:48
 * @Created by lichunle
 */
public enum ChannelRuleEnum {

    TENCENT("TENCENT", new TencentGeneralChannelRule()),

    TOUTIAO("TOUTIAO", new TouTiaoGeneralChannelRule());

    private String name;

    private GeneralChannelRule channel;

    ChannelRuleEnum(String name, GeneralChannelRule channel) {
        this.name = name;
        this.channel = channel;
    }

    public static ChannelRuleEnum parseFromCode(String code) throws IllegalArgumentException {
        if (Objects.isNull(code) || 0 == code.trim().length()) {
            return null;
        }
        for (ChannelRuleEnum t : ChannelRuleEnum.values()) {
            if (t.name.equals(code)) {
                return t;
            }
        }
        throw new IllegalArgumentException("无效的枚举值" + code);
    }

    public String getName() {
        return name;
    }

    public GeneralChannelRule getChannel() {
        return channel;
    }
}
