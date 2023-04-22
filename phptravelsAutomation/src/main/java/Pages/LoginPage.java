package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
 * Class presenting login page web elements.
 */
public final class LoginPage {

    private static final By EMAIL_FIELD_SELECTOR 
        = By.xpath("//input[@name='email']");
    private static final By PASSWORD_FIELD_SELECTOR 
        = By.xpath("//input[@name='password']");
    private static final By LOGIN_BUTTON_SELECTOR 
        = By.xpath("//span[contains(text(), 'Login')]");
    
    final WebDriver webDriver;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void setLoginCredentials(String email, String password) {
        addEmail(email);
        addPassword(password);
        clickOnLoginButton();
    }

    public String getEmailFieldErrorMessage() {
        return webDriver.findElement(EMAIL_FIELD_SELECTOR)
             .getAttribute("validationMessage");
    }

    public String getPasswordFieldErrorMessage() {
        return webDriver.findElement(PASSWORD_FIELD_SELECTOR)
             .getAttribute("validationMessage");
    }

    // private methods.

    private void addEmail(String text) {
        webDriver.findElement(EMAIL_FIELD_SELECTOR).sendKeys(text);
    }

    private void addPassword(String text) {
        webDriver.findElement(PASSWORD_FIELD_SELECTOR).sendKeys(text);
    }

    private void clickOnLoginButton() {
        webDriver.findElement(LOGIN_BUTTON_SELECTOR).click();
    }

}
