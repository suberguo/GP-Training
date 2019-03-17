import com.dds.designpattern.proxy.dynamicproxy.custome.DdsClassLoader;
import com.dds.designpattern.proxy.dynamicproxy.custome.DdsProxy;
import com.dds.designpattern.proxy.dynamicproxy.refactoring.CusomeLogInvocationHandler;
import com.dds.designpattern.proxy.dynamicproxy.refactoring.IDao;
import com.dds.designpattern.proxy.dynamicproxy.refactoring.LogInvocationHandler;
import com.dds.designpattern.proxy.dynamicproxy.refactoring.UserDao;


import java.lang.reflect.Proxy;

/**
 * 不影响原来代码增加日志功能
 */
public class UserDaoTest {
    public static void main(String[] args) {

        //重构前在业务类的方面里面调用

        //重构后不影响原来业务逻辑，也增加了日志功能
        IDao userDao = new UserDao();
//        IDao userDaoProxy = (IDao)Proxy.newProxyInstance(userDao.getClass().getClassLoader(),
//                userDao.getClass().getInterfaces(),new LogInvocationHandler(userDao));
//        userDaoProxy.getUser();


        IDao userDaoProxy = (IDao)DdsProxy.newProxyInstance(new DdsClassLoader(),
                userDao.getClass().getInterfaces(),new CusomeLogInvocationHandler(userDao));
        userDaoProxy.getUser();
    }
}
