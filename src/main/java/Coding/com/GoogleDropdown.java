package Coding.com;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleDropdown {

	
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		WebElement textarea = driver.findElement(By.xpath("//*[@class='gLFyf']"));
		textarea.clear();
		textarea.sendKeys("testing");
		
		List<WebElement> list = driver.findElements(By.xpath("//*[@class='OBMEnb']/child::ul/descendant::li"));
		for(int i=0; i<list.size(); i++) {
			System.out.println(list.get(i).getText());
			
			if(list.get(i).getText().equals("testing tools")) {
				list.get(i).click();
				break;
			}
		}

	}

}
