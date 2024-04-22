/**
 * 
 */
package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.mystore.basepage.BasePage;

/**
 * //did not used the custom action driver isdisplayed method but 
	//used the one which is presnt in webdriver default 1 
 */
public class AccountPage  extends BasePage{
	
	
	@FindBy(xpath = "//span[contains(text(),'Order history and details')]")
		WebElement orderhistory;
	
		
	public AccountPage() {
		PageFactory.initElements(driver, this);
	}
	//did not used the custom action driver isdisplayed method but 
	//used the one which is presnt in webdriver default 1 
	public boolean vlaidateOrderHistory() {
		//running using default isdisplayed but not with the custom
		return orderhistory.isDisplayed();
	}
	
	public String currentUrl() {
		String AccountPageURL=driver.getCurrentUrl();
		System.out.println(AccountPageURL);
		return AccountPageURL;
		
	}
	
}

