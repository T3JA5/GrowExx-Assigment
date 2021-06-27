package com.makemytrip;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {

	WebDriver driver;
	WebDriverWait wait;
	
	@FindBy(id = "fromCity")
	private WebElement txt_fromCity;
	
	@FindBy(xpath = "//div[contains(text(),'AMD')]")
	private WebElement sel_fromCity;
	
	@FindBy(id = "toCity")
	private WebElement txt_toCity;
	
	@FindBy(xpath = "//div[contains(text(),'BOM')]")
	private WebElement sel_toCity;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[1]/div[2]/div[1]/div[3]/label")
	private WebElement dt_departure;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[1]/div[2]/div[1]/div[5]/label")
	private WebElement txt_other;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[1]/div[2]/div[1]/div[5]/div[2]/div[1]/ul[1]/li[2]")
	private WebElement txt_passenger;
	
	@FindBy(xpath = "//button[contains(@data-cy,'travellerApplyBtn')]")
	private WebElement bt_apply;
	
	@FindBy(xpath = "//li[contains(@data-cy,'travelClass-2')]")
	private WebElement txt_travelClass;
	
	@FindBy(xpath = "//*[@id=\"root\"]/div/div[2]/div/div[1]/div[2]/p/a")
	private WebElement bt_search;
	
	@FindBy(xpath = "//span[contains(text(),'View')]")
	private WebElement txt_details;
	
	@FindBy(xpath = "//*[contains(@class,'viewFareRowWrap')][1]")
	private WebElement txt_detailsFlight;
	
	public HomePage(WebDriver driver, WebDriverWait wait) {
		this.driver = driver;
		this.wait = wait;
		PageFactory.initElements(driver, this);
	}
	
	public void selectFromCity(String city) {
		wait.until(ExpectedConditions.elementToBeClickable(txt_fromCity));
		txt_fromCity.sendKeys(city);
		wait.until(ExpectedConditions.elementToBeClickable(sel_fromCity));
		sel_fromCity.click();
	}
	
	public void selectToCity(String city) {
		wait.until(ExpectedConditions.elementToBeClickable(txt_toCity));
		txt_toCity.sendKeys(city);
		wait.until(ExpectedConditions.elementToBeClickable(sel_toCity));
		sel_toCity.click();
	}
	
	public void depature(String date) {
		wait.until(ExpectedConditions.elementToBeClickable(dt_departure));
		//Thread.sleep(5000);
		dt_departure.sendKeys(date);
	}
	
	public void otherDetails() {
		wait.until(ExpectedConditions.elementToBeClickable(txt_other));
		txt_other.click();
		wait.until(ExpectedConditions.elementToBeClickable(txt_passenger));
		txt_passenger.click();
		wait.until(ExpectedConditions.elementToBeClickable(txt_travelClass));
		txt_travelClass.click();
		bt_apply.click();
	}
	
	public void searchFlight() throws Exception{
		Thread.sleep(3000);
		bt_search.click();
		Thread.sleep(3000);
	 }
	
	public void flightSelect() {
		wait.until(ExpectedConditions.elementToBeClickable(txt_details));
		txt_details.click();
		wait.until(ExpectedConditions.visibilityOf(txt_detailsFlight));
		String text = txt_detailsFlight.getText();
		System.out.println(text);
	}
}
