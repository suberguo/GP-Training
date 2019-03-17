package com.dds.designpattern.strategy;

/**
 * 按成本线找审批人
 */
public class CostCenterApproverStrategy extends ApproverStrategy {



    @Override
    public Approver find(ApplyOrder order) {
        int costCenter = this.getCostCenter(order.getApplyUserId());
        return this.findApproverByCostCenter(costCenter);
    }


    /**
     *
     * @param userId
     * @return
     */
    private int getCostCenter(int userId){
        //具体业务逻辑省略
        return 5;
    }

    /**
     * 不同的成本线设置了不同的审批人
     * @return
     */
    private Approver findApproverByCostCenter(int costCenter){
        return new Approver("成本线审批人");
    }
}
