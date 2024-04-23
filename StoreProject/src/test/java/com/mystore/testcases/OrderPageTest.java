/**
 * 
 */
package com.mystore.testcases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.basepage.BasePage;
import com.mystore.pageobjects.AddToCartPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.SearchResultPage;

/**All functions are working properly
 * fix listview and click more method
 * 
 */
public class OrderPageTest extends BasePage {
	
	
	IndexPage indexPage;

	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	
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
	
	@Test(groups = "Regression")
	public void VerifyTotalPrice() {

	searchResultPage=indexPage.searchproduct("blouse");
	searchResultPage.listview();
	addToCartPage=searchResultPage.clickmore();
	addToCartPage.selectSize("L");
	addToCartPage.selectQuantity("2");
	addToCartPage.addToCart();
	orderPage=addToCartPage.clickOnCheckOut();
	Double unitprice =orderPage.getUnitPrice();
	System.out.println(unitprice);
	Double totalprice =orderPage.getTotalPrice();
	System.out.println(totalprice);
	Double totalexpectedprice=(unitprice*2)+7;
	System.out.println(totalexpectedprice);
	AssertJUnit.assertEquals(totalexpectedprice, totalprice);
	
	}

}
