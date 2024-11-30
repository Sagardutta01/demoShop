package demoShop.testpage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import demoShop.base.TestBase;
import demoShop.pages.ApparelnShoesPageOfDemoShop;
import demoShop.pages.BlueAndGreenSneaker;
import demoShop.pages.CartOfDemoShop;
import demoShop.pages.HomePageOfDemoShop;
import demoShop.pages.LoginPageOfDemoShop;

public class Test_AppareInShoesPageOfDemoShop extends TestBase{

	LoginPageOfDemoShop loginPage;
	HomePageOfDemoShop homePage;
	ApparelnShoesPageOfDemoShop apparelinshoepage;
	BlueAndGreenSneaker BlueSneaker;
	CartOfDemoShop cartpage;
	
	public Test_AppareInShoesPageOfDemoShop() {
		super();
	}
	
	@BeforeMethod
	public void startup() {
		TestBase.initializationOfBrowser();
		loginPage = new LoginPageOfDemoShop(driver);
		homePage = loginPage.loginToAccount();
		apparelinshoepage=homePage.goToApparal();
		BlueSneaker=apparelinshoepage.addShoetocart();
		
	}
	
	@Test(priority = 1)
	public void addShoeInCart() throws InterruptedException {
		BlueSneaker.addShoes();
		boolean test = BlueSneaker.addToCartConfirmation();
		Assert.assertTrue(test);
		BlueSneaker.gotocartpage();
			
	}
	
	
	
	@AfterMethod
	public void closeup() {
		//driver.close();
	}
	
	
	
}
