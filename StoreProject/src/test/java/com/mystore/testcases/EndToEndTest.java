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
import com.mystore.pageobjects.AddressPage;
import com.mystore.pageobjects.IndexPage;
import com.mystore.pageobjects.LoginPage;
import com.mystore.pageobjects.OrderConfirmataionPage;
import com.mystore.pageobjects.OrderPage;
import com.mystore.pageobjects.OrderSummaryPage;
import com.mystore.pageobjects.PaymentPage;
import com.mystore.pageobjects.SearchResultPage;
import com.mystore.pageobjects.ShippingPage;

/**
 * done all the issues fixed by me only
 */
public class EndToEndTest extends BasePage{
	
	IndexPage indexPage;
	LoginPage loginPage;
	SearchResultPage searchResultPage;
	AddToCartPage addToCartPage;
	OrderPage orderPage;
	AddressPage addressPage;
	ShippingPage shippingPage;
	PaymentPage paymentPage;
	OrderSummaryPage orderSummaryPage;
	OrderConfirmataionPage orderConfirmataionPage;
	
	
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
	public void endToEnd() {

	
    searchResultPage=indexPage.searchproduct("blouse");
	searchResultPage.listview();
	addToCartPage=searchResultPage.clickmore();
	addToCartPage.selectSize("L");
	addToCartPage.selectQuantity("2");
	addToCartPage.addToCart();
	addToCartPage.clickOnCheckOut();
	loginPage=addToCartPage.ProceedToCheckOut();
	
	addressPage=loginPage.Login1(prop.getProperty("username"), prop.getProperty("password"));
	shippingPage=addressPage.Proceedtocheckout();
	shippingPage.clickOnTerms();
	paymentPage=shippingPage.clickOnProceedToCheckOut();
	orderSummaryPage=paymentPage.payMethod();
	orderConfirmataionPage=orderSummaryPage.confirmOrderClick();
	String actualMSG=orderConfirmataionPage.validateConfirmedOrder();
	String expectedMSGString="Your order on My Shop is complete.";
	AssertJUnit.assertEquals(actualMSG, expectedMSGString);

	}
	

}
