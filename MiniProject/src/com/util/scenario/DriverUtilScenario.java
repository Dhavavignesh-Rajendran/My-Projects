package com.util.scenario;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverUtilScenario {
	private WebDriver driver;
	private JavascriptExecutor js;
	public DriverUtilScenario(WebDriver driver) {
		this.driver=driver;
		js=(JavascriptExecutor)driver;
	}

	public void cLick(String object) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		By by=By.xpath(object);
		wait.until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).click();
	}

	public void sendKeys(String object, String object2)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		By by=By.xpath(object);
		wait.until(ExpectedConditions.elementToBeClickable(by));
		driver.findElement(by).sendKeys(object2);
	}

	public void seLect(String object,String object2) {
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		By by=By.xpath(object);
		wait.until(ExpectedConditions.elementToBeClickable(by));
		new Select(driver.findElement(by)).selectByValue(object2);;
	}

	public void jsExecutors(String jscommand,String arg) {
		  js.executeScript(jscommand, arg);		
	}

	public String getText(String xpath)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(20));
		By by=By.xpath(xpath);
		wait.until(ExpectedConditions.elementToBeClickable(by));
		return driver.findElement(by).getText();
	}
	
	public void credenTials(String url)
	{
		System.setProperty("WebDriver.chrome.driver", "C:/Users/DHARAJEN/Downloads/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		driver.get(url);
	}
	
	public void cLose()
	{
		driver.quit();
	}

}
