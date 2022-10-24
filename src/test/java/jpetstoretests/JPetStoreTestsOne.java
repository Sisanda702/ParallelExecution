package jpetstoretests;

import JPetStore.JPetStoreApplication;
import Roman.RomanBase;
import org.junit.jupiter.api.AfterEach;
import JPetStore.models.Credentials;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.parallel.Execution;
import org.junit.jupiter.api.parallel.ExecutionMode;
import testwatcher.MyTestWatcher;

import java.util.concurrent.TimeUnit;
@ExtendWith(MyTestWatcher.class)
@Execution(ExecutionMode.CONCURRENT)
public class JPetStoreTestsOne extends RomanBase {

    @BeforeEach
    public void setup() {
        roman()._driver = roman().selenium.getChromeDriver();
        roman()._driver.manage().timeouts().implicitlyWait(5L, TimeUnit.SECONDS);
    }

    @org.junit.jupiter.api.Test
    public void petStoreTest() {
        JPetStoreApplication jpetstore = new JPetStoreApplication(roman());
        jpetstore.loginpage.clickSignInTab();
        jpetstore.loginpage.clickRegisterTab();
        jpetstore.registerpage.register("sara@gmail.com", "12345", "12345", "sara", "brown", "sara@gmail.com", "123456", "sst", "town two", "cape toen", "uknown", "7784", "south africa", "english", "DOGS");
    }


    @Test
    public void petStoreTestOne() {
        JPetStoreApplication jpetstore = new JPetStoreApplication(roman());
        jpetstore.loginpage.clickSignInTab();
        jpetstore.loginpage.login(new Credentials("sara@gmail.com", "12345"));
        jpetstore.loginpage.orderItems();
    }
    @AfterEach
    public void teardown()
    {
        roman()._driver.quit();
    }

}