package com.mindtree.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.appUIStrore.AllOfItLocators;

public class AllOfIt {
	
	public WebDriver driver;
	
	public AllOfIt(WebDriver driver) {
		this.driver=driver;
	}
	
	
	public WebElement getproduct() {
		return driver.findElement(AllOfItLocators.firstproduct);
	}
	

}
