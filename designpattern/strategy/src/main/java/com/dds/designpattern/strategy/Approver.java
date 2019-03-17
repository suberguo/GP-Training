package com.dds.designpattern.strategy;

/**
 * 审批人
 */
public class Approver {

    private String name;

    public Approver(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Approver{" +
                "name='" + name + '\'' +
                '}';
    }
}
