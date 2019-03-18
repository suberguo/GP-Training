import com.dds.designpattern.template.Ecn;
import com.dds.designpattern.template.ExternalEcn;
import com.dds.designpattern.template.InternalEcn;

public class TemplateTest {

    public static void main(String[] args) {
        Ecn internalEcn = new InternalEcn();
        internalEcn.execute();

        System.out.println("------------------------------");

        Ecn externalEcn = new ExternalEcn();
        externalEcn.execute();
    }
}
