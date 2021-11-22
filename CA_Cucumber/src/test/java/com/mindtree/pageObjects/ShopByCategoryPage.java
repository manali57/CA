package com.mindtree.pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.appUIStrore.ShopByCategoryLocators;

public class ShopByCategoryPage {
	
	WebDriver driver = null;
    
    public ShopByCategoryPage(WebDriver driver)
    {
 	   this.driver = driver;
    }
    
    public WebElement getBirthdaygift()
    {
    	List<WebElement> List=driver.findElements(ShopByCategoryLocators.birthdaygift);
		return List.get(1);
    }
    
    public WebElement getFirstproduct()
    {
 	   return driver.findElement(ShopByCategoryLocators.firstproduct);
    }
    
    public WebElement getAddtowishlist()
    {
 	   return driver.findElement(ShopByCategoryLocators.addtowishlist);
    }
    
    public WebElement getViewwishlist()
    {
 	   return driver.findElement(ShopByCategoryLocators.viewwishlist);
    }
    

}
