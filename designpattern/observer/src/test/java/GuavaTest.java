import com.dds.designpattern.observer.GPer;
import com.dds.designpattern.observer.User;

public class GuavaTest {
    public static void main(String[] args) {

        User suber = new User("suber");
        User tom  = new User("tom");
        User mic = new User("mic");

        tom.At(suber);
        mic.At(suber);
        suber.submitQuestion();

        suber.At(tom);
        mic.At(tom);
        tom.submitQuestion();

    }
}
