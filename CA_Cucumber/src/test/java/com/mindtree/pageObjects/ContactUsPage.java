package com.mindtree.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.mindtree.appUIStrore.ContactUsLocators;

public class ContactUsPage {
	
	public WebDriver driver;

	public ContactUsPage(WebDriver driver) {
		this.driver = driver;
	}

	public WebElement getcontactUs() {
		return driver.findElement(ContactUsLocators.contactUs);
	}

	public WebElement getmessage() {
		return driver.findElement(ContactUsLocators.message);
	}

	public WebElement getname() {
		return driver.findElement(ContactUsLocators.name);
	}

	public WebElement getemail() {
		return driver.findElement(ContactUsLocators.email);
	}

	public WebElement getsend() {
		return driver.findElement(ContactUsLocators.send);
	}

	public WebElement gettitle() {
		return driver.findElement(ContactUsLocators.title);
	}

	public WebElement getcontinueshopping() {
		return driver.findElement(ContactUsLocators.continueshopping);
	}

}
