package Pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/*
 * Class presenting home page web elements.
 */
public class HomePage {

    private static final By HOME_HEADER_TEXT_SELECTOR 
        = By.xpath("//p[contains(text(),'million')]");
    private static final By ACCOUNT_BUTTON_SELECTOR = By.id("ACCOUNT");
    private static final By CUSTOMER_LOGIN_BUTTON_SELECTOR 
        = By.xpath("//a[contains(text(), 'Customer Login')]");
    private static final By CUSTOMER_SIGNUP_BUTTON_SELECTOR 
        = By.xpath("//a[contains(text(), 'Customer Signup')]");

    final WebDriver webDriver;

    public HomePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public String getHomePageHedearString() {
        return webDriver.findElement(HOME_HEADER_TEXT_SELECTOR).getText();
    }

    public LoginPage getLoginPage() {
        clickOnAccountButton();
        webDriver.findElement(CUSTOMER_LOGIN_BUTTON_SELECTOR).click();
        return new LoginPage(webDriver);
    }

    public SignUpPage getSignUpPage() {
        clickOnAccountButton();
        webDriver.findElement(CUSTOMER_SIGNUP_BUTTON_SELECTOR).click();
        return new SignUpPage(webDriver);
    }

    // Private methods.

    private void clickOnAccountButton() {
        webDriver.findElement(ACCOUNT_BUTTON_SELECTOR).click();
    }
}
