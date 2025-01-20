package Coding.com;

import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class EnterExcelToField {
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	public static Object [][] getData(String name) throws IOException{
		FileInputStream io = new FileInputStream("C:\\Users\\sagar\\eclipse-workspace\\demoShop\\EnterData.xlsx");
		 workbook = new XSSFWorkbook(io);
		 sheet = workbook.getSheet(name);
		 
		 int rowCount = sheet.getLastRowNum();
		 int cellCount = sheet.getRow(0).getLastCellNum();
		 
		Object [][] object = new Object [rowCount][cellCount];
		
		for(int i=1; i<=rowCount;i++) {
			row = sheet.getRow(i);
			for(int j=0; j<cellCount; j++) {
				cell = row.getCell(j);
				if(cell != null) {
				CellType type = cell.getCellType();
				
				switch(type) {
				case STRING:
					object[i-1][j] = cell.getStringCellValue();
					break;
					
				case NUMERIC:
					if(DateUtil.isCellDateFormatted(cell)) {
						Date date = cell.getDateCellValue();
						SimpleDateFormat simple = new SimpleDateFormat("MM/dd/yyyy");
						object[i-1][j]=simple.format(date);
						break;
						
					}
					object[i-1][j] = String.valueOf((int) cell.getNumericCellValue());
					break;
				default:
                    object[i - 1][j] = "";  
                    break;
				}
				
				}else {
					object[i-1][j] = "";
				}
				
			}
		}
		workbook.close();
		io.close();
		
		return object;
		 
	}

}
