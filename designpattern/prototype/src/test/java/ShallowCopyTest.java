import com.dds.designpattern.prototype.Address;
import com.dds.designpattern.prototype.Person;
import com.dds.designpattern.prototype.shallow.PropertyUtils;

public class ShallowCopyTest {
    public static void main(String[] args) {
        Person person1 = new Person();
        person1.setSex("男");
        person1.setPosition("农民工");
        person1.setName("Suber");
        person1.setAge(20);
        person1.setAddress(new Address("广东省","深圳市","13800000000"));

        Person person2 = new Person();
        PropertyUtils.copy(person1,person2);

        System.out.println(person1 == person2);
        //浅拷贝引用类型只拷贝地址
        System.out.println(person1.getAddress() == person2.getAddress());


    }
}
