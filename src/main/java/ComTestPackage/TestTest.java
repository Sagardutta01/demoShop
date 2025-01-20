package ComTestPackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestTest {
	public static WebDriver driver;
	
	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://sampleapp.tricentis.com/101/app.php");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		/*
		driver.findElement(By.xpath("//*[@id='make']")).sendKeys("Audi");
		driver.findElement(By.xpath("//*[@id='engineperformance']"));
		driver.findElement(By.xpath("//*[@id='dateofmanufacture']")).sendKeys("01/11/2024");
		driver.findElement(By.xpath("//*[@id='numberofseats']"));
		driver.findElement(By.xpath("//*[@id='fuel']"));
		driver.findElement(By.xpath("//*[@id='listprice']"));
		driver.findElement(By.xpath("//*[@id='licenseplatenumber']"));
		driver.findElement(By.xpath("//*[@id='annualmileage']"));
		*/
		driver.findElement(By.xpath("//*[@id='righthanddriveyes']/following-sibling::span")).click();
		
	}

}
