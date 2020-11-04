package com.example.demo.bean;

public class Dog  implements Animal {

    private String  color;
    public String name;

    public Dog() {}
    public Dog(String color) {
        this.color = color;
    }

    public void eat(String food) {
        System.out.println("I am eating\t" + food);
    }
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
