package com.dds.designpattern.template;

/**
 * 以工厂工程变更通知流程作为案例
 * 过程：发起->?(PE审核)->PE经理审批->部门负责人确认->ECN执行人确认->PE确认
 * ECN分为内部或外部，内部PE发起的ECN不需要PE审核
 */
public abstract class Ecn {

    public void execute(){
        if(!this.initiate()) {
            this.reviewByPE();
        }
        this.approveByPEManager();
        this.confirmByDeptManager();
        this.confirmByECNExecutor();
        this.confirmByPE();
    }

    /**
     * 发起
     */
    public abstract boolean initiate();

    /**
     * PE审核
     */
    protected final void reviewByPE() {
        System.out.println("  PE审核");
    }

    /**
     * PE经理审批
     */
    protected final void approveByPEManager() {
        System.out.println("    PE经理审批");
    }

    /**
     * 部门责任人确认
     */
    protected final void confirmByDeptManager() {
        System.out.println("      部门责任人确认");
    }

    protected final void confirmByECNExecutor() {
        System.out.println("        ECN执行人确认");
    }

    protected final void confirmByPE() {
        System.out.println("          PE确认");
    }

}
