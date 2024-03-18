package com.search;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Assesment1 {
	public static WebDriver driver;

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/DHARAJEN/Downloads/chromedriver-win64 (1)/chromedriver-win64/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		// WebDriver driver=new ChromeDriver();
		driver.get("https://www.tnstc.in/home.html");
		
		driver.manage().window().maximize();
		Thread.sleep(4000);
		WebElement fromTextBox = driver.findElement(By.xpath("//input[@id='matchStartPlace']"));
		fromTextBox.sendKeys("CHENNAI KILAMBAKKAM KCBT");
		fromTextBox.sendKeys(Keys.ARROW_DOWN);
		fromTextBox.sendKeys(Keys.ENTER);

		WebElement toTextBox = driver.findElement(By.xpath("//input[@id='matchEndPlace']"));
		toTextBox.sendKeys("SALEM");
		toTextBox.sendKeys(Keys.ARROW_DOWN);
		toTextBox.sendKeys(Keys.ENTER);

		
//		int start = 54;
//		List<WebElement> list1=driver.findElements(By.xpath("//ul[@class='ui-autocomplete ui-front ui-menu ui-widget ui-widget-content ui-corner-all']//li//a[@id='ui-id-55']"));
//		int size = list1.size();
//		System.out.println(size);
//		
//		for(WebElement val : list1)
//		{
//			System.out.println(val);
//			
//		}
		

	WebElement date=driver.findElement(By.xpath("//input[@id='txtdeptDateOtrip']"));
		date.click();

		driver.findElement(By.xpath("//td[@class=' ui-datepicker-days-cell-over  ui-datepicker-current-day ui-datepicker-today']/a[text()='22']"))
						.click();

		driver.findElement(By.xpath("//input[@id='txtAdultFemales']")).sendKeys("1");
		driver.findElement(By.xpath("//input[@id='txtChildMales']")).sendKeys("1");

		driver.findElement(By.xpath("//a[@class='btnTxt' and @href=\"javascript:setAction('SearchService')\"]"))
				.click();

	}


}
