package com.assessment;

import java.io.File;
import java.io.IOException;
import org.openqa.selenium.chrome.ChromeDriver;
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

public class Scenario3 {

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/DHARAJEN/Downloads/chromedriver-win64 (1)/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.guru99.com/test/newtours");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().window().maximize();
		WebElement search = driver.findElement(By.xpath("//a[@href='reservation.php']"));
		search.click();
		driver.findElement(By.xpath("//input[@value='oneway']")).click();
		Select s1 = new Select(driver.findElement(By.xpath("//select[@name='passCount']")));
		s1.selectByValue("3");
		Select s2 = new Select(driver.findElement(By.xpath("//select[@name='fromPort']")));
		s2.selectByValue("London");
		Select s3 = new Select(driver.findElement(By.xpath("//select[@name='fromMonth']")));
		s3.selectByValue("3");
		Select s4 = new Select(driver.findElement(By.xpath("//select[@name='fromDay']")));
		s4.selectByValue("16");
		Select s5 = new Select(driver.findElement(By.xpath("//select[@name='toPort']")));
		s5.selectByValue("San Francisco");
		WebElement wb = driver.findElement(By.xpath("//input[@value='First']"));
		wb.click();
		Select s7 = new Select(driver.findElement(By.xpath("//select[@name='airline']")));
		s7.selectByVisibleText("Blue Skies Airlines");
		File file = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		Files.copy(file, new File("C:/Users/DHARAJEN/OneDrive - Capgemini/Desktop/ScreenShot_Selenium/s1.png"));

	}
}
