package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.actiondriver.Actiondriver;
import com.mystore.basepage.BasePage;

public class SearchResultPage extends BasePage {
	Actiondriver action = new Actiondriver();
	@FindBy(xpath = "//a[@class='product_img_link']//img[@class='replace-2x img-responsive']")
	WebElement serachedProductResult;
	
	@FindBy(xpath = "//i[@class='icon-th-list']")
	WebElement Listview;
	
	@FindBy(xpath = "//span[contains(text(),'More')]")
	WebElement clickonMore;
	
	
	
	
	public SearchResultPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean ProductAvailability() {
		return action.isDisplayed(driver, serachedProductResult);	}
	
//	public AddToCartPage clickOnProdcut() {
//	action.click(driver, serachedProductResult);
//	return new AddToCartPage();
//	}
	
	public void listview() {
		action.click(driver, Listview);
	}
	public AddToCartPage clickmore() {
	 action.click(driver, clickonMore);
	 return new AddToCartPage();
		
	}
	
	
	
	}


