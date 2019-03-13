import com.dds.designpattern.abstractfactory.Factory;
import com.dds.designpattern.abstractfactory.HuMenFactory;
import com.dds.designpattern.abstractfactory.ShenZhenFactory;

/**
 * 抽象工厂测试
 */
public class AbstractFactoryTest {
    public static void main(String[] args) {

        Factory shenZhenFactory = new ShenZhenFactory();
        System.out.println("深圳工厂生产");
        System.out.println(shenZhenFactory.createBook());
        System.out.println(shenZhenFactory.createMagazine());


        Factory huMenFactory = new HuMenFactory();
        System.out.println("虎门工厂生产");
        System.out.println(huMenFactory.createBook());
        System.out.println(huMenFactory.createMagazine());

    }
}
