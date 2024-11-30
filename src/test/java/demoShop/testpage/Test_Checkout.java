package demoShop.testpage;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import demoShop.base.TestBase;
import demoShop.pages.ApparelnShoesPageOfDemoShop;
import demoShop.pages.BlueAndGreenSneaker;
import demoShop.pages.CartOfDemoShop;
import demoShop.pages.HomePageOfDemoShop;
import demoShop.pages.LoginPageOfDemoShop;
import demoShop.pages.Onepagecheckout;

public class Test_Checkout extends TestBase{
	LoginPageOfDemoShop loginPage;
	HomePageOfDemoShop homePage;
	ApparelnShoesPageOfDemoShop apparelinshoepage;
	BlueAndGreenSneaker BlueSneaker;
	CartOfDemoShop cartpage;
	Onepagecheckout onepagecheckout;
	
	public Test_Checkout() {
		super();
	}
	
	@BeforeMethod
	public void startUp() throws InterruptedException {
		TestBase.initializationOfBrowser();
		loginPage = new LoginPageOfDemoShop(driver);
		homePage = loginPage.loginToAccount();
		apparelinshoepage=homePage.goToApparal();
		BlueSneaker=apparelinshoepage.addShoetocart();
		BlueSneaker.addShoes();
		cartpage=BlueSneaker.gotocartpage();
		//cartpage = new CartOfDemoShop();
		onepagecheckout=cartpage.goToOnepagecheckout();
        
		
	}
	@Test
	public void checkoutProcess() throws InterruptedException {
		onepagecheckout.billing_Address();
		onepagecheckout.Shipping_Address();
		onepagecheckout.Shipping_Method();
		onepagecheckout.Payment_method();
		onepagecheckout.Payment_information();
		
		//here we need to validate table and close the checkout;
			
	}
	
	@AfterMethod
	public void tearDown() {
		
	}
	
	
	
	
}
