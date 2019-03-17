import com.dds.designpattern.strategy.*;

public class StrategyTest {
    public static void main(String[] args) {
        ApplyOrder order = new ApplyOrder();
        ApproverStrategy approverStrategy = ApproverStrategyFactory.getStrategy("REPORTTO");
        Approver approver = approverStrategy.find(order);
        System.out.println(approver);
    }
}
