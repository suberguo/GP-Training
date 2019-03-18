package com.dds.designpattern.template;

public class InternalEcn extends Ecn {

    @Override
    public void initiate() {
        System.out.println("内部PE发起");
    }

}
