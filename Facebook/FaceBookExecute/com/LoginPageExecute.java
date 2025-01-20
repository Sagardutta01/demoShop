package FaceBookExecute.com;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import FaceBookBase.com.FaceBookSuperClass;
import FaceBookSubClass.com.FaceBookHomePage;
import FaceBookSubClass.com.FaceBookLoginPage;

public class LoginPageExecute extends FaceBookSuperClass{
	
	FaceBookLoginPage loginpage;
	FaceBookHomePage homepage;
	
	
	public LoginPageExecute() {
		super();
	}
	
	@BeforeMethod
	public void startup() {
		FaceBookSuperClass.startbrowser();
		loginpage = new FaceBookLoginPage();
			
		
	}
	
	@Test
	public void LogintoAccount() {
		loginpage.LoginProcess();
	}
	
	
	@AfterMethod
	public void closeup() {
		driver.close();
	}
}
