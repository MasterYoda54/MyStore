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
public class OrderConfirmataionPage extends BasePage {
	
	@FindBy(xpath = "//p[contains(text(),'Your order on My Shop is complete')]")
	WebElement orderComplete;
	
	public OrderConfirmataionPage() {
		PageFactory.initElements(driver, this);
		
	}
	
	public String validateConfirmedOrder() {
		String Msg = orderComplete.getText();
		return Msg;
		
		
	}

}
