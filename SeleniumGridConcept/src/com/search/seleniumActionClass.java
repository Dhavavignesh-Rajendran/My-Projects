package com.search;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.WebElement;

public class seleniumActionClass {

	public static void main(String[] args){
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/DHARAJEN/Downloads/chromedriver-win64 (1)/chromedriver-win64/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("https://www.apple.com/in//");

		WebElement Entertainment = driver.findElement(By.xpath("//span[@class='globalnav-link-text' and text()='Entertainment']"));
//		Actions actions  = new Actions(driver);
//		actions.moveToElement(Entertainment).perform();
		Actions actions  = new Actions(driver);
		actions.
		contextClick(Entertainment).perform();
	}//switchto,git,why driver and javascript executor in bracket
 


	}


