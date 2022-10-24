package jpetstoretests;

import JPetStore.JPetStoreApplication;
import JPetStore.models.Credentials;
import Roman.RomanBase;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import testwatcher.MyTestWatcher;

import java.util.concurrent.TimeUnit;
@ExtendWith(MyTestWatcher.class)
public class JPetStoreTestsTwo extends RomanBase {


    @Before
    public void setup() {
        roman()._driver = roman().selenium.getChromeDriver();
        roman()._driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
    }

    @Test
    public void petStoreTestOne() {
        JPetStoreApplication jpetstore = new JPetStoreApplication(roman());
        jpetstore.loginpage.clickSignInTab();
        jpetstore.loginpage.login(new Credentials("sara@gmail.com", "12345"));
        jpetstore.loginpage.orderItems();
    }
}