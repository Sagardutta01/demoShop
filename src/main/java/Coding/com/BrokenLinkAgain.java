package Coding.com;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BrokenLinkAgain {

    

    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com/");
        driver.manage().window().maximize();

        List<WebElement> list = driver.findElements(By.tagName("a"));
        System.out.println(list.size());

        ArrayList<String> store = new ArrayList<>();
        ArrayList<String> output = new ArrayList<>();

        for (WebElement i : list) {
            String saveLink = i.getAttribute("href");
            store.add(saveLink);
        }

        store.parallelStream().forEach(e -> URLtest(e, output));

        writeToExcel(output, "BrokenLinks.xlsx", "Sheet1");

        driver.quit();
    }

    public static void writeToExcel(List<String> data, String path, String sheetName) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet(sheetName);

        for (int i = 0; i < data.size(); i++) {
            Row row = sheet.createRow(i);
            row.createCell(0).setCellValue(data.get(i));
        }

        try (FileOutputStream fileOut = new FileOutputStream(path)) {
            workbook.write(fileOut);
            System.out.println("Excel file created successfully at " + path);
        }
        workbook.close();
    }
    
    public static void URLtest(String link, List<String> output) {
        try {
            URL testurl = new URL(link);
            HttpsURLConnection urlConnection = (HttpsURLConnection) testurl.openConnection();
            urlConnection.setConnectTimeout(5000);
            urlConnection.connect();
            
            if(urlConnection.getResponseCode() >= 400) {
                output.add(link + " ---> " + urlConnection.getResponseMessage());
            } 
            else {
                output.add(link + " ---> " + urlConnection.getResponseMessage());
            }
        } catch (IOException e) {
            output.add(link + " ---> Error: " + e.getMessage());
        }
    }
}
