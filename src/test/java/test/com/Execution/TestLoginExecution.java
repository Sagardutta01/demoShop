package test.com.Execution;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test.com.base.TestBaseClass;
import test.com.page.TestHomePage;
import test.com.page.TestLoginPage;

public class TestLoginExecution extends TestBaseClass{
	TestLoginPage loginpage;
	TestHomePage homepage;
	
	public TestLoginExecution() {
		super();
	}
	
	@BeforeMethod
	public void startUp() {
		TestBaseClass.initializationOfBase();
		loginpage = new TestLoginPage(driver);
		homepage= loginpage.loginProcess();
		
	}
	
	@Test
	public void testloginProcess() {
		System.out.println(loginpage.titleCheck());
		
	}
	
	@AfterMethod
	public void closeUp() {
		driver.quit();
		
	}

}
