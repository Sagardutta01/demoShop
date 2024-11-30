package demoShop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import demoShop.base.TestBase;

public class LoginPageOfDemoShop extends TestBase{
	HomePageOfDemoShop homePage;
	
	@FindBy(id="Email")
	WebElement user_Email;
	
	@FindBy(id="Password")
	WebElement user_Password;
	
	@FindBy(xpath="//input[@value='Log in']")
	WebElement login_btn;
	
	
	public LoginPageOfDemoShop (WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitileOfLoginpage() {
		String title = driver.getTitle();
		return title;
	}
	
	public HomePageOfDemoShop loginToAccount() {
		user_Email.sendKeys(prop.getProperty("username"));
		user_Password.sendKeys(prop.getProperty("password"));
		login_btn.click();
		/*now after click on login button page will land of homepage
		hence returning homepage object
		*/
		System.out.println("I am at homepage");
		return new HomePageOfDemoShop();
	}
	
	
	
	
}


