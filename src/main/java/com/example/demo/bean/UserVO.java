package com.example.demo.bean;

import com.example.demo.common.validation.EnumString;
import com.example.demo.common.validation.Phone;
import lombok.Data;

@Data
public class  UserVO {

    @EnumString(constStrings={"1", "0"})
    private String sex;

    @Phone
    private String phoneNo;
}
