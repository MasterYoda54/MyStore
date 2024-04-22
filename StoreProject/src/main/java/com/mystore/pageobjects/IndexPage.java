package com.mystore.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import com.mystore.basepage.BasePage;

public class IndexPage extends BasePage  {
	
	
	
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	WebElement logo;
	
	
	@FindBy(xpath = "//input[@id='search_query_top']")
	WebElement searchbox;
	
	@FindBy(xpath = "//button[@class='btn btn-default button-search']")
	WebElement submitbtn;
	
	
	@FindBy(xpath = "//a[@class='login']")
	WebElement signin;

	public IndexPage() {
		    
		PageFactory.initElements(driver,this);
	}

	    public LoginPage clickOnSignIn() {
	     action.click(driver, signin);
	//when we click on clickOnSignIn this will land us on LoginPage in the site thats why return is login page
	// to create object we use the keyword new.     
	     return new LoginPage();
	}
	    
	    public boolean validatelogo() {
	    	 return action.isDisplayed(driver, logo);
	    	
	    }
	    
	    public String getTitile() {
	    	String Storeproject = driver.getTitle();
	//this is return statement    	
			return Storeproject;	
		}
	    
	    public SearchResultPage searchproduct(String productName) {
	    	action.type(searchbox,productName);
	    	action.click(driver, submitbtn);
	//after clicking on search btn it will take us to SearchResultPage    	
			return new SearchResultPage();
			
		}

	    
	      
}

		
	

