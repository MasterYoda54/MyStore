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
public class AddToCartPage extends BasePage {
//	
	@FindBy(id  = "quantity_wanted")
	WebElement Quantity;
	
	@FindBy(xpath ="//select[@id='group_1']")
	WebElement Size;
	
//	@FindBy(xpath = "//span[contains(text(),'Add to cart')]")
//	WebElement AddToCartBtn;
	
	@FindBy(xpath = "//span[contains(text(),'Add to cart')]")
	WebElement addToCart;
//	
	@FindBy(xpath = "//i[@class='icon-check']")
	WebElement vladidateBtn;
	
	@FindBy(xpath = "(//span[contains(text(),'Proceed to checkout')])[2]")
	WebElement clickOnCheckOutBtn;
	
	@FindBy(css = "a[title='Proceed to checkout'] span")
	WebElement checkoutBtn;
	
	
	
	
//	// now i have to initialize all the webelements
	public  AddToCartPage() {
		PageFactory.initElements(driver,this);
	}
		
	
	public void selectQuantity(String noOfQuantity) {
		action.type(Quantity, noOfQuantity);
	}
//		
	public void selectSize(String sizeOfDress) {
		//action.fluentWait(driver, Size, 10);
//this method is for selecteing size in actiondriver class custom made	
		
		action.selectByVisibleText(sizeOfDress, Size);	}
	
//	public void clickOnAddtocart() {
//		action.fluentWait(driver, AddToCartBtn, 6);
//		action.click(driver, AddToCartBtn);
//	}
	
	public void addToCart() {
		action.click(driver, addToCart);
	}
	
	public boolean vlidateAddTo(){
		return action.isDisplayed(driver, vladidateBtn);
	}
	
	public OrderPage clickOnCheckOut(){
		action.fluentWait(driver, checkoutBtn, 2);
	//to click on this elemenet we need js click method refer action driver class	
		action.jsClick(driver, checkoutBtn);
		return new OrderPage();
	}
	
	public LoginPage ProceedToCheckOut() {
		action.fluentWait(driver, clickOnCheckOutBtn, 2);
		action.jsClick(driver, clickOnCheckOutBtn);
		return new LoginPage();
	}

	
}
