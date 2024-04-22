/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Actiondriver;
import com.mystore.basepage.BasePage;

/**
 * 
 */
public class AccountCreationPage extends BasePage {
	Actiondriver action = new Actiondriver();
//not sure bt this xpath wheteher it is right or not 	
	@FindBy(xpath = "//h1[@class='page-heading']")
	WebElement AccountCreationPageHeader;
	
	//this is how i initialized all the objects above
	public  AccountCreationPage() {
	PageFactory.initElements(AccountCreationPageHeader, this);
	
	}
	
	public boolean validatePageHeader() {
		return action.isDisplayed( driver, AccountCreationPageHeader);
		 
		
		}

}
