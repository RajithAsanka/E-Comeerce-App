import com.imperia.core.ResourceClientProxyPool;

/**
 * Created by Kithmal on 12/5/17.
 */
public class TestClient {

    public static void main(String[] args) {

        String responseCode = ResourceClientProxyPool.getInstance().getUserResourceClient().getUser();
        System.out.println("Response Code " + responseCode);

    }
}
