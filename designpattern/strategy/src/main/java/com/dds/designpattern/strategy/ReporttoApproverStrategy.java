package com.dds.designpattern.strategy;


public class ReporttoApproverStrategy extends ApproverStrategy {


    @Override
    public Approver find(ApplyOrder order) {
        return this.findBoss(order.getApplyUserId());
    }

    private Approver findBoss(int userId){
        return new Approver("老板");
    }
}
