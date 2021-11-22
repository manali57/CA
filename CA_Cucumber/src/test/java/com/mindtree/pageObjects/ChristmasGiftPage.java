package com.mindtree.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.appUIStrore.ChristmasGiftPageLocators;

public class ChristmasGiftPage {
	
	WebDriver driver = null;
    
    public ChristmasGiftPage(WebDriver driver)
    {
 	   this.driver = driver;
    }
	
    public WebElement getFirstproduct() {
		return driver.findElement(ChristmasGiftPageLocators.firstproduct);
	}
	
    public WebElement getAddtocart() {
		return driver.findElement(ChristmasGiftPageLocators.addtocart);
	}
    
    public WebElement getVerifyproduct() {
		return driver.findElement(ChristmasGiftPageLocators.verifyproduct);
	}
    
    public WebElement getCheckout() {
		return driver.findElement(ChristmasGiftPageLocators.checkout);
	}
    
    public WebElement Closepopup() {
		return driver.findElement(ChristmasGiftPageLocators.closepopup);
	}
    
    public WebElement getReturntocart() {
		return driver.findElement(ChristmasGiftPageLocators.returntocart);
	}



	
    
    
	

}
