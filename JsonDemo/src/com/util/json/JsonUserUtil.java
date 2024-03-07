package com.util.json;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class JsonUserUtil {

	private WebDriver driver;

	public JsonUserUtil(WebDriver driver) {
		this.driver = driver;
	}

	public void Click(String xpath) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		By by = By.xpath(xpath);
		wait.until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).click();
	}
	
	public void Sendkeys(String xpath, String inputValue)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		By by=By.xpath(xpath);
		wait.until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).sendKeys(inputValue);;
	}
	
	public String GetText(String xpath)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		By by=By.xpath(xpath);
		wait.until(ExpectedConditions.elementToBeClickable(by));
		return driver.findElement(by).getText();
	}


}
