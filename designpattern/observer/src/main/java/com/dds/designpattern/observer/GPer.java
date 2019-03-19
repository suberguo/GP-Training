package com.dds.designpattern.observer;

import com.google.common.eventbus.EventBus;

public class GPer {

    private String name = "咕泡社区";

    private static GPer instance;

    private GPer(String name){
        this.name = name;
    }

    public static GPer getInstance(){
        if(instance == null){
            instance = new GPer("咕泡社区");
        }
        return instance;
    }

    public void publishQuestion(Question question) {
        EventBus eventBus = new EventBus();
        for (User user : question.getOwner().getFollowers()) {
            eventBus.register(user);
        }
        System.out.println(question.getOwner().getName() + "在" + this.name + "提了一个问题:" + question.getName());
        eventBus.post(question);
    }

}
