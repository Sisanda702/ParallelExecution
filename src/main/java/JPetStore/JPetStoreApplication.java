package JPetStore;

import JPetStore.pages.LoginPage;
import JPetStore.pages.RegisterPage;
import Roman.Roman;

public class JPetStoreApplication {
    public LoginPage loginpage;
    public RegisterPage registerpage;

    public JPetStoreApplication(Roman roman) {
        loginpage = new LoginPage(roman);
        registerpage = new RegisterPage(roman);
    }
}
