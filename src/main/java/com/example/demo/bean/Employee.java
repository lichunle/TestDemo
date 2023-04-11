package com.example.demo.bean;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Classname Employee
 * @Description TODO
 * @Date 2021/5/15 10:09
 * @Created by lichunle
 */
@Data
@ToString
@NoArgsConstructor
public class Employee {
    private String id;
    private Long version;
    String firstName;
    String lastName;
    String age;
    String[] interests;
    String about;
}
