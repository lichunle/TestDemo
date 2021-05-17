package com.example.demo.common.enums;


import java.util.Objects;


public enum TemplateStatus {

    ON_LINE("ON_LINE", "上线"),
    OFF_LINE("OFF_LINE", "下线");

    private String code;
    private String desc;

    TemplateStatus(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 将String类型的value值解析成枚举类型
     *
     * @param code 枚举类型代码
     * @return 如果输入为空，则返回为null，如果输入不为空且匹配不上，则抛出IllegalArgumentException异常
     * @throws IllegalArgumentException
     */
    public static TemplateStatus parseFromCode(String code) throws IllegalArgumentException {
        if (Objects.isNull(code) || 0 == code.trim().length()) {
            return null;
        }
        for (TemplateStatus t : TemplateStatus.values()) {
            if (t.code.equals(code)) {
                return t;
            }
        }
        throw new IllegalArgumentException("无效的枚举值" + code);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}