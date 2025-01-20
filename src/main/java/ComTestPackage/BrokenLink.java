package ComTestPackage;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLink {
	public static WebDriver driver;

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		List<WebElement> anchor = driver.findElements(By.tagName("a"));
		System.out.println(anchor.size());
		ArrayList<String> store = new ArrayList<>();
		
		for(WebElement i : anchor) {
			String getLink = i.getAttribute("href");
			store.add(getLink);
			URLTest(getLink);
			
			
		}
		driver.quit();

	}
	
	public static void URLTest(String getLink) throws IOException {
		URL check = new URL(getLink);
		HttpURLConnection connectTest = (HttpURLConnection) check.openConnection();
		connectTest.setConnectTimeout(5000);
		connectTest.connect();
		
		if(connectTest.getResponseCode() >=400) {
			System.out.println(getLink+ " --> " +connectTest.getResponseMessage());
		}else {
			System.out.println(getLink+ " --> " +connectTest.getResponseMessage());
		}
	}

}
