package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {

	// Page Factory - Object repository:
	@FindBy(name = "email")
	WebElement email;

	@FindBy(name = "password")
	WebElement password;

	/*
	 * @FindBy(xpath="//input[@type='submit']") WebElement loginBtn;
	 */

	@FindBy(xpath = "//div[text()='Login']")
	WebElement loginBtn;

	@FindBy(xpath = "//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;

	// Initializing the Page Objects:
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	// Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean validateCRMImage() {
		return crmLogo.isDisplayed();
	}

	public String validateCurrentURL() {
		return driver.getCurrentUrl();

	}

	public HomePage login(String un, String pwd) {
		email.sendKeys(un);
		password.sendKeys(pwd);
		loginBtn.click();
		return new HomePage();
	}
}
