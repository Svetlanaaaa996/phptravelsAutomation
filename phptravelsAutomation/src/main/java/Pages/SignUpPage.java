package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/*
 * Class presenting sign up page web elements.
 */
public final class SignUpPage {

    private static final By FIRST_NAME_FIELD_SELECTOR 
        = By.xpath("//input[@name='first_name']");
    private static final By LAST_NAME_FIELD_SELECTOR 
        = By.xpath("//input[@name='last_name']");
    private static final By PHONE_FIELD_SELECTOR 
        = By.xpath("//input[@name='phone']");
    private static final By EMAIL_FIELD_SELECTOR
        = By.xpath("//input[@name='email']");
    private static final By PASSWORD_FIELD_SELECTOR
        = By.xpath("//input[@name='password']");
    private static final By ACCOUNT_TYPE_SELECTOR
        = By.id("account_type");

    final WebDriver webDriver;

    public SignUpPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void setRegistrationFields(String firstName, String lastName,
                                      String phone, String email,
                                      String password, String accountType) {
        addFirstName(firstName);
        addLastName(lastName);
        addPhone(phone);
        addPassword(password);
        addEmail(email);
        selectAccountType(accountType);
    }

    // Private methods.

    private void addFirstName(String text) {
        webDriver.findElement(FIRST_NAME_FIELD_SELECTOR).sendKeys(text);
    }
    private void addLastName(String text) {
        webDriver.findElement(LAST_NAME_FIELD_SELECTOR).sendKeys(text);
    }
    private void addPhone(String text) {
        webDriver.findElement(PHONE_FIELD_SELECTOR).sendKeys(text);
    }
    private void addEmail(String text) {
        webDriver.findElement(EMAIL_FIELD_SELECTOR).sendKeys(text);
    }
    private void addPassword(String text) {
        webDriver.findElement(PASSWORD_FIELD_SELECTOR).sendKeys(text);
    }
    private void selectAccountType(String text) {
        WebElement dropDown = webDriver.findElement(ACCOUNT_TYPE_SELECTOR);
        Select selectorObject = new Select(dropDown);
        selectorObject.selectByValue(text);
    }
}

