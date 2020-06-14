package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	HomePage homePage=new HomePage();
	
	
	@FindBy(xpath="//div[text()='Contacts']")
	WebElement contactsLabel;
	
	@FindBy(xpath="//button[text()='New']")
	WebElement newBtn;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement firstNameTextBox;
	
	@FindBy(xpath="//input[@name='last_name']")
	WebElement lastNameTextBox;
	
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveBtn;
	
	public ContactsPage(){
		PageFactory.initElements(driver, this);
	}
	
	
	public boolean verifyContactsLabel(){
		return contactsLabel.isDisplayed();
	}
	
	
	public void selectContactsByName(String name){
		driver.findElement(By.xpath("//td[text()='"+name+"']//preceding-sibling::td//label")).click();
	}
	
	
	public void createNewContact(String fName,String lName){
		newBtn.click();
		firstNameTextBox.sendKeys(fName);
		lastNameTextBox.sendKeys(lName);
		saveBtn.click();
		homePage.clickOnContactsLink();
	}

}
