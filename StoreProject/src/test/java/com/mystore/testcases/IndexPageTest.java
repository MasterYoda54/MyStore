/**
 * 
 */
package com.mystore.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.basepage.BasePage;
import com.mystore.pageobjects.IndexPage;

/**
 * @Test
	public void validateLogoTest() {
		indexpage.validatelogo();
		 i have doubt in this line
 */
public class IndexPageTest extends BasePage {
	
	IndexPage indexPage;
	
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
	//this Method is called from base page cause when ever in testing 
	//1st we  have to laucnh the application for the test	
		loadActionDriver();
		launchApp(browser);
		indexPage=new IndexPage();
	}
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})										
	public void teardownTest() {
		driver.quit();
	}
	
	@Test(groups="Smoke")
	public void validateLogoTest() {
		boolean result =indexPage.validatelogo();		
		AssertJUnit.assertTrue(result);	
	}
	
	@Test(groups="Smoke")
	public void verifyTitleTest() {
		
		String expectedTitle=indexPage.getTitile();
		AssertJUnit.assertEquals(expectedTitle,"My Shop" );
		
	}
}
	
	


