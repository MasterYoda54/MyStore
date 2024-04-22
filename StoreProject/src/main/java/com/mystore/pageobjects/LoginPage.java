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

public class LoginPage extends BasePage{
	

	
	@FindBy(xpath = "//input[@id='email_create']")
	WebElement emailforNewAccount;
	
	@FindBy(css  = "button[id='SubmitCreate'] span")
	WebElement Createsubtbtn;
	
	@FindBy(xpath  = "//input[@id='email']")
	WebElement email;
	
	@FindBy(xpath = "//input[@id='passwd']")
	WebElement password;
	
	@FindBy(id = "SubmitLogin")
	WebElement loginbtn;
	
	
	
	
	
	public LoginPage () {
		PageFactory.initElements(driver, this);
		
	}
 //this is how we login using email and password	
	public AccountPage Login(String uname,String userpassword) {
	
	action.type(email,uname);
	action.type(password, userpassword);
	action.click(driver, loginbtn);
	
//after clickng on login btn it will take us to homepage 
	return new AccountPage();
	}
 //had to create this method when user is logged in and proceeds to checkout
	//then it will lead the user to the addresspage
	public AddressPage Login1(String uname1,String pwsd1) {
		action.type(email,uname1);
		action.type(password, pwsd1);
		action.click(driver, loginbtn);
	//after clickng on login btn it will take us to homepage 
		return new AddressPage();
		
		}
	
	    public String curUrl() {
	    	return driver.getCurrentUrl();
		  
	}
	
	public AccountCreationPage createAccnt(String newEMail) {
		action.type(emailforNewAccount,newEMail);
		action.click(driver, Createsubtbtn);
		return new AccountCreationPage();
	}
	
	
	

}
