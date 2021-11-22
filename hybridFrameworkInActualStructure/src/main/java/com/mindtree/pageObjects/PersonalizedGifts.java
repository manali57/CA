package com.mindtree.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.appUIStrore.PersonalizedGiftsLocators;

public class PersonalizedGifts {
	
	public WebDriver driver;
	
	
	
	
	public PersonalizedGifts(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver ;
	}

	public WebElement getsortby() {
		return driver.findElement(PersonalizedGiftsLocators.sortby);
	}
	
	public WebElement gethightolow() {
		return driver.findElement(PersonalizedGiftsLocators.hightolow);
	}
	
	public WebElement getmaxprice() {
		return driver.findElement(PersonalizedGiftsLocators.maxprice);
	}


}
