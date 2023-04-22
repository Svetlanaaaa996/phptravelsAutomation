package login;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import driver.WebDriverExecuter;

/*
 * Class presenting login test cases.
 */
public final class LoginTests {

    WebDriverExecuter webDriverExecuter;
    LoginPage loginPage;

    @BeforeMethod
    public void CheckHomePageLoadedThenClickLogin() throws IOException {
        webDriverExecuter = new WebDriverExecuter();
        HomePage homePage = webDriverExecuter.openHomePage();
        Assert.assertEquals(homePage.getHomePageHedearString(),
                            "Choose best deals over 1.5 million travel services",
                            "Page header is not loaded");

        loginPage = homePage.getLoginPage();
    }

    @Test
    public void pub() {
        loginPage.setLoginCredentials("Svetlana@test", "");
        System.out.println(loginPage.getPasswordFieldErrorMessage());
    }

    @AfterMethod
    public void closeDriver() {
        webDriverExecuter.closeBrowser();
    }
}