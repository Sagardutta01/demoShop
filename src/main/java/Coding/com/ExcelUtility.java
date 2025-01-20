package Coding.com;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public static FileInputStream io;
	public static FileOutputStream oi;
	public static XSSFWorkbook workbook;
	public static XSSFSheet sheet;
	public static XSSFRow currentrow;
	public static XSSFCell currentcell;
	public static Scanner scan;
	
	public static int getrowcount(String path,String name) throws IOException {
	
		 io = new FileInputStream(path);
		 workbook = new XSSFWorkbook(io);
		 XSSFSheet sheet = workbook.getSheet(name);
		 int rowcount = sheet.getLastRowNum();
		 workbook.close();
		 io.close();
		 return rowcount;
	}
	public static int getcellcount(String path, String name) throws IOException {
		
		 io = new FileInputStream(path);
		 workbook = new XSSFWorkbook(io);
		 XSSFSheet sheet = workbook.getSheet(name);
		 int rowcount = sheet.getLastRowNum();
		 int cellcount = sheet.getRow(0).getLastCellNum();
		 workbook.close();
		 io.close();
		 return cellcount;
	}
	
	public static void readcell(String path, int row , int cell , String name) throws IOException {
		
		io = new FileInputStream(path);
		workbook = new XSSFWorkbook(io);
		sheet = workbook.getSheet(name);
	
		for(int i=0;i<=row;i++) {
		 currentrow = sheet.getRow(i);
		 for(int j=0;j<cell;j++) {
			currentcell = currentrow.getCell(j);
			String cellvalue = currentcell.toString();
			System.out.print(cellvalue+"\t");
		}
		System.out.println();
		workbook.close();
		io.close();

		}
	}
	
	public static void writecell(String path,String name) throws IOException {
		oi = new FileOutputStream(path);
		workbook = new XSSFWorkbook();
		sheet = workbook.createSheet(name);
		Scanner scan = new Scanner(System.in);
		
		System.out.println("pls enter no of rows ");
		int row = scan.nextInt();
		System.out.println("pls enter no of cells ");
		int cell = scan.nextInt();
		
		for(int i=0;i<=row;i++) {
			currentrow = sheet.createRow(i);
			for(int j=0;j<cell; j++) {
				currentcell = currentrow.createCell(j);
				currentcell.setCellValue(scan.next());
			}
		}
		System.out.println("Done");
		workbook.write(oi);
		workbook.close();
			
	}
	
}