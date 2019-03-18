import com.dds.designpattern.adapter.FedEx;
import com.dds.designpattern.adapter.FedExAdapter;
import com.dds.designpattern.adapter.SfExpress;
import com.dds.designpattern.adapter.SfExpressImpl;

public class AdapterTest {
    public static void main(String[] args) {
        SfExpress express = new SfExpressImpl();
        express.ship();
        express.route();

        SfExpress expressAdapter = new FedExAdapter(new FedEx());
        expressAdapter.ship();
        expressAdapter.route();
    }
}
