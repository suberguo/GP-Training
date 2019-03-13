package com.dds.designpattern.singleton.hunger;

public class CEO {

    private static final CEO INSTANCE = new CEO("张三");

    private CEO(String name) {
        this.name = name;
    }

    private String name = "张三";

    public String getName() {
        return name;
    }

    public static final CEO getInstance() {
        return INSTANCE;
    }


}
