package IframeHandling;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Iframe {
	static WebDriver driver;
	static String url = "https://www.toolsqa.com/iframe-practice-page/";

	public static void main(String[] args) {
	
		String path = System.getProperty("user.dir");
		System.out.println(path); 
		System.setProperty("webdriver.chrome.driver",path+"\\drivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();

		//maximize
		driver.manage().window().maximize();
		
		driver.get(url);
		
		List<WebElement> iframehandle = driver.findElements(By.tagName("iframe"));
		int countiframe = 	iframehandle.size()	;
		System.out.println("iframe in webpage : " + countiframe);
		
		for(int i=0;i<countiframe;i++)
		{
			driver.switchTo().frame(i);
		}
		
		


	}

}
