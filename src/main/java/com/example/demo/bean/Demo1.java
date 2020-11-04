package com.example.demo.bean;

public class Demo1 {

    public static void main(String[] args) {
        UserInfo user = new UserInfo();
        user.setUserName("jack");
        user.setAge(28);
        try {
            UserInfo user1 = (UserInfo) user.clone();
            System.out.println("user==user1:"+(user==user1));
            System.out.println("user:hashcode"+user.hashCode());
            System.out.println("user1:hashcode"+user1.hashCode());
            System.out.println("user:name:/t" + user.getUserName());
            System.out.println("user1:name:/t" + user1.getUserName());
            String[] arr = {};
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
