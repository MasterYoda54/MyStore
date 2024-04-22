/**
 * 
 */
package com.mystore.testcases;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.basepage.BasePage;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.SearchResultPage;

/**
 * not selecting size or value from drop down
 * had to change view method 
 */
public class AddToCartPageTest extends BasePage{
	
	IndexPage indexPage;
	
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;

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
	
	@Test(groups= {"Regression","Sanity"})
	public void AddToCartTest() {
		searchResultPage=indexPage.searchproduct("blouse");
		searchResultPage.listview();
		addToCartPage=searchResultPage.clickmore();
		//addToCartPage=searchResultPage.clickOnProdcut();
		addToCartPage.selectSize("L");
		addToCartPage.selectQuantity("2");
		//addToCartPage=searchResultPage.clickOnProdcut();
		addToCartPage.addToCart();
		boolean result1=addToCartPage.vlidateAddTo();
        Assert.assertTrue(result1);
		
		
	}
	
	
	
}
