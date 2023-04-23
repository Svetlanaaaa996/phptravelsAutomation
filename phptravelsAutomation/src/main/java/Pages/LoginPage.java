package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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
    private static final By ERROR_MESSAGE_SELECTOR
        = By.xpath("//div[contains(@class,'failed')]");

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

    public boolean isErrorMessageDisplayed() {
        WebDriverWait driverWait
            = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        return driverWait.until(ExpectedConditions.visibilityOfElementLocated(ERROR_MESSAGE_SELECTOR)).isDisplayed();
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

