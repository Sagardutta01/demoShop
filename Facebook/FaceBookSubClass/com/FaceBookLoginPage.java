package FaceBookSubClass.com;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import FaceBookBase.com.FaceBookSuperClass;

public class FaceBookLoginPage extends FaceBookSuperClass{
	

	FaceBookHomePage homepage;
	
	@FindBy(xpath="//input[@id='email']")
	WebElement emailID;
	
	@FindBy(xpath="//input[@id='pass']")
	WebElement PassWD;
	
	@FindBy(xpath="//button[@name='login']")
	WebElement LoginBTN;
	
	public FaceBookLoginPage() {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		
	}
	
	public FaceBookHomePage LoginProcess() {
		emailID.clear();
		emailID.sendKeys(prop.getProperty("username"));
		PassWD.clear();
		PassWD.sendKeys(prop.getProperty("password"));
		LoginBTN.click();
		return new FaceBookHomePage();
		
	}

}
