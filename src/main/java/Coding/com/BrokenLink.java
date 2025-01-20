package Coding.com;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLink {
	
	public static void URLtest(String link) {
		try {
			URL testurl = new URL(link);
			HttpsURLConnection urlConnection = (HttpsURLConnection) testurl.openConnection();
			urlConnection.setConnectTimeout(5000);
			urlConnection.connect();
			
			if(urlConnection.getResponseCode() >= 400) {
				System.out.println(link + "---> " + urlConnection.getResponseMessage());
			} 
			else {
				System.out.println(link + "---> " + urlConnection.getResponseMessage());
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		List<WebElement> list = driver.findElements(By.tagName("a"));
		System.out.println(list.size());
		
		ArrayList<String> store = new ArrayList<String>();
		
		for (WebElement i : list) {
			String saveLink = i.getAttribute("href");
			//URLtest(saveLink);// one by one test for slow response
			store.add(saveLink);
			
		}
		store.parallelStream().forEach(e -> URLtest(e));// parallel execution for fast response
		String path = "C:\\Users\\sagar\\eclipse-workspace\\demoShop\\src\\main\\java\\Coding\\com\\excel.xls";
		ExcelUtility.writecell(path, "Sheet1");

		driver.quit();
		}
}



