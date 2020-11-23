package PageObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;

public class MagnushealthDetailsPage {
	WebDriver driver;
	
	
	public MagnushealthDetailsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	//Capturing Xpath
	@FindBy(xpath = "//input[@id='j_username']")
	private WebElement username;
	
	@FindBy(xpath = "//input[@id='j_password']")
	private WebElement Password;

	@FindBy(xpath = "//button[@id='login_button']")
	private WebElement LoginButton;
	
	@FindBy(xpath = "(//a[@class='button medium orange'])[2]")
	private WebElement UserButton;

	public void clickOnUserButton() {
		UserButton.click();
	}
	
	public void setusername(String strusername) {
		username.clear();
		username.sendKeys(strusername);
	}
	
	public void setPassword(String strPassword) {
		Password.clear();
		Password.sendKeys(strPassword);
	}
	
	public void clickOnLoginButton() {
		LoginButton.click();
	}
}
