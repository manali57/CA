package com.mindtree.runner;
import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mindtree.pageObjects.AllOfIt;
import com.mindtree.pageObjects.ChristmasGiftPage;
import com.mindtree.pageObjects.ContactUs;
import com.mindtree.pageObjects.GiftCardPage;
import com.mindtree.pageObjects.HomePage;
import com.mindtree.pageObjects.PersonalizedGifts;
import com.mindtree.pageObjects.SearchBoxPage;
import com.mindtree.pageObjects.ShopByCategoryPage;
import com.mindtree.pageObjects.SignInPage;
import com.mindtree.pageObjects.WishList;
import com.mindtree.reusableComponent.WebDriverHelper;

import com.mindtree.utility.ReadPropertyFile;
import com.mindtree.utility.RetreiveExcelData;

public class BigSmall{

	Logger log = LogManager.getLogger(BigSmall.class.getName());

	WebDriver driver = null;
	ReadPropertyFile rp = null;

	/*
	 * this method is responsible for landing at home page and click on sign button.
	 * 
	 * WebDriverHelper class has a initializeDriver() method which will launch and
	 * initialize the driver.
	 * 
	 * ReadPropertyFile class :- contains method which is used to retrieve data from
	 * property file.
	 * 
	 * HomePage class contains method to return webelement of respective web page;
	 */

	@Test(priority = 1)
	public void homePageLanding() throws Exception {

		rp = new ReadPropertyFile();

		driver = WebDriverHelper.initializeDriver();

		driver.get(rp.getUrl());
		driver.manage().window().maximize();
		System.out.println("url hited");

		log.info("landing at home page");

		

	}
	
	

	/*
	 * this method is responsible for sending username and password to login form.
	 * 
	 * ReadPropertyFile class :- contains method which is used to retrieve data from
	 * property file.
	 * 
	 * SignInPage class contains method to return webelement of after after sign
	 * page;
	 * 
	 * Data provider attribute is being used to call datasuplier method to return
	 * data combination one by one.
	 */

	@Test(priority = 2, dataProvider = "dataSuplier")
	public void signInTesting(String username, String password) throws Exception {
		
		HomePage hp = new HomePage(driver);

		hp.getSignIn().click();
		log.info("clicked on sign button");

		Assert.assertTrue(true);

		SignInPage sp = new SignInPage(driver);

		sp.getEmail().clear();
		sp.getEmail().sendKeys(username);
		log.info(username + " entered");
		sp.getPassword().clear();
		sp.getPassword().sendKeys(password);
		log.info(password + " entered");
		//sp.getSignInSmmitButton().click();
		//log.info("clicked on summit button");
		sp.getSignInSmmitButton().click();
		log.info("clicked on submit button");
		Thread.sleep(5000L);
		
		

	}
	
	@Test(priority = 3)
	public void PersonalizedGift() {
		HomePage hp = new HomePage(driver);
		hp.getPersonalizedgift().click();
		PersonalizedGifts pg = new PersonalizedGifts(driver);
		pg.getsortby().click();
		pg.gethightolow().click();
		if(pg.getmaxprice().getText()=="4500")
			Assert.assertTrue(true);
		log.info("Successfully Sorted Products High to Low based on price");
		
	}
	
	@Test(priority = 4)
	public void searchProduct() throws IOException {

		ArrayList<String> d = RetreiveExcelData.getData("SearchDiary");

		SearchBoxPage sb = new SearchBoxPage(driver);

		

		for (int i = 1; i < d.size(); i++) {
			sb.getsearchbox().sendKeys(d.get(i));
			sb.getsearchbox().sendKeys(Keys.ENTER);
		}
        log.info("enterd product name");
        if(sb. getsearchproduct().isDisplayed())
        		Assert.assertTrue(true);
        log.info("Succesfully verified products are display!!");
	}
	
	@Test(priority = 5)
	public void Christmasgift() throws IOException, InterruptedException {
		
		HomePage hp = new HomePage(driver);
		Thread.sleep(3000);
		hp.getChristmasgift().click();
		
		log.info("Succesfully navigated to christmasgift");
		
		ChristmasGiftPage cp = new ChristmasGiftPage(driver);
		cp.getFirstproduct().click();
		Thread.sleep(3000);
		
		cp.getAddtocart().click();
		Thread.sleep(500);
		log.info("Product added");
		
		cp.getCheckout().click();
		if(cp.Closepopup().isDisplayed()) {
			cp.Closepopup().click();
		}
		Thread.sleep(2000);
		cp.getReturntocart().click();
		Thread.sleep(2000);
		log.info("Check out and returned to cart");
			
	} 

	@Test(priority = 6)
	public void ShopbyCategory() throws IOException, InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.getShopbycategory().click();
		ShopByCategoryPage sc = new ShopByCategoryPage(driver);
		sc.getBirthdaygift().click();
		sc.getFirstproduct().click();
		sc.getAddtowishlist().click();;
		if(sc.getViewwishlist().isDisplayed())
			Assert.assertTrue(true);
		log.info("Added to wishlist");
	
	}

	@Test(priority = 7)
	public void AllofIt() throws IOException, InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.getAllofit().click();
		Thread.sleep(2000);
		AllOfIt ap=new AllOfIt(driver);
		Thread.sleep(2000);
		log.info("Navigated to AllOfIt Page");
		if(ap.getproduct().getText().equals("Auto Rickshaw Pen Stand"))
				Assert.assertTrue(true);
		log.info("Verified Auto Rickshaw Pen Stand");
	}
	
	@Test(priority = 8)
	public void Wishlist() throws IOException, InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.getWishList().click();
		Thread.sleep(2000);
		log.info("Wishlist Page");
		WishList wl=new WishList(driver);
		if(wl.closepopup().isDisplayed())
			wl.closepopup().click();
		Thread.sleep(2000);
		if(wl.productvisible().isDisplayed())
			Assert.assertTrue(true);
		log.info("Products displayed in Wishlist");
	}
	
	@Test(priority = 9)
	public void AboutUs() throws IOException, InterruptedException {
		HomePage hp = new HomePage(driver);
		Thread.sleep(3000);
		hp.getAboutus().click();
		log.info("About Us Page");
		if(driver.getTitle().equals("About us"))
			Assert.assertTrue(true);
		log.info("Verified title of About Us Page");
	}
	
	@Test(priority = 10)
	public void GiftCard() throws IOException, InterruptedException {
		HomePage hp = new HomePage(driver);
		Thread.sleep(3000);
		hp.getGiftcard().click();
		log.info("Gift Cards Page");
		GiftCardPage gp = new GiftCardPage(driver);
		gp.getAddtocart().click();
		Thread.sleep(2000);
		log.info("Giftcard added to cart");
		if(gp.getCartproduct().isDisplayed())
			Assert.assertTrue(true);
		log.info("Cart Verified");
		
}

	@Test(priority = 11)
	public void ContactUsPage() throws Exception {
		ContactUs cu = new ContactUs(driver);
		Thread.sleep(3000);
		rp = new ReadPropertyFile();
		cu.getcontinueshopping().click();
		cu.getcontactUs().click();
		cu.getname().sendKeys(rp.getUserName());
		cu.getemail().sendKeys(rp.getEmail());
		cu.getmessage().sendKeys(rp.getMessage());
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		if (cu.gettitle().getText().equalsIgnoreCase("contact us")) {
			Assert.assertTrue(true);
			log.info("Title verified successfully ");
		}
	}	
	/*
	 * this method is responsible for sending product name has to be searched.
	 * 
	 * ReadPropertyFile class :- contains method which is used to retrieve data from
	 * property file.
	 * 
	 * SignInPage class contains method to return webElement of after after sign
	 * page;
	 * 
	 * 
	 * RetreiveExcelData class contains a method getData which will return array
	 * list containing search product. and product list is available in excel sheet.
	 * 
	 */
/*	@Test(priority = 3)
	public void searchProductTesting() throws IOException {

		ArrayList<String> d = RetreiveExcelData.getData("searchBook");

		SearchBoxPage sb = new SearchBoxPage(driver);

		// System.out.println("items "+d.size() + d.get(d.size()-1));

		for (int i = 1; i < d.size(); i++) {
			sb.getSearchBox().sendKeys(d.get(i));
			sb.getSearchBox().sendKeys(Keys.ENTER);
		}

		log.info("enterd product name");
	}
	
	

	/*
	 * this method is responsible for selecting a product after searching it.
	 * 
	 * SelectProductPage contains method to return webElement of select product
	 * page;
	 * 
	 * Here we are retrieving list of products and selecting first one produxt. 
	 * 
	@Test(priority = 4)
	
	@Test(priority = 4)
	public void selectProductTesting() throws InterruptedException {

		Thread.sleep(5000L);
		SelectProductPage sp = new SelectProductPage(driver);

		List<WebElement> lb = sp.getSelectProduct();

		if (lb.size() == 0)
			System.out.println("no books found");

		lb.get(0).click();

		log.info("selected serach product");

		Thread.sleep(5000L);
	}
	
	
	
	/*
	 * this method is responsible for adding product into card  after selecting  it.
	 * 
	 * and cross verity it by title that product added or not.
	 * 
	 * AddToCardPage contains method to return webElement of select product page.
	 
	@Test(priority = 5)
	public void addToCardTesting() throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		AddToCardPage atc = new AddToCardPage(driver);

		atc.getAddToCard().click();

		Thread.sleep(5000L);

		Assert.assertTrue(atc.getTitleAfterAdding().getText().contains("You added"));

		log.info("prodeuct added into card successfully");

	}
	
	
	@Test(priority = 6)
	public void shopingCardTesting()
	{
		AddToCardPage atc = new AddToCardPage(driver);
		ShopingCardPage scp = new ShopingCardPage(driver); 
		
		atc.getShopingCard().click();
		
		atc.getViewCart().click();
		
		Assert.assertTrue(scp.getSummuryTitle().getText().equalsIgnoreCase("Summary"));
	}
*/
	@AfterTest
	public void closeDriver() {
		driver.close();
		driver = null;
	}

	@DataProvider
	public Object[][] dataSuplier() {
		Object[][] data = new Object[3][2];
		
		data[0][0] = "";
		data[0][1] = "";

		data[1][0] = "abcd@123";
		data[1][1] = "abcd";

		data[2][0] = "manalishewale@gmail.com";
		data[2][1] = "Abcd@123";

		return data;
	}

}