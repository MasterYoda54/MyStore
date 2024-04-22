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
public class PaymentPage extends BasePage {
	
	
	@FindBy(xpath = "//a[contains(text(),'Pay by bank wire')]")
	WebElement payByWire;
	
	@FindBy(xpath = "//a[contains(text(),'Pay by check')]")
	WebElement payByCheck;
	
	public PaymentPage() {
		PageFactory.initElements(driver, this);
	}
 
	public OrderSummaryPage payMethod() {
		action.click(driver, payByWire);
		return new OrderSummaryPage();
	}
}

