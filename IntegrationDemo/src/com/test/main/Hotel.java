package com.test.main;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.test.utils.DriverUtils;

public class Hotel {
	static DriverUtils util;
	static WebDriver driver;
	static String countryDropDown="//select[@name='country']";
	static String india="IN";
	static String cityDropDown="//select[@name='city']";
	static String chennai="46699";
	static String buildingDropDown="//select[@name='building']";
	static String buildingName="PCT";
	static String floorDropDown="//select[@name='floor']";
	static String floorNumber="38";
	static String noBtn = "//span[@class='mat-button-wrapper' and text()='No']";
	static String closeBtn = "//div[@class='closeBtnWrapper']";
	static String ballonBtn="//button[@class='btn btn-default balloonButton']";
	static String putText="//input[@id='twotabsearchtextbox']";
	static String smartSpeaker="smart speaker";
	static String getText="//span[@class='nav-line-2 ']";
	static String searchDropdown="//select[@id='searchDropdownBox']";
	static String amazonDevice="//option[@value='search-alias=amazon-devices']";
	static String jsCommand="arguments[0].click();";
	static String jsarg1="//a[@href=\"/electronics/b/?ie=UTF8&node=976419031&ref_=nav_cs_electronics\"]";
	public static void main(String[] args) {
		
		OpenApplication();
//		SelectSeatBookingOptions();
		SendingText();
		GettingText();
		JsExecution();
//		CloseInitialPrompts();
		
	}
	
	private static WebDriver OpenApplication() {
		System.setProperty("WebDriver.chrome.driver","C:/Users/DHARAJEN/Downloads/chromedriver-win64 (2)/chromedriver-win64/chromedriver.exe");
		//System.setProperty("WebDriver.chrome.driver","C:/Users/DHARAJEN/Downloads/chromedriver_win32/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.amazon.in/");
		util=new DriverUtils(driver);
		return driver;
	}
	
	private static void SendingText() {
		util.Sendkeys(putText, smartSpeaker);;
	}
	
	private static void GettingText() {
		System.out.println(util.GetText(getText));
	}
	
	private static void CloseInitialPrompts() {
		util.Click(noBtn);
		util.Click(closeBtn);
		util.Click(ballonBtn);
	}
	private static void SelectSeatBookingOptions() {
		util.Select(searchDropdown, amazonDevice);
//		util.Select(cityDropDown, chennai);
//		util.Select(buildingDropDown, buildingName);
//		util.Select(floorDropDown, floorNumber);
	}
	
	private static void JsExecution() {
		util.JsExecutors(jsCommand, jsarg1);
	}
	

}
