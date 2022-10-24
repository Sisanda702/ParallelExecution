package JPetStore.pages;

import Roman.Roman;
import org.openqa.selenium.By;
import selenium.Selenium;


import JPetStore.models.Credentials;

public class LoginPage extends Selenium {
    private By signInTab = By.xpath("//a[text()='Sign In']");
    private By registerTab = By.xpath("//a[text()='Register Now!']");
    private By usernameField = By.xpath("//input[@name='username']");
    private By passwordField = By.xpath("//input[@name='password']");
    private By loginBtn = By.xpath("//input[@value='Login']");
    private By selectFish = By.xpath("//img[@src='../images/fish_icon.gif']");
    private By fishId = By.xpath("//a[contains(., 'FI-SW-02')]");
    private By addToCartBtn = By.xpath("//a[@class='Button']");
    private By qualityField = By.xpath("//input[@name='EST-3']");
    private By updateCart = By.xpath("//input[@name='updateCartQuantities']");
    private By checkOutBtn = By.xpath("//a[contains(., 'Proceed to Checkout')]");
    private By continueBtn = By.xpath("//input[@name='newOrder']");
    public LoginPage(Roman roman) {
        super(roman);
    }

    public void clickSignInTab() {
        navigateTo();
        click(signInTab);
    }

    public void clickRegisterTab() {

        click(registerTab);
    }

    public void login(Credentials credentials) {
        findOne(usernameField, 15).sendKeys(credentials.username);
        findOne(passwordField, 15).sendKeys(credentials.password);
        click(loginBtn);
    }

    public void orderItems() {
        navigateTo();
        click(selectFish);
        click(fishId);
        click(addToCartBtn);
        findOne(qualityField, 10).sendKeys("3");
        click(updateCart);
        click(checkOutBtn);
        click(continueBtn);
    }

    protected String get_uri() {
        return "https://petstore.octoperf.com/actions/Catalog.action";
    }

    public boolean waitForDisplayed() {
        return false;
    }
}
