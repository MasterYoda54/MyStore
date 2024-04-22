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
import com.mystore.pageobjects.AccountCreationPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

/**
 * 
 */
public class AccountCreationPageTest extends BasePage {
	
	IndexPage indexPage;
	LoginPage loginPage;
	AccountCreationPage accountCreationPage;
	
	@Parameters("browser")
	@BeforeMethod(groups = {"Smoke","Sanity","Regression"})
	public void setup(String browser) {
		loadActionDriver();
		launchApp(browser);
		indexPage=new IndexPage();
	}
	@AfterMethod(groups = {"Smoke","Sanity","Regression"})										
	public void teardownTest() {
		driver.quit();
	}
	@Test(groups= "Sanity")
	public void verifyAccntCreationPageTest() {
		loginPage=indexPage.clickOnSignIn();
		accountCreationPage=loginPage.createAccnt("dota@gmail.com");
		boolean result=accountCreationPage.validatePageHeader();
		Assert.assertTrue(result);
		
	}
	

}
