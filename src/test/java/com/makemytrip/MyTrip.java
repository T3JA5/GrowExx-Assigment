package com.makemytrip;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyTrip {

	WebDriver driver;
	WebDriverWait wait;

	@BeforeTest
	public void beforeTest() {

		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 20);
		//System.setProperty("webdriver.chrome.driver", "C:\\Users\\admin\\Downloads\\chromedriver_win32\\chromedriver.exe");
		driver.manage().window().maximize();
		driver.get("https://www.makemytrip.com/");	
	}

	@Test(enabled = false)
	public void login() throws Exception {

		LoginMakeMyTrip login = new LoginMakeMyTrip(driver, wait);
		login.navigateToEnter();
		login.typeUserName("tejaslabhashetwar@gmail.com");
		login.typePassword("Desmond@2020");
		String name = login.clickSubmit();
		Assert.assertEquals(name, "Hey Tejas");
	}
	
	@Test
	public void searchFlight() throws Exception {
		HomePage hp = new HomePage(driver, wait);
		hp.selectFromCity("Ahemedbad");
		hp.selectToCity("Mumbai");
		//hp.depature("30/06/2021");
		hp.otherDetails();
		hp.searchFlight();
		hp.flightSelect();
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
