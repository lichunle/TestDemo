package com.example.demo.copy;


public class Person implements Cloneable {

    private Address address;

    public Person() {}

    public Person(Address address) {
        this.address = address;
    }

    @Override
    public Person clone() {
        try {
            Person person =  (Person) super.clone();
            person.setAddress(person.getAddress().clone());
            return person;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public static void main(String[] args) {

        Person person1 = new Person(new Address("西安"));
        Person personCopy = person1.clone();
        System.out.println(person1  + "\t" + personCopy);
        System.out.println(person1.getAddress() == personCopy.getAddress());

        Object o = null;
        String s = "";
    }
}
