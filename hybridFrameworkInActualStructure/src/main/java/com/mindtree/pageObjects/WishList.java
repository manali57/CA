package com.mindtree.pageObjects;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.appUIStrore.WishListLocators;



public class WishList {
	

public WebDriver driver;
	
	public WishList(WebDriver driver) {
		this.driver=driver;
	}
	
	public WebElement productvisible() {
		return driver.findElement(WishListLocators.product);
	}
	
	public WebElement closepopup() {
		List<WebElement> list=driver.findElements(WishListLocators.popup);
		return list.get(2);
	}

}
