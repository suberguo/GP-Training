package com.dds.designpattern.proxy.staticproxy;

import com.dds.designpattern.proxy.IPerson;

public class Matchmaker {

    private IPerson person;

    public Matchmaker(IPerson person) {
        this.person = person;
    }

    public void find(){
        System.out.println("媒婆帮忙找");
        this.person.findLove();
    }
}
