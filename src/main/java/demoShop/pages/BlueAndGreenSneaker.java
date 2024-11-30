package demoShop.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import demoShop.base.TestBase;

public class BlueAndGreenSneaker extends TestBase {
	
	CartOfDemoShop cartpage;
	
	
	//qty
	@FindBy(xpath="//*[contains(text(),'Qty:')]/parent::div/child::input[1]")
	WebElement qty;
	
	//addtocart
	@FindBy(xpath="(//*[@value='Add to cart'])[1]")
	WebElement addtocart;
	
	//confirmation
	@FindBy(xpath="//p[@class='content']")
	WebElement addtoCartConfirmation;
		
	//cart
		@FindBy(xpath="//*[@id='topcartlink']")
		WebElement cartbtn;
		
	public BlueAndGreenSneaker() {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void addShoes() throws InterruptedException {
		qty.clear();
		qty.sendKeys("2");
		Thread.sleep(2000);
		addtocart.click();
			
	}
	
	public boolean addToCartConfirmation() {
		boolean checkPopUp = addtoCartConfirmation.isDisplayed();
		return checkPopUp;
	}
	
	public CartOfDemoShop gotocartpage() {
		cartbtn.click();
		return new CartOfDemoShop();
	}
}
