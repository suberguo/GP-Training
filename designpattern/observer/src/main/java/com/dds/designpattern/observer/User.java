package com.dds.designpattern.observer;

import com.google.common.eventbus.Subscribe;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.List;

public class User {

    private List<User> followers = new ArrayList<>();
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getFollowers() {
        return followers;
    }

    public void setFollowers(List<User> followers) {
        this.followers = followers;
    }

    @Subscribe
    public void subscribe(Question question){
        System.out.println(this.name + "收到了问题");
    }

    public void submitQuestion(){
        Question question = new Question(this,"工厂方法和抽象工厂的应用场景分别是什么？");
        GPer.getInstance().publishQuestion(question);
    }

    public void At(User user){
        user.getFollowers().add(this);
    }
}
