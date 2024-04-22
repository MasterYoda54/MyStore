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
public class AddressPage extends BasePage{

	@FindBy(xpath = "//span[text()='Proceed to checkout']")
	WebElement proceedToCheckOut;
	
	public AddressPage() {
		PageFactory.initElements(driver, this);
	}
	 public ShippingPage Proceedtocheckout() {
		action.click(driver, proceedToCheckOut);
		return new ShippingPage();
		
		
	}
}
