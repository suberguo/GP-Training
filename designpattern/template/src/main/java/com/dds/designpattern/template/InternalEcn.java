package com.dds.designpattern.template;

public class InternalEcn extends Ecn {

    @Override
    public boolean initiate() {
        System.out.println("内部PE发起");
        return true;
    }

}
