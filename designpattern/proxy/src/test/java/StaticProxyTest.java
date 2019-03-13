import com.dds.designpattern.proxy.staticproxy.Matchmaker;
import com.dds.designpattern.proxy.Person;

public class StaticProxyTest {
    public static void main(String[] args) {
        Person person = new Person();
        Matchmaker matchmaker = new Matchmaker(person);
        matchmaker.find();
    }
}
