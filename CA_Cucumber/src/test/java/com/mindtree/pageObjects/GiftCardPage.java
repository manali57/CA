package com.mindtree.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.appUIStrore.GiftCardPageLocators;



public class GiftCardPage {
	
public WebDriver driver;
	
	public GiftCardPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement getAddtocart() {
		return driver.findElement(GiftCardPageLocators.addtocart);
	}
	
	public WebElement getCartproduct() {
		return driver.findElement(GiftCardPageLocators.cartproduct);
	}
	
}
