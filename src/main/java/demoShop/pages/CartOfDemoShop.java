package demoShop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import demoShop.base.TestBase;

public class CartOfDemoShop extends TestBase{
	
	Onepagecheckout onepagecheckout;

	@FindBy(xpath="//input[@name='termsofservice']")
	WebElement checkboxAgreement;
	
	@FindBy(xpath="//button[@id='checkout']")
	WebElement checkoutBtn;
	
	@FindBy(xpath="//td[@class='product']/a")
	WebElement check_productName;
	
	
	@FindBy(xpath="//span[contains(text(),'Qty.:')]/following-sibling::input")
	WebElement check_qty;
	
	@FindBy(xpath="//span[contains(text(),'Total:')]/following-sibling::span")
	WebElement check_total;
	
	public CartOfDemoShop() {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String validate_productname() {
		String productName = check_productName.getText();
		return productName;
	}
	
	public String validate_qty() {
		String quantity = check_qty.getAttribute("value");
		return quantity;
	}
	
	public String validate_Total() {
		String total = check_total.getAttribute("value");
		return total;
	}
	
	
	
	public Onepagecheckout goToOnepagecheckout() {
		checkboxAgreement.click();
		checkoutBtn.click();
		return new Onepagecheckout();
	}
	
}
