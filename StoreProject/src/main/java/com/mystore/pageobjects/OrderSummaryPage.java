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
public class OrderSummaryPage extends BasePage {
	
	@FindBy(xpath = "//span[contains(text(),'I confirm my order')]")
	WebElement confirmOder;
	
	public OrderSummaryPage() {
		PageFactory.initElements(driver, this);
		
	}
	public OrderConfirmataionPage confirmOrderClick() {
		action.click(driver, confirmOder);
		return new OrderConfirmataionPage();
		
	}

}
