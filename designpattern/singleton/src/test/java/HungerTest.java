import com.dds.designpattern.singleton.hunger.CEO;

public class HungerTest {
    public static void main(String[] args) {
        CEO ceo1 = CEO.getInstance();
        CEO ceo2 = CEO.getInstance();
        System.out.println(ceo1 == ceo2);
    }
}
