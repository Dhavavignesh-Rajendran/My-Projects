package com.assessment;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Scenario5 {

	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/DHARAJEN/Downloads/chromedriver-win64 (1)/chromedriver-win64/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.tnstc.in/home.html");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		WebElement From = driver.findElement(By.xpath("//input[@id='matchStartPlace']"));
		From.clear();
		From.sendKeys("CHENNAI KILAMBAKKAM KCBT");
		From.sendKeys(Keys.ARROW_DOWN);
		From.sendKeys(Keys.ENTER);
		
		WebElement To = driver.findElement(By.xpath("//input[@id='matchEndPlace']"));
		To.clear();
		To.sendKeys("SALEM");
		To.sendKeys(Keys.ARROW_DOWN);
		To.sendKeys(Keys.ENTER);
		
//		WebElement DateTab = driver.findElement(By.xpath("//input[@name='txtdeptDateOtrip']"));
//		wait.until(ExpectedConditions.elementToBeClickable(DateTab));
//		DateTab.click();
//		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//table[@class='ui-datepicker-calendar']")));
//		
//		WebElement MonthTab = driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
//		Select S = new Select(MonthTab);
//		S.selectByVisibleText("Mar");
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//		
//		WebElement Date = driver.findElement(By.xpath("//td[@data-handler='selectDay']//a[text()='15']"));
//		Date.click();
//		
		WebElement child = driver.findElement(By.xpath("//input[@id='txtChildMales']"));
		child.clear();
		child.sendKeys("1");
		
		WebElement female = driver.findElement(By.xpath("//input[@id='txtAdultFemales']"));
		female.clear();
		female.sendKeys("1");
	
//		WebElement Search = driver.findElement(By.xpath("//div[@class='btnTxt']//a[text()='SEARCH']"));
//		Search.click();
		

	
	}

}
