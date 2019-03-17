package com.dds.designpattern.strategy;

/**
 * 审批人查找策略
 * 系统操作界面上会设置三种类型的审批人供配置人员选择
 * @see ReporttoApproverStrategy   上级领导：根据汇报关系找审批人
 * @see CostCenterApproverStrategy 成本中心：根据成本中心找审批人
 * @see RoleApproverStrategy       审批角色：根据审批权限(通过单据各属性解析审批权限)找审批人
 */
public abstract class ApproverStrategy {

   public abstract Approver find(ApplyOrder order);

}
