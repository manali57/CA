package com.mindtree.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.appUIStrore.SignInPageLocators;

public class SignInPage {

    WebDriver driver = null;
    
    public SignInPage(WebDriver driver)
    {
 	   this.driver = driver;
    }
    
    
    public WebElement getEmail()
    {
 	   return driver.findElement(SignInPageLocators.email);
    }
    
    public WebElement getPassword()
    {
 	   return driver.findElement(SignInPageLocators.password);
    }
    
  


	public WebElement getSignInSmmitButton() {
		// TODO Auto-generated method stub
		return driver.findElement(SignInPageLocators.Submit);
	}
    
}