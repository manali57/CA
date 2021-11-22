package com.mindtree.pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.appUIStrore.HomePageLocators;
import java.util.List;

public class HomePage {
	
    private static final String List = null;
	WebDriver driver = null;
    
    public HomePage(WebDriver driver)
    {
 	   this.driver = driver;
    }
    
    public WebElement getSignIn()
    {
 	   return driver.findElement(HomePageLocators.signIn);
    }
    
    public WebElement getPersonalizedgift()
    {
 	   return driver.findElement(HomePageLocators.personalizedgift);
    }
    
    public WebElement getChristmasgift()
    {
 	   return driver.findElement(HomePageLocators.christmasgift);
    }
    
    public WebElement getShopbycategory()
    {
    	List<WebElement> List=driver.findElements(HomePageLocators.shopbycategory);
		return List.get(3);
    }
    
    public WebElement getAllofit()
    {
 	   return driver.findElement(HomePageLocators.allofit);
    }
    
    public WebElement getWishList()
    {
 	   return driver.findElement(HomePageLocators.wishlist);
    }
    
    public WebElement getAboutus()
    {
 	   return driver.findElement(HomePageLocators.aboutus);
    }
    
    public WebElement getGiftcard()
    {
 	   return driver.findElement(HomePageLocators.giftcard);
    }
}