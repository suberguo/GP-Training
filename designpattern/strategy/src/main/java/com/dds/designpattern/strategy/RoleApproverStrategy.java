package com.dds.designpattern.strategy;

/**
 * 根据角色权限找审批人
 */
public class RoleApproverStrategy implements ApproverStrategy {


    @Override
    public Approver find(ApplyOrder order) {
        return this.findApprover();
    }

    /**
     * 根据申请单属性，比如mcu/bu等等查找
     * @return
     */
    private Approver findApprover(){
       return new Approver("角色审批人");
    }
}
