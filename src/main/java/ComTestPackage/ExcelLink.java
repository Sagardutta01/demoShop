package ComTestPackage;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExcelLink {
	
	public static WebDriver driver;
	
	@DataProvider(name="ThisData")
	public Object[][] callMethod() throws IOException{
		return DataProviderTest.startMethod();
	}
	
	@Test(dataProvider = "ThisData", dataProviderClass = ExcelLink.class)
	public void executeMeMethod(String Make, String Engine_Performance , String Date_of_Manufacture ,
			String Number_of_Seats, String Fuel_Type, String List_Price, String License_Plate_Number , String 
			Annual_Mileage, String Right_Hand_Drive) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://sampleapp.tricentis.com/101/app.php");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		
		driver.findElement(By.xpath("//*[@id='make']")).sendKeys(Make);
		driver.findElement(By.xpath("//*[@id='engineperformance']")).sendKeys(Engine_Performance);
		driver.findElement(By.xpath("//*[@id='dateofmanufacture']")).sendKeys(Date_of_Manufacture);
		driver.findElement(By.xpath("//*[@id='numberofseats']")).sendKeys(Number_of_Seats);
		driver.findElement(By.xpath("//*[@id='fuel']")).sendKeys(Fuel_Type);
		driver.findElement(By.xpath("//*[@id='listprice']")).sendKeys(List_Price);
		driver.findElement(By.xpath("//*[@id='licenseplatenumber']")).sendKeys(License_Plate_Number);
		driver.findElement(By.xpath("//*[@id='annualmileage']")).sendKeys(Annual_Mileage);
		
		if(Right_Hand_Drive.contains("Yes")) {
			driver.findElement(By.xpath("//*[@id='righthanddriveyes']/following-sibling::span")).click();
			
		}else {
			driver.findElement(By.xpath("//*[@id='righthanddriveno']/following-sibling::span")).click();
		}
	}

}

