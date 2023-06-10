package com.example.demo.bean.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

@Data
@TableName("t_user")
public class User implements Serializable {

    private Long id;

    private String userName;

    private String sex;

    private String phone;

}
