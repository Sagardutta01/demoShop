package test.com.page;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import test.com.base.TestBaseClass;

public class TestLoginPage extends TestBaseClass{
	TestHomePage homepage;
	
	@FindBy(id="Email")
	WebElement emailID;
	
	@FindBy(id="Password")
	WebElement passWORD;
	
	@FindBy(xpath="//input[@value='Log in']")
	WebElement Click;
	
	public TestLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public String titleCheck() {
		String value = driver.getTitle();
		return value;
	}
	
	public TestHomePage loginProcess() {
		emailID.sendKeys(prop.getProperty("username"));
		passWORD.sendKeys(prop.getProperty("password"));
		Click.click();
		return new TestHomePage();
		
	}
	
	
	

}
