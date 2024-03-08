package com.search;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Myntra {

	public static void main(String[] args) {
		int actual_price=1000;
		
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/DHARAJEN/Downloads/chromedriver-win64 (1)/chromedriver-win64/chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("https://www.myntra.com/");
		driver.findElement(By.xpath("//input[@class='desktop-searchBar']")).sendKeys("Nike shoes");
		driver.findElement(By.xpath("//a[@class='desktop-submit']")).click();
		// selecting filter-Men
		driver.findElement(By.xpath("(//label[@class='common-customRadio gender-label'])[1]")).click();

		driver.findElement(By.xpath("//div[@class='sort-sortBy']")).click();
		
		driver.findElement(By.xpath("(//div[@class='sort-sortBy']//ul[@class='sort-list']//li//label[@class='sort-label '])[6]")).click();


		
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));		
		//sort=price_asc
		wait.until(ExpectedConditions.urlContains("sort=price_asc"));
		WebElement price=driver.findElement(By.xpath("(//div[@class='product-price'])[1]"));
		wait.until(ExpectedConditions.visibilityOf(price));
		System.out.println(price);
		
				String amount=price.getText();
		//int rs=Integer.parseInt(amount);
		System.out.println(amount);
		
	}

}
