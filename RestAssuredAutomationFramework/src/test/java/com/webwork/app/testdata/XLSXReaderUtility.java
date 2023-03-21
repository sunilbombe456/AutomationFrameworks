package com.webwork.app.testdata;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLSXReaderUtility {

	public static void main(String args[]) throws IOException {
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\SUNIL\\Event-Management-Workspace\\RestAssuredAutomationFramework\\src\\test\\resources\\Configs\\test-data.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = null;
		int sheets = workbook.getNumberOfSheets();
		System.err.println("Execution started");

		for (int i = 0; i < sheets; i++) {
			System.out.println(workbook.getSheetName(i));
			if (workbook.getSheetName(i).equalsIgnoreCase("test-data")) {
				sheet = workbook.getSheetAt(i);
				Iterator<Row> row = sheet.rowIterator();
				Row firstRow = row.next();
				Iterator<Cell> ce = firstRow.iterator();
				int k = 0;
				int column = 0;
				while (ce.hasNext()) {
					Cell value = ce.next();
					if (value.getStringCellValue().equalsIgnoreCase("test-case")) {
						column = k;
					}
					k++;
				}
				System.out.println(column);
				while (row.hasNext()) {
					Row r = row.next();
					if (r.getCell(column).getStringCellValue().equalsIgnoreCase("purchase")) {
						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {
							System.out.println(cv.next().getStringCellValue());
						}
					}

				}
			}
		}

	}

}
