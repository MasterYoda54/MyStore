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
public class ListenersClass extends ExtentManager implements ITestListener{
	
	Actiondriver actiondriver= new Actiondriver();
	
		@Override
		public void onTestStart(ITestResult result) {
			extentTest = extentReports.createTest(result.getName());
		}

		@Override
		public void onTestSuccess(ITestResult result) {
			if (result.getStatus() == ITestResult.SUCCESS) {
				extentTest.log(Status.PASS, "Pass Test Case is :: " + result.getName());
			}
		}

		@Override
		public void onTestSkipped(ITestResult result) {
			if (result.getStatus() == ITestResult.SUCCESS) {
				extentTest.log(Status.PASS, "Pass Test Case is :: " + result.getName());
			}
		}
		
		@Override
		public void onTestFailure(ITestResult result) {
			if(result.getStatus()==ITestResult.FAILURE) {
				extentTest.log(Status.FAIL, 
				MarkupHelper.createLabel(result.getName()+"Test case Is Failed", ExtentColor.RED));
				extentTest.log(Status.FAIL, 
				MarkupHelper.createLabel(result.getThrowable()+"Test Case Is Failed", ExtentColor.RED));
			String image=actiondriver.screenShot(BasePage.getdriver(), result.getName());
			extentTest.fail("screenShot is Attached>>::",MediaEntityBuilder.createScreenCaptureFromPath(image).build());
			
			}
			

			
		}

}
