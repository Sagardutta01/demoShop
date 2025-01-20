package FaceBookBase.com;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FaceBookSuperClass {
	
	public static WebDriver driver;
	public static Properties prop;
	
	public FaceBookSuperClass() {
		
		
		prop = new Properties();
		try {
		FileInputStream io = new FileInputStream("C:\\Users\\sagar\\eclipse-workspace\\demoShop\\"
				+ "Facebook\\FaceBookConfig\\com\\config.properties");
		try {
		prop.load(io);
		}
		 catch (IOException e) {
			// TODO: handle exception
		}
		}
		catch(FileNotFoundException e) {
			
		}
		
		
	}
	
	public static void startbrowser() {
		if(prop.getProperty("browser").equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		}
		
		driver.get(prop.getProperty("URL"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

}
