package Coding.com;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class DataProviderToExcel {
	
	public static WebDriver driver;
	
	@DataProvider(name="dataEx")
	public Object[][] startMethod() throws IOException{
		return EnterExcelToField.getData("Sheet1");
	}
	
	@Test(dataProvider="dataEx",dataProviderClass = DataProviderToExcel.class)
	
	public void runMeToComplete(String Make,String Engine_Performance,String Date_of_Manufacture) {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://sampleapp.tricentis.com/101/app.php");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.findElement(By.xpath("//*[@id='make']")).sendKeys(Make);
		System.out.println(Make);
		driver.findElement(By.xpath("//*[@id='engineperformance']")).sendKeys(Engine_Performance);
		System.out.println(Engine_Performance);
		driver.findElement(By.xpath("//*[@id='dateofmanufacture']")).sendKeys(Date_of_Manufacture);
		System.out.println(Date_of_Manufacture);
		/*
		driver.findElement(By.xpath("//*[@id='numberofseats']"));
		driver.findElement(By.xpath("//*[@id='fuel']"));
		driver.findElement(By.xpath("//*[@id='listprice']"));
		driver.findElement(By.xpath("//*[@id='licenseplatenumber']"));
		driver.findElement(By.xpath("//*[@id='annualmileage']"));
		*/
		
	}

}
