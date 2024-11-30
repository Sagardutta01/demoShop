package demoShop.testpage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import demoShop.base.TestBase;
import demoShop.pages.ApparelnShoesPageOfDemoShop;
import demoShop.pages.HomePageOfDemoShop;
import demoShop.pages.LoginPageOfDemoShop;

public class Test_HomePageOfDemoShop extends TestBase{
	
	LoginPageOfDemoShop loginPage;
	HomePageOfDemoShop homePage;
	ApparelnShoesPageOfDemoShop apparelnShoe;
	
	public Test_HomePageOfDemoShop() {
		//calling TestBase Class constructor to access prop
		super();
		
		
	}
	
	@BeforeMethod
	public void openingBrowser() {
		TestBase.initializationOfBrowser();
		loginPage = new LoginPageOfDemoShop(driver);
		homePage = loginPage.loginToAccount();
		
		
	}
	@Test(priority = 1)
	public void verifyUserProfileOfDemoShop() {
		//homePage = new HomePageOfDemoShop(driver);
		boolean check = homePage.verifyUserProfile();
		Assert.assertEquals(check, true);
	}
	
	@Test(priority = 2)
	public void verifyTitileOfHomepageOfDemoShop() {
		//homePage = new HomePageOfDemoShop(driver);
		String titlehome = homePage.verifyTitileOfHomepage();
		Assert.assertEquals(titlehome, "Demo Web Shop");
	}
	
	@Test
	public void nextPage() {
		apparelnShoe=homePage.goToApparal();
	}
	
	@AfterMethod
	public void closingBrowser() {
		//driver.quit();
	}

}
