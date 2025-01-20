package ComTestPackage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LinkCheck {
	
	static WebDriver driver;
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static XSSFRow row;
	static XSSFCell cell;
	public static ArrayList<String> array;

	public static void main(String[] args) throws IOException {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		List<WebElement> getTag = driver.findElements(By.tagName("a"));
		System.out.println(getTag.size());
		
		ArrayList<String> store = new ArrayList<String>();
		ArrayList<String> array = new ArrayList<String>();
		
		for(WebElement i: getTag) {
			String link = i.getAttribute("href");
			apiLinkCall(link, array);
			store.add(link);
		}
		//System.out.println(array);
		excelWrite(array);
		driver.quit();
		
		

	}
	
	public static void apiLinkCall(String link, List<String> array) throws IOException {
		URL url = new URL(link);
		HttpURLConnection urlConnect = (HttpURLConnection) url.openConnection();
		urlConnect.setConnectTimeout(5000);
		urlConnect.connect();
		
		if(urlConnect.getResponseCode() >= 400) {
			//System.out.println(link + "-->" +urlConnect.getResponseMessage());
			array.add(link + "-->" +urlConnect.getResponseMessage());
		}else {
			System.out.println(link + "-->" +urlConnect.getResponseMessage());
			array.add(link + "-->" +urlConnect.getResponseMessage());
		}
		
	}
	
	public static void excelWrite(List<String> output) throws IOException {
		
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet("Sheet1");
		
		
		for(int i=0 ; i<output.size(); i++) {
			row = sheet.createRow(i);
			for(String value : output) {
			row.createCell(0).setCellValue(value);
		}
		}
		
		
		
		
		FileOutputStream fis = new FileOutputStream("ExcelRead.xlsx");
		workbook.write(fis);
		workbook.close();
	}

}
