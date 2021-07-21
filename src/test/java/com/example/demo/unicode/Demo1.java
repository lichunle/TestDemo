package com.example.demo.unicode;

import java.nio.charset.Charset;

/**
 * @Classname Demo1
 * @Description
 * @Date 2021/7/19 18:35
 * @Created by lichunle
 */
public class Demo1 {

    public static void main(String[] args) {

        String name = "沉默的大多数";
        byte[] bytes = name.getBytes(Charset.forName("GBK"));

        String newName = new String(bytes, Charset.forName("UTF-8"));
        String reName = new String(bytes, Charset.forName("GB2312"));
        String oriName = new String(bytes, Charset.forName("GBK"));
        System.out.println(newName);
        System.out.println(reName);
        System.out.println(oriName);
    }
}
