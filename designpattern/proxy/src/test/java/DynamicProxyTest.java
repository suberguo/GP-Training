import com.dds.designpattern.proxy.IPerson;
import com.dds.designpattern.proxy.Person;
import com.dds.designpattern.proxy.Son;
import com.dds.designpattern.proxy.dynamicproxy.cglib.CglibMatchmaker;
import com.dds.designpattern.proxy.dynamicproxy.jdk.Matchmaker;

public class DynamicProxyTest {
    public static void main(String[] args) {
//        IPerson person = new Person();
//        Matchmaker matchmaker = new Matchmaker(person);
//        matchmaker.find();

        CglibMatchmaker cglibMatchmaker = new CglibMatchmaker(Son.class);
        Son son = cglibMatchmaker.getProxyInstance();
        System.out.println("媒婆帮忙找");
        son.findLove();

        CglibMatchmaker cglibMatchmaker2 = new CglibMatchmaker(Person.class);
        Person person = cglibMatchmaker2.getProxyInstance();
        System.out.println("媒婆帮忙找");
        person.findLove();

    }
}
