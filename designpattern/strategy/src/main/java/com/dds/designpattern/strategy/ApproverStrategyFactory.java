package com.dds.designpattern.strategy;

import java.util.HashMap;
import java.util.Map;

/**
 * 简单工厂类
 */
public class ApproverStrategyFactory {



    private static final Map<String,ApproverStrategy> approverStrategyMap = new HashMap<>();

    static {
        approverStrategyMap.put("REPORTTO", new ReporttoApproverStrategy());
        approverStrategyMap.put("COSTCENTER", new CostCenterApproverStrategy());
        approverStrategyMap.put("ROLE", new RoleApproverStrategy());

    }

    private ApproverStrategyFactory() {

    }

    public static ApproverStrategy getStrategy(String type) {
        if(approverStrategyMap.containsKey(type)){
            return approverStrategyMap.get(type);
        }else{
            return approverStrategyMap.get("ROLE");
        }
    }
}
