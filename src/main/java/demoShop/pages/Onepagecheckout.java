package demoShop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import demoShop.base.TestBase;
import demoShop.utility.UtilityDemoShop;

public class Onepagecheckout extends TestBase{
	
	
	
	//billing address
	@FindBy(xpath="//label[contains(text(),'Country:')]/following-sibling::select")
	WebElement country;
	
	@FindBy(xpath="//label[text()='City:']/following-sibling::input")
	WebElement city;
	
	@FindBy(xpath="//label[text()='Address 1:']/following-sibling::input")
	WebElement address1;
	
	@FindBy(xpath="//label[text()='Zip / postal code:']/following-sibling::input")
	WebElement zip;
	
	@FindBy(xpath="//label[text()='Phone number:']/following-sibling::input")
	WebElement phone;
	
	@FindBy(xpath="//div[@class='buttons']/input[@type='button' and @value='Continue']")
	WebElement continueBtn;
	
	@FindBy(xpath="//*[@id=\"shipping-method-buttons-container\"]/input")
	WebElement continueBtnSM;
	
	@FindBy(xpath="//*[@id=\"payment-method-buttons-container\"]/input")
	WebElement continueBtnPM;
	
	@FindBy(xpath="//*[@id=\"payment-info-buttons-container\"]/input")
	WebElement continueBtnPI;
	
	
	@FindBy(xpath="//select[@name=\"billing_address_id\"]")
	WebElement checkAddress;
	
	@FindBy(xpath="//div[@class=\"method-name\"]/input[@id=\"shippingoption_0\"]")
	WebElement Ground;
	
	@FindBy(xpath="//div[@class=\"method-name\"]/input[@id=\"shippingoption_1\"]")
	WebElement Next_Day_Air;
	
	@FindBy(xpath="//div[@class=\"method-name\"]/input[@id=\"shippingoption_2\"]")
	WebElement  second_Day_Air;
	
	@FindBy(xpath="//input[@id=\"paymentmethod_0\" and @type=\"radio\"]")
	WebElement  CashOnDelivery;
	
	@FindBy(xpath="//input[@id=\"paymentmethod_1\" and @type=\"radio\"]")
	WebElement  Check_MoneyOrder;
	
	@FindBy(xpath="//input[@id=\"paymentmethod_2\" and @type=\"radio\"]")
	WebElement  Credit_Card;
	
	@FindBy(xpath="//input[@id=\"paymentmethod_3\" and @type=\"radio\"]")
	WebElement  Purchase_Order;

	
	
	public Onepagecheckout() {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void billing_Address() {
		if(checkAddress.isDisplayed()==false) {
		UtilityDemoShop.dropDown("India", country);
		city.sendKeys("kolkata");
		address1.sendKeys("2/53 vidyasagar");
		zip.sendKeys("700047");
		phone.sendKeys("8981000000");

		continueBtn.click();
		}else {
			continueBtn.click();
		}
		
	}
	
	public void Shipping_Address() {
		continueBtn.click();
	}
	
	public void Shipping_Method() throws InterruptedException {
		Next_Day_Air.click();
		continueBtnSM.click();
		
	}
	
	public void Payment_method() {
		
		continueBtnPM.click();
	}
	
	public void Payment_information() {
		continueBtnPI.click();
	}


	

	
}
