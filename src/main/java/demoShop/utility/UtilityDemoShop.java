package demoShop.utility;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import demoShop.base.TestBase;

public class UtilityDemoShop extends TestBase{
	public static Select select;
	public static WebDriverWait wait;
	public static JavascriptExecutor js;
	
	public static void dropDown(String value, WebElement element) {
		select = new Select(element);
		select.selectByVisibleText(value);
	}
	
	public static void waitUse(WebElement element) {
	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	WebElement continueButton = wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static void clickMethod(WebElement element , WebDriver driver) {
		js= ((JavascriptExecutor)driver);
		js.executeScript("arguments[0].click(true);", element);

	}

}
