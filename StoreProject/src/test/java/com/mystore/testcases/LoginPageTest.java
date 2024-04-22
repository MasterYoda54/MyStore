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
import com.mystore.pageobjects.AccountPage;

import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;

/**
 * //!!!!!test is failing idk y
	//fucking took me more than 5 hours wtf 
 */
public class LoginPageTest extends BasePage{
 //these are class objects declared at the class level 
	IndexPage indexPage;
	LoginPage loginPage;
	AccountPage accountPage;
	
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
	
	
	@Test
	public void LoginTest() {
		indexPage=new IndexPage();
		loginPage=indexPage.clickOnSignIn();
		accountPage=loginPage.Login(prop.getProperty("username"),prop.getProperty("password"));
		String actualrl = accountPage.currentUrl();
		System.out.println(actualrl);
		String expectedURL ="http://www.automationpractice.pl/index.php?controller=my-account";
		AssertJUnit.assertEquals(actualrl,expectedURL );
//after giving uname and pwd and clicking signin it will return or land us on accountPage 

	}

	
}
