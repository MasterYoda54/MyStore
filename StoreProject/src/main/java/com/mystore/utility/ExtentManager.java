/**
 * 
 */
package com.mystore.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * 
 */
public class ExtentManager {
	
	    // this HTML file 
		public static ExtentSparkReporter htmlReporter;
		// it iwll build the report
		public static ExtentReports extentReports;
		// it defines test
		public static ExtentTest extentTest;
		
		public static void setExtenet() {
			
			htmlReporter = new ExtentSparkReporter("ExtentReport.html");
			
//			htmlReporter.config().setDocumentTitle("Automation Test Report");
//			htmlReporter.config().setReportName("My Store Project Automation Report Test");
//			htmlReporter.config().setTheme(Theme.STANDARD);
//			
			
			extentReports= new ExtentReports();
			extentReports.attachReporter(htmlReporter);
			
			extentReports.setSystemInfo("ProjectName", "My Store Project");
			extentReports.setSystemInfo("Tester", "Servesh");
			extentReports.setSystemInfo("OS", "macOS");
			extentReports.setSystemInfo("Browser", "Chrome");
			
		}
		
		public static void EndReport() {
	// this will close the report 		
			extentReports.flush();
			
		}
		


}
