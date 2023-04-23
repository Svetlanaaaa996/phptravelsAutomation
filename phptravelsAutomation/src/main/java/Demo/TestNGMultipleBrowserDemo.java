package Demo;

import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import driver.WebDriverExecuter;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import Pages.LoginPage;

public class TestNGMultipleBrowserDemo {
	 final WebDriver chromeDriver = null;
	 final WebDriver firefoxDriver = null;
	 
	private static final String homeUrl = "https://phptravels.net/";
	LoginPage loginPage;
	WebDriverExecuter webDriverExecuter;
	
	@Parameters("browseName")
	@BeforeTest
	public void setup(String browserName) {
	  System.out.println("Browser name is:"+browserName);
	  if(browserName.equalsIgnoreCase("chrome")){
		  WebDriverManager.chromedriver().setup();
	        WebDriver chromedriver = new ChromeDriver();}
	  else if(browserName.equalsIgnoreCase("firefox")){
		 WebDriverManager.firefoxdriver().setup(); 
		  WebDriver firefoxdriver = new FirefoxDriver();
	  
	  
	  }
	  }
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
