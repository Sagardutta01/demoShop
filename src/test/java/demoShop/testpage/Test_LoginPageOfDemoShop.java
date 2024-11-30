package demoShop.testpage;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import demoShop.base.TestBase;
import demoShop.pages.HomePageOfDemoShop;
import demoShop.pages.LoginPageOfDemoShop;

public class Test_LoginPageOfDemoShop extends TestBase{
	LoginPageOfDemoShop loginPage;
	HomePageOfDemoShop homePage;
	
	public Test_LoginPageOfDemoShop() {
		//calling TestBase Class constructor to access prop
		super();
	}
	
	@BeforeMethod
	public void openingBrowser() {
		TestBase.initializationOfBrowser();
		loginPage = new LoginPageOfDemoShop(driver);
		homePage = loginPage.loginToAccount();
		
	}
	@Test
	public void verifyTitleofLoginPageOfDemoShop() {
		String titlelogin = loginPage.verifyTitileOfLoginpage();
		Assert.assertEquals(titlelogin, "Demo Web Shop");
	}
	
	@AfterMethod
	public void closingBrowser() {
		driver.quit();
	}
	

}
