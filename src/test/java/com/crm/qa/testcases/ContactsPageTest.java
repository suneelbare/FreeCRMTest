package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase {
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtilObj;
	String sheetName = "Contacts";
	
	public ContactsPageTest() 
	{
		super();
	}
	@BeforeMethod
	public void setup()
	{
		initialization();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.clickOnContactsLink();
		testUtilObj = new TestUtil();
	}
	
	@Test(enabled=true)
	public void verifyContactsLabel(){
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "Contacts Label missing on the page");
	}
	
	
	@Test(enabled=true)
	public void selectContactsTest(){
		contactsPage.selectContactsByName("Narendra Modi");
	}
	
	
	@Test
	public void validateCreateNewContactTest(){
		contactsPage.createNewContact("Ganesh","Gaitonde");
		
	}
	
	
	@Test
	public void getTestData(){
		Object[][] data = TestUtil.getTestData(sheetName);
		
		for(int i=0;i<data.length;i++){
			for(int j=0;j<data[0].length;j++){
				System.out.println(data[i][j]+" ");
			}
		}
	}
	
	
	
	
	
	
	
	@AfterMethod
	public void tearDown()
	{
		//driver.quit();
	}

}
