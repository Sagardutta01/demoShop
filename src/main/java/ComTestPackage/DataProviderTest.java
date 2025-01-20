package ComTestPackage;

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

public class DataProviderTest {
	static XSSFWorkbook workbook;
	static XSSFSheet sheet;
	static XSSFRow row;
	static XSSFCell cell;
	static FileInputStream io;
	
		public static Object[][] startMethod() throws IOException{
			io = new FileInputStream("C:\\Users\\sagar\\eclipse-workspace\\demoShop\\EnterData.xlsx");
			workbook = new XSSFWorkbook(io);
			sheet = workbook.getSheet("Sheet1");
			int rows = sheet.getLastRowNum();
			int cells = sheet.getRow(0).getLastCellNum();
			
			Object [][] object = new Object[rows][cells];
			
			for(int i=1; i<=rows; i++) {
				row = sheet.getRow(i);
				for(int j=0; j<cells; j++) {
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
							object[i-1][j] = String.valueOf((int)cell.getNumericCellValue());
							break;
							
							default:
								object[i-1][j]="";
								break;
						}
						
						
					}else {
						
							object[i-1][j]="";
							break;
					}
				}
			}
			
			
			io.close();
			workbook.close();
			return object;
			
		}

}
