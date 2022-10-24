package JPetStore.pages;

import Roman.Roman;
import org.openqa.selenium.By;
import selenium.Selenium;


public class RegisterPage extends Selenium {
    private By userIdField = By.xpath("//input[@name='username']");
    private By newPasswordField = By.xpath("//input[@name='password']");
    private By repeatPasswordField = By.xpath("//input[@name='repeatedPassword']");
    private By firstNameField = By.xpath("//input[@name='account.firstName']");
    private By lastNameField = By.xpath("//input[@name='account.lastName']");
    private By emailField = By.xpath("//input[@name='account.email']");
    private By phoneField = By.xpath("//input[@name='account.phone']");
    private By addressOneField = By.xpath("//input[@name='account.address1']");
    private By addressTwoField = By.xpath("//input[@name='account.address2']");
    private By cityFieldField = By.xpath("//input[@name='account.city']");
    private By stateField = By.xpath("//input[@name='account.state']");
    private By zipCodeField = By.xpath("//input[@name='account.zip']");
    private By countryField = By.xpath("//input[@name='account.country']");
    private By languageField = By.xpath("//select[@name='account.languagePreference']");
    private By favCategoryField = By.xpath("//select[@name='account.favouriteCategoryId']");
    private By saveAccInfoBtn = By.xpath("//input[@value='Save Account Information']");

    public RegisterPage(Roman roman) {
        super(roman);
    }

    public void register(String userId, String newPassword, String repeatPassword, String firstName, String lastName, String email, String phone, String addressOne, String addressTwo, String city, String state, String zipCode, String country, String language, String favCategory) {
        findOne(userIdField, 10).sendKeys(userId);
        findOne(newPasswordField, 10).sendKeys(newPassword);
        findOne(repeatPasswordField, 10).sendKeys(repeatPassword);
        findOne(firstNameField, 10).sendKeys(firstName);
        findOne(lastNameField, 10).sendKeys(lastName);
        findOne(emailField, 10).sendKeys(email);
        findOne(phoneField, 10).sendKeys(phone);
        findOne(addressOneField, 10).sendKeys(addressOne);
        findOne(addressTwoField, 10).sendKeys(addressTwo);
        findOne(cityFieldField, 10).sendKeys(city);
        findOne(stateField, 10).sendKeys(state);
        findOne(zipCodeField, 10).sendKeys(zipCode);
        findOne(countryField, 10).sendKeys(country);
        selectFromDropdown(languageField, language);
        selectFromDropdown(favCategoryField, favCategory);
        click(saveAccInfoBtn);
    }

    protected String get_uri() {
        return "https://petstore.octoperf.com/actions/Account.action?newAccountForm=";
    }

    public boolean waitForDisplayed() {
        return false;
    }
}
