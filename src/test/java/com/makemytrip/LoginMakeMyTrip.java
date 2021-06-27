package com.makemytrip;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginMakeMyTrip {

	WebDriver driver;
	WebDriverWait wait;

	//Using FindBy for locating elements
	@FindBy(xpath = "//li[contains(@data-cy,'account')]")
	private WebElement bt_account;

	@FindBy(id = "username")
	private WebElement txt_username;

	@FindBy(xpath = "//span[contains(text(),'Continue')]")
	private WebElement bt_continue;

	@FindBy(id = "password")
	private WebElement txt_password;

	@FindBy(xpath = "//span[contains(text(),'Login')]")
	private WebElement bt_login;

	@FindBy(xpath = "//p[contains(text(),'Hey')]")
	private WebElement txt_loginName;

	
	public LoginMakeMyTrip(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}

	public void navigateToEnter() throws Exception {
		Thread.sleep(5000);
		wait.until(ExpectedConditions.elementToBeClickable(bt_account));
		System.out.println("Click on Login");
		bt_account.click();
	}

	public void typeUserName(String text) {
		wait.until(ExpectedConditions.elementToBeClickable(txt_username));
		System.out.println("Entering the username and continue");
		txt_username.sendKeys(text);
		bt_continue.click();
	}

	public void typePassword(String text) {
		wait.until(ExpectedConditions.elementToBeClickable(txt_password));
		System.out.println("Entering the password and continue");
		txt_password.sendKeys(text);
		bt_login.click();
	}

	public String clickSubmit() throws Exception {
		Thread.sleep(25000);
		bt_login.click();
		wait.until(ExpectedConditions.visibilityOf(txt_loginName));
		return txt_loginName.getText();
	}
	
	
}
