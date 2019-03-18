package com.dds.designpattern.template;

public class ExternalEcn extends Ecn {

    @Override
    public boolean initiate() {
        System.out.println("外部AE发起");
        return false;
    }

}
