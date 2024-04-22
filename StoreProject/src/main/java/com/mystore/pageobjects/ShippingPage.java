/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.basepage.BasePage;

/**
 * 
 */
public class ShippingPage extends BasePage{
	
	@FindBy(id = "uniform-cgv")
	WebElement TermsOfService;
	
	@FindBy(xpath = "//button/span[contains(text(),'Proceed to checkout')]")
	WebElement proceedToCheckOut;
	
	public ShippingPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnTerms () {
		action.click(driver, TermsOfService);
		
	}
	public PaymentPage clickOnProceedToCheckOut() {
		action.click(driver, proceedToCheckOut);
		return new PaymentPage();
		
	}

}
