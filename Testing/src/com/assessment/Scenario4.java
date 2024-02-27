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

public class Scenario4 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/DHARAJEN/Downloads/chromedriver-win64 (1)/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://englishonline.britishcouncil.org/");
		WebElement L1 = driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']"));
		L1.click();
		WebElement L2 = driver.findElement(By.xpath("//span[@class='button__text' and text()='Login'] [position()=1]"));
		L2.click();
		driver.findElement(By.xpath("//input[@class='form__field__input']")).sendKeys("dhavagmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("dhava1234");
		driver.findElement(By.xpath("//span[@class='form__field--choice__text']")).click();
		WebElement L3 = driver.findElement(By.xpath("//button[@id='checkemail']"));
		L3.click();

		System.out.println(driver.getCurrentUrl());
		List<WebElement> hyperlk = driver.findElements(By.tagName("a"));
		for (WebElement link : hyperlk) {
			System.out.println("Print all the hyperlink in webpage" + link.getAttribute("href"));
		}

	}

}
