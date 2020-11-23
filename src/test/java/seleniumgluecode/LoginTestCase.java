package seleniumgluecode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.xml.DOMConfigurator;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import BaseClass.BrowserSetup;
import PageObjectRepository.MagnushealthDetailsPage;
import Utility.log;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class LoginTestCase extends BrowserSetup{
	
	WebDriver driver;
	MagnushealthDetailsPage MHD;

	@When("^magnushealth Application is Launch$")
	public void magnushealth_Application_is_Launch() throws Throwable {
		

DOMConfigurator.configure("log4j.xml");
log.startTestCase("Starting Execution");

		String current = System.getProperty("user.dir");
		System.out.println("Current working directory in Java : " + current);
		File file = new File(System.getProperty("user.dir") + "\\config\\file.properties");
		FileInputStream fileInput = null;
		try {
			fileInput = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Properties prop = new Properties();
		try {
			prop.load(fileInput);
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver = BrowserSetup.StartBrowser(prop.getProperty("BrowserType"), prop.getProperty("Url"));
		
   
	}

	@Then("^User enters valid UserName \"([^\"]*)\"$")
	public void user_enters_valid_UserName(String strusername) throws Throwable {
      MHD = new MagnushealthDetailsPage(driver);
      MHD.setusername(strusername);
	}

	@Then("^User enters valid Password \"([^\"]*)\"$")
	public void user_enters_valid_Password(String strPassword) throws Throwable {
		 MHD = new MagnushealthDetailsPage(driver);
	      MHD.setPassword(strPassword);
	}

	@Then("^User click on Login button$")
	public void user_click_on_Login_button() throws Throwable {
		 MHD = new MagnushealthDetailsPage(driver);
	      MHD.clickOnLoginButton();
	      
	      String actualTitle = "Magnus Health";
	      String expectedtitle= driver.getTitle();
	      Assert.assertEquals(expectedtitle, actualTitle);
	      
	}

	@Then("^User close the Browser$")
	public void user_close_the_Browser() throws Throwable {
	    driver.close();
	}
}
