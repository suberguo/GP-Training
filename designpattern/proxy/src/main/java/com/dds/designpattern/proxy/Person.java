package com.dds.designpattern.proxy;

import com.dds.designpattern.proxy.IPerson;

public class Person implements IPerson {
    public void findLove(){
        System.out.println("本人确认");
    }
}
