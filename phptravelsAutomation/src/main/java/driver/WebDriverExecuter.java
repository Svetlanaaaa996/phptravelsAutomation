package driver;


import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;

/*
 * Class presenting wed driver executer.
 */
public final class WebDriverExecuter {

    private static final String homeUrl = "https://phptravels.net/";

    final WebDriver chromeDriver;

    public WebDriverExecuter() throws IOException {
        WebDriverManager.chromedriver().setup();
        this.chromeDriver = new ChromeDriver();
    }

    public WebDriver getWebDriver() {
        return chromeDriver;
    }

    public HomePage openHomePage() {
        chromeDriver.get(homeUrl);
        return new HomePage(chromeDriver);
    }

    public void closeBrowser() {
        chromeDriver.close();
    }
}


