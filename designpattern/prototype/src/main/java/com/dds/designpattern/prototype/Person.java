package com.dds.designpattern.prototype;

import java.io.Serializable;

public class Person implements Serializable {
    private String name;
    private String position;
    private int age;
    private String sex;

    private Address address;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Person clone(){
        Person p = new Person();
        p.setAge(this.getAge());
        p.setName(this.getName());
        p.setPosition(this.getPosition());
        p.setSex(this.getSex());

        return p;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", position='" + position + '\'' +
                ", age=" + age +
                ", sex='" + sex + '\'' +
                '}';
    }
}
