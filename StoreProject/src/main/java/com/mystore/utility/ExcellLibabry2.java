package com.mystore.utility;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcellLibabry2 {
	
	public static String path = "/Users/servesh/eclipse-workspace/StoreProject/src/main/resources/TestData/TestData.xlsx";

	FileInputStream fileInputStream = null;
	Workbook workbook = null;
	Sheet sheet = null;
	Row row = null;
	Cell cell = null;

	public ExcellLibabry2() {
		try {
			fileInputStream = new FileInputStream(path);
			workbook = WorkbookFactory.create(fileInputStream);
			sheet = workbook.getSheetAt(0);
			fileInputStream.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String readData(String sheetName, int row, int column) {
		sheet = workbook.getSheet(sheetName);
		String data = sheet.getRow(row).getCell(column).getStringCellValue();
		return data;
	}

	public Object[][] getCredentials(String sheetName) {
		sheet = workbook.getSheet(sheetName);
		int lastRow = getRowCount(sheetName);
		int lastCol = getColumnCount(sheetName);
		Object[][] obj = new Object[lastRow][lastCol];
		for (int i = 0; i < lastRow; i++) {
			row = sheet.getRow(i + 1);
			for (int j = 0; j < lastCol; j++) {
				cell = row.getCell(j);
				CellType cellType = cell.getCellType();
//				System.out.println(obj[i][j]);
				switch (cellType) {
				case STRING:
					obj[i][j] = cell.getStringCellValue();
					break;
				case NUMERIC:
					obj[i][j] = Integer.toString((int) cell.getNumericCellValue());
					break;
				case BOOLEAN:
					obj[i][j] = cell.getBooleanCellValue();
					break;
				}
			}
		}
		return obj;
	}

//	public Object[][] readSheetData(String sheetName) {
//		sheet = workbook.getSheet(sheetName);
//		int lastRow = getRowCount(sheetName);
//		int lastCol = getColumnCount(sheetName);
//		System.out.println(lastRow);
//		System.out.println(lastCol);
//		Object[][] obj = new Object[lastRow][lastCol]; // for skipping 1st row we are using 1 row less so that there
//														// will not be null value in array
//		for (int i = 0; i < lastRow; i++) {
//			row = sheet.getRow(i + 1);// and here +1 so it reads from 2nd row skipping header
//			for (int j = 0; j < lastCol; j++) {
//				obj[i][j] = row.getCell(j).getStringCellValue();
//			}
//		}
//		return obj;
//	}

	public boolean isSheetExist(String sheetName) {
		int index = workbook.getSheetIndex(sheet);
		if (index == -1)
			return false;
		else
			return true;
	}

	public int getRowCount(String sheetName) {
		if (isSheetExist(sheetName)) {
			sheet = workbook.getSheet(sheetName);
			return sheet.getLastRowNum();
		} else {
			return 0;
		}
	}

	public int getColumnCount(String sheetName) {
		if (isSheetExist(sheetName)) {
			sheet = workbook.getSheet(sheetName);
			row = sheet.getRow(0);
			if (row == null) {
				return 0;
			} else {
				return row.getLastCellNum();
			}
		} else {
			return 0;
		}
	}
}
	


