import com.dds.designpattern.factorymethod.BibleFactory;
import com.dds.designpattern.factorymethod.FairytaleFactory;
import com.dds.designpattern.factorymethod.PublishingFactory;

/**
 * 工厂方法测试
 */
public class FactoryMethodTest {
    public static void main(String[] args) {
        PublishingFactory factory1 = new BibleFactory();
        System.out.println(factory1.create());

        PublishingFactory factory2 = new FairytaleFactory();
        System.out.println(factory2.create());
    }
}
