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
public class OrderPage extends BasePage {
	
	@FindBy(xpath = "//li[@class='price']")
	WebElement unitPrice;
	
	@FindBy(xpath = "(//span[@id='total_price'])[1]")
	WebElement totalPrice;
	
	@FindBy(xpath = "//span[text()='Proceed to checkout']")
	WebElement proceedToChechout;
	
	
	public OrderPage() {
		PageFactory.initElements(driver, this);
	}
	
	public double getUnitPrice() {
		String UP=unitPrice.getText();
//[^a-zA-Z0-9] used to remove $ sign
//String textWithoutDollars = text.replaceAll("\\$", ""); this can also be used		
		String unit = UP.replaceAll("[^a-zA-Z0-9]", "");
//converted unitwhich is string into double	
// his could throw exception cuase it is for only floating data menaing with decimals
		double UnitPrice=Double.parseDouble(unit);
// use divide   to /100 to get your data in decimals if itb was before [refer (2:18)video]
		return UnitPrice;	
	}
	
	
	public double getTotalPrice() {
		String TP=totalPrice.getText();
//[^a-zA-Z0-9] used to remove $ sign
//String textWithoutDollars = text.replaceAll("\\$", ""); this can also be used		
		String ftp = TP.replaceAll("[^a-zA-Z0-9]", "");
//converted unit which is string into double	
// his could throw exception cuase it is for only floating data meaning with decimals
		double TotalPrice=Double.parseDouble(ftp);
// use divide   to /100 to get your data in decimals if itb was before [refer (2:18)video]
		return TotalPrice;
	}
	
	public LoginPage ClickOnCheckout() {
		action.click(driver, proceedToChechout);
		return  new LoginPage();
		//check login page some changes i ahve done refer to it
	}
	
	
	
	
	
	
}


