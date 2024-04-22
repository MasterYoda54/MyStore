package com.mystore.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.bouncycastle.oer.its.ieee1609dot2.basetypes.PublicEncryptionKey;

public class ExcellLibrary {
	
	
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	public ExcellLibrary() throws IOException   {
		
		
      String ExcelPath="/Users/servesh/eclipse-workspace/StoreProject/src/main/resources/TestData/TestData.xlsx";

      File file = new File(ExcelPath);

      FileInputStream fis= new FileInputStream(file);

        wb= new XSSFWorkbook(fis);    

	}
	//this is seperate method to read the data  
	public String ReadData(String sheetName,int Row, int Colum) {
	
		sheet=wb.getSheet(sheetName);
		String data=sheet.getRow(Row).getCell(Colum).getStringCellValue();
		return data ;

		
	}
	
	
	

}
