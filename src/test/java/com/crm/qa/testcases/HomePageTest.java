package com.crm.qa.testcases;


import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase 
{
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtilObj;
	
	public HomePageTest() 
	{
		super();
	}
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtilObj = new TestUtil();
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest()
	{
		String homePageTitle = homePage.verifyHomePageTitle();
		System.out.println("Actuall HomePage Tile: "+homePageTitle);
		Assert.assertEquals(homePageTitle,"Cogmento CRM","Home page title not matched");
	}
	
	@Test(priority=2)
	public void verifyUserNameTest()
	{
		//testUtilObj.switchToFrame();
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void varifyContactsLinkTest(){
		contactsPage = homePage.clickOnContactsLink();
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}
