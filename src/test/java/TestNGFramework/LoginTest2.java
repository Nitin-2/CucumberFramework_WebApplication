package TestNGFramework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



import BaseClass.BrowserSetup;
import PageObjectRepository.MagnushealthDetailsPage;

public class LoginTest2 extends BrowserSetup{
	
	static WebDriver driver;
	MagnushealthDetailsPage loginpage;
		
	   
	    
		@BeforeMethod
		public void HomePageNavigation() throws Throwable {
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

		@Test(groups= {"Smoke"})
		public void LoginTestCase() throws InterruptedException {
			
			loginpage = new MagnushealthDetailsPage(driver);

			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			loginpage.setusername("mngr280923");
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			loginpage.setPassword("UzUzUpE");
			
		//	driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		//	loginpage.clickOnLoginButton();

			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		}

		@Test(groups= {"Sanity"})
		public void LoginTestCase1() throws InterruptedException {
			
			loginpage = new MagnushealthDetailsPage(driver);

			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			loginpage.setusername("mngr280923");
			
			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
			loginpage.setPassword("UzUzUpE");

			driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
		}
		

		@AfterMethod(alwaysRun = true)
		public void tearDown()  {
			driver.quit();	
		}
	}


	


