package com.mindtree.stepdefinations;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

import com.mindtree.pageObjects.ChristmasGiftPage;
import com.mindtree.pageObjects.HomePage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class ChristmasGiftStepDefination {
	
	Logger log = LogManager.getLogger(ChristmasGiftStepDefination.class.getName());
	static WebDriver driver = null;
	ChristmasGiftPage cg=null;
	
	
	@Given("Get the driver from the SearchProductSD file")
	public void get_the_driver_from_the_search_product_sd_file() {
		driver = SearchProductStepDefiantion.getDriver();
	}
	@Then("click on the Chirstmas Gift seaction on the website")
	public void click_on_the_chirstmas_gift_seaction_on_the_website() {
		HomePage hp = new HomePage(driver);
		hp.getChristmasgift().click();
		
		log.info("Successfully navigated to christmas Gifts...");
	}
	@Then("Click on the first product")
	public void click_on_the_first_product() throws InterruptedException {
		cg=new ChristmasGiftPage(driver);
		cg.getFirstproduct().click();
		Thread.sleep(2000);
	  
	}
	@Then("click on Add to cart")
	public void click_on_add_to_cart() throws InterruptedException {
		cg=new ChristmasGiftPage(driver);
		cg.getAddtocart().click();
		Thread.sleep(500);
		log.info("Added product to Crad...");
		cg.getCheckout().click();
	}
	@Then("close the popup")
	public void close_the_popup() throws InterruptedException {
		cg=new ChristmasGiftPage(driver);
		//if(cg.ClosePopUp().isDisplayed())
		cg.Closepopup().click();
		Thread.sleep(2000);
	}
	@Then("Click on the Return to cart")
	public void click_on_the_return_to_cart() throws InterruptedException {
		cg=new ChristmasGiftPage(driver);
		cg.getReturntocart().click();
		Thread.sleep(1000);
		
		log.info("Proceed to checkout and returned to cart !!");
	    
	}
	
	public static WebDriver getDriver() {
		return driver;
	}
	

}
