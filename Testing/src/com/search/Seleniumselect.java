package com.search;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Seleniumselect {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/DHARAJEN/Downloads/chromedriver-win64 (1)/chromedriver-win64/chromedriver.exe");
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/select-menu");
		Select s1 = new Select(driver.findElement(By.xpath("//select[@id='oldSelectMenu']")));
		s1.selectByVisibleText("Yellow");
		
		Select oSel = new Select(driver.findElement(By.xpath("//*[@id='cars']")));

				if(oSel.isMultiple()){
					
					//Selecting multiple values by index
					oSel.selectByIndex(1);
					oSel.selectByIndex(2);

				}
				
				Select multiple=new Select(driver.findElement(By.xpath("//select[@id='oldSelectMenu']")));
				List<WebElement> list = multiple.getOptions();
				for(WebElement i: list) {
					System.out.println(i.getText());
				}
				Actions actions  = new Actions(driver);
				actions.contextClick();
				}

}
