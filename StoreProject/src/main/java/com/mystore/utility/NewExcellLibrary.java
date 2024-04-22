/**
 * 
 */
package com.mystore.utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import io.opentelemetry.sdk.metrics.data.Data;

/**
 * 
 */
public class NewExcellLibrary {
	
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	
	@Test
	public void readExcel() throws Exception   {

    String ExcelPath="/Users/servesh/eclipse-workspace/StoreProject/src/main/resources/TestData/TestData.xlsx";
	
    
      String fileName="TestData";
      String SheetName="Test1";
      
      //created object of file to get excel path 
      File file = new File(ExcelPath);
      
     // To read the file  
      FileInputStream fis= new FileInputStream(file);
    // to get the excel   
       wb= new XSSFWorkbook(fis);
      
      
      //i have called getsheet method wich has retured XSSFSheet object
       sheet=wb.getSheet(SheetName);

   
       int LN=sheet.getLastRowNum();
       System.out.println("Last row Number::"+LN );
    
       
       String rowdata =sheet.getRow(0).getCell(1).getStringCellValue();   
       System.out.println(rowdata);
       
       for(int i=0; i<=LN; i++) {
    	 Row row=sheet.getRow(i);
    	 
    	 for(int j=0; j<row.getLastCellNum();j++) {
    		 String data1 =sheet.getRow(i).getCell(j).getStringCellValue();
    		 System.out.print(data1+"  ");
    		 
    	 }
    	 System.out.println();
    	   
       }
       
       wb.close();
       
	}
	

	
	

}
