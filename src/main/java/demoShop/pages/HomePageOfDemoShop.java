package demoShop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import demoShop.base.TestBase;

public class HomePageOfDemoShop extends TestBase{
	
	ApparelnShoesPageOfDemoShop apparelnShoe;
	
	@FindBy(xpath="//a[contains(text(),'Log out')]")
	WebElement logout_btn;
	
	@FindBy(xpath="//a[contains(text(),'sagar@ymail.com')]")
	WebElement userID_profile;
	
	@FindBy(xpath="//span[text()='Shopping cart']")
	WebElement shoppingCart_btn;
	
	@FindBy(xpath="//span[text()='Wishlist']")
	WebElement wishlist_btn;
	
	//@FindBy(xpath="//ul[@class='top-menu']/child::li[4]")
	@FindBy(xpath="//ul[@class='top-menu']/child::li[4]/a[contains(text(),'Apparel & Shoes')]")
	WebElement Topmenu_ApparelnShoes;
	
	@FindBy(xpath="//ul[@class='list']/li[4]/a[contains(text(),'Apparel & Shoes')]")
	WebElement Sidemenu_ApparelnShoes;
	
    
	
	public HomePageOfDemoShop() {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String verifyTitileOfHomepage() {
		String title = driver.getTitle();
		return title;
	}
	
	public boolean verifyUserProfile() {
		boolean userID = userID_profile.isDisplayed();
		return userID;
	}
	
	public ApparelnShoesPageOfDemoShop goToApparal() {
		Sidemenu_ApparelnShoes.click();
		System.out.println("I am at apparel and shoe");
		return new ApparelnShoesPageOfDemoShop();
	}
	
}
