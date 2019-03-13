package com.dds.designpattern.proxy;

public class Son implements IPerson {
    @Override
    public void findLove() {
        System.out.println("儿子确认");
    }
}
