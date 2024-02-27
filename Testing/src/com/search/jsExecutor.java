package com.search;


import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class jsExecutor {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/DHARAJEN/Downloads/chromedriver-win64 (1)/chromedriver-win64/chromedriver.exe");
		 
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("https://www.apple.com/in/");
		
		//JavaScript Executor
		JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("location.reload()");         //to reload the page
	js.executeScript("alert('Welcome to APPLE');"); //to display alert
		
		String domainName=js.executeScript("return document.domain;").toString();
		System.out.println("Domain Name--->"+ domainName);
		
		String title=js.executeScript("return document.title").toString();
		System.out.println("Title--->"+ title);
		
		String innerText =  js.executeScript("return document.documentElement.innerText;").toString();
		System.out.println("Inner etxt--->"+ innerText);
		
		WebElement shoppingBag = driver.findElement(By.xpath("//a[@role='button' and @aria-label='Shopping Bag']"));
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", shoppingBag);
		
		
		WebElement signIn = driver.findElement(By.xpath("//span[@class='ac-gn-bagview-nav-text' and text()='Sign in']"));
		js.executeScript("arguments[0].click();", signIn);
		
		//WebElement mobileNumber=driver.findElement(By.xpath("//span[@id=\"apple_id_field_label\"]"));
		
		js.executeScript("document.getElementById('apple_id_field_label').value='9597015331'");
		
		
		
	
		
		
		
//		driver.findElement(By.xpath("//a[@role='button' and @aria-label='Shopping Bag']")).click();
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='ac-gn-bagview-nav-text' and text()='Sign in']")))
//				.click();
		
		
		//js.executeScript("window.scrollBy(0,1000)");
		
		WebElement text=driver.findElement(By.xpath("//h4[text()='HomePod mini']"));
		js.executeScript("arguments[0].scrollIntoView();", text);

	}

}
