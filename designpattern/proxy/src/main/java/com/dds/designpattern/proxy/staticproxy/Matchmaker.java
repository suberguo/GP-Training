package com.dds.designpattern.proxy.staticproxy;

public class Matchmaker {

    private Person person;

    public Matchmaker(Person person) {
        this.person = person;
    }

    public void find(){
        System.out.println("媒婆帮忙找");
        this.person.findLove();
    }
}
