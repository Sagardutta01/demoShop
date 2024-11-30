package demoShop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import demoShop.base.TestBase;

public class ApparelnShoesPageOfDemoShop extends TestBase {
	
	
	BlueAndGreenSneaker BlueSneaker;
	
	//shoe
	@FindBy(xpath="//div[@data-productid='28']/div[2]/div[3]/div[2]/input")
	WebElement sneaker;
	
	
	public ApparelnShoesPageOfDemoShop() {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public BlueAndGreenSneaker addShoetocart() {
		sneaker.click();
		return new BlueAndGreenSneaker();

	}
	
}
