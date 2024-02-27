package com.assessment;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Scenario1 {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/DHARAJEN/Downloads/chromedriver-win64 (1)/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.guru99.com/test/newtours");
		List<WebElement> price = driver.findElements(By.xpath("//b[contains(text(), '$')]"));
		int maxprice = 0;
		for (WebElement priceEm : price) {
			String convStr = priceEm.getText().replaceAll("[^0-9]", "");
			int priceEv = Integer.parseInt(convStr);
			maxprice = Math.max(maxprice, priceEv);
		}
		System.out.println(maxprice);
		String date = "Jul 6, 2017";
		if (driver.getPageSource().contains(date)) {
			System.out.println(date + " Date is present in the website");
		} else {
			System.out.println("Date is not present");
		}
//	driver.close();
	}

}
