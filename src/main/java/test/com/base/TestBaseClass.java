package test.com.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBaseClass {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public TestBaseClass() {
		prop = new Properties();
		try {
		FileInputStream IOstream = new FileInputStream("C:\\Users\\sagar\\eclipse-workspace\\demoShop\\src\\"
				+ "main\\resources\\demoShop\\demoshop.properties");
		
		try {
			prop.load(IOstream);
		}
		catch(IOException e) {
			System.out.println("file not found");
			e.printStackTrace();
		}
		}catch(FileNotFoundException e){
			e.printStackTrace();
			
		}
	
	}
	
	public static void initializationOfBase() {
		if(prop.getProperty("browser").equals("chrome")){
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get(prop.getProperty("url"));
	}
}
