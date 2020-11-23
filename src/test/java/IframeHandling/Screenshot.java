package IframeHandling;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Screenshot {

	static WebDriver driver;
	static String url = "https://www.toolsqa.com/iframe-practice-page/";

	public static void main(String[] args) throws InterruptedException {
	
		String path = System.getProperty("user.dir");
		System.out.println(path); 
		System.setProperty("webdriver.chrome.driver",path+"\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();

		//maximize
		driver.manage().window().maximize();
		driver.get(url);
		
		Thread.sleep(5000);
		
		File scrfile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrfile, new File(System.getProperty("user.dir") + "//Screenshots//" + ".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
            driver.close();
	}

}
