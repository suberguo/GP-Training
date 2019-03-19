package com.dds.designpattern.observer;

public class Question {

    private User owner;
    private String name;


    public Question(User owner, String name) {
        this.owner = owner;
        this.name = name;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
