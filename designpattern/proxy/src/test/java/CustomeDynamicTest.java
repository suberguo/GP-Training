import com.dds.designpattern.proxy.IPerson;
import com.dds.designpattern.proxy.Person;
import com.dds.designpattern.proxy.dynamicproxy.custome.CustomInvocationHandler;
import com.dds.designpattern.proxy.dynamicproxy.custome.DdsClassLoader;
import com.dds.designpattern.proxy.dynamicproxy.custome.DdsProxy;

public class CustomeDynamicTest {
    public static void main(String[] args) {
        IPerson person = new Person();
        IPerson personProxy = (IPerson) DdsProxy.newProxyInstance(new DdsClassLoader(), new Class<?>[]{IPerson.class}, new CustomInvocationHandler(person));
        personProxy.findLove();

    }
}
