package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase
{
	//Page Factory - Object repository:
	@FindBy(xpath="//span[text()='Suneel Bare']")
	WebElement userNameLabel;

	@FindBy(xpath="//span[text()='Contacts']")
	WebElement contactsLink;

	@FindBy(xpath="//span[text()='Deals']")
	WebElement dealsLink;

	@FindBy(xpath="//span[text()='Tasks']")
	WebElement tasksLink;

	//Initializing the Page Objects:
	public HomePage()
	{
		PageFactory.initElements(driver,this);
	}
	public String verifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContactsLink()
	{
		contactsLink.click();
		return new ContactsPage();
	}
	public DealsPage clickOnDealsLink()
	{
		dealsLink.click();
		return new DealsPage();
	}
	public TasksPage clickOnTasksLink()
	{
		dealsLink.click();
		return new TasksPage();
	}
	public boolean verifyCorrectUserName()
	{
		return userNameLabel.isDisplayed();
	}
	

}
