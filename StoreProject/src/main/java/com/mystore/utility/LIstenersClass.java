/**
 * 
 */
package com.mystore.utility;


import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;


import com.mystore.actiondriver.Actiondriver;
import com.mystore.basepage.BasePage;

/**
 * 
 */
public class LIstenersClass extends ExtentManager implements ITestListener{
	
	Actiondriver actiondriver= new Actiondriver();
	
	
	
	public void onTeststart(ITestResult	 result) {
		extentTest = extentReports.createTest(result.getName());
	}
		
		public void OnTestSuccess(ITestResult result) {
			if(result.getStatus()==ITestResult.SUCCESS) {
				extentTest.log(Status.PASS,"Passed Test case is::"+ result.getName());
			}
		}
			
			
			public void onTestFailure(ITestResult result) {
				
			if(result.getStatus()== ITestResult.FAILURE) {
			extentTest.log(Status.FAIL,
				MarkupHelper.createLabel(result.getName()+"Test case is failed", ExtentColor.RED));
			
			extentTest.log(Status.FAIL,
				MarkupHelper.createLabel(result.getThrowable()+"Test case is failed", ExtentColor.RED));
			
			String image =actiondriver.screenShot(BasePage.getdriver(), result.getName());
     extentTest.fail("screenshot is attached::", MediaEntityBuilder.createScreenCaptureFromPath(image).build());
    

			}}
			
			public void onSkipOfTest(ITestResult result) {
				if(result.getStatus()==ITestResult.SKIP) {
					extentTest.log(Status.SKIP, "Test is Skipped::"+ result.getName());
					
				}
				
			}
	
}
