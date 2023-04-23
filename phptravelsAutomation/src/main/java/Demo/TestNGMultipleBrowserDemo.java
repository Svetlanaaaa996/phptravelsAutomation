package Demo;

import org.testng.annotations.Test;

import Pages.HomePage;
import Pages.LoginPage;
import driver.WebDriverExecuter;
import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
import Demo.TestDataReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
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
	  TestDataReader testDataReader;
	  @BeforeClass
	    public void prepareTestDataReader() throws IOException {
	        // 0 index is login credentials sheet.
	        this.testDataReader = new TestDataReader(0);
	    }
	
	
	@Parameters("browserName")
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
	  @Test(priority = 1, description = "Validate email and password blank fields")
	    public void validateEmailAndPasswordBlankFields() {
	        loginPage.setLoginCredentials(testDataReader.getData(1, 0),
	                                      testDataReader.getData(1, 1));
	        Assert.assertEquals(loginPage.getEmailFieldErrorMessage(),
	                            "Please fill out this field.");
	    }

	    @Test(priority = 2, description = "Validate when password is a blank field")
	    public void validatePasswordBlankField() {
	        loginPage.setLoginCredentials(testDataReader.getData(2, 0),
	                                      testDataReader.getData(2, 1));
	        Assert.assertEquals(loginPage.getPasswordFieldErrorMessage(),
	                            "Please fill out this field.");
	    }

	    @Test(priority = 3, description = "Validate email when it doesn't have @")
	    public void validateEmailFieldWithoutAtSign() {
	        loginPage.setLoginCredentials(testDataReader.getData(3, 0),
	                                      testDataReader.getData(3, 1));
	        Assert.assertEquals(loginPage.getEmailFieldErrorMessage(),
	                            "Please include an '@' in the email address."
	                            + " 'TestwithoutAtsign' is missing an '@'.");
	    }

	    @Test(priority = 4, description = "Validate email when it doesn't have domain name")
	    public void validateEmailFieldWithoutDoaminName() {
	        loginPage.setLoginCredentials(testDataReader.getData(4, 0),
	                                      testDataReader.getData(4, 1));
	        Assert.assertEquals(loginPage.getEmailFieldErrorMessage(),
	                "'.' is used at a wrong position in '.com'.");
	    }

	    @Test(priority = 5, description = "Validate email when it doesn't have user name")
	    public void validateEmailFieldWithoutUserName() {
	        loginPage.setLoginCredentials(testDataReader.getData(5, 0),
	                                      testDataReader.getData(5, 1));
	        Assert.assertEquals(loginPage.getEmailFieldErrorMessage(),
	                            "Please enter a part followed by '@'. '@gmail.com'"
	                            + " is incomplete.");
	    }

	    @Test(priority = 6, description = "Validate invalid username and password")
	    public void validateInvalidEmailAndPassword() {
	        loginPage.setLoginCredentials(testDataReader.getData(6, 0),
	                                      testDataReader.getData(6, 1));
	        Assert.assertTrue(loginPage.isErrorMessageDisplayed());
	    }

	    @AfterMethod
	    public void closeDriver() {
	        webDriverExecuter.closeBrowser();
	    }
}