package com.test.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverUtils {

	private WebDriver driver;
	private JavascriptExecutor js;
	public DriverUtils(WebDriver driver)
	{
		this.driver=driver;
		js=(JavascriptExecutor)driver;
	}
	public void Click(String xpath)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		By by=By.xpath(xpath);
		wait.until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).click();
	}
	public void Select(String xpath, String option)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		By by=By.xpath(xpath);
		//wait.until(ExpectedConditions.elementToBeSelected(by));
		//driver.findElement(by).click();
		new Select(driver.findElement(by)).selectByValue(option);;
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
	
	public void JsExecutors(String jscommand,Object arg) {
		  js.executeScript(jscommand, arg);
				
	}

}
