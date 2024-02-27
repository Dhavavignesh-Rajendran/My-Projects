package com.search;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumAlert {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/DHARAJEN/Downloads/chromedriver-win64 (1)/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.automationtesting.in/Alerts.html");
		driver.manage().window().maximize();
		
		
		
		driver.findElement(By.xpath("//button[@onclick=\"alertbox()\"]")).click();
		driver.switchTo().alert().getText();
		driver.switchTo().alert().dismiss();
		
		driver.findElement(By.xpath("//a[text()='Alert with OK & Cancel ']")).click();//a[@href='#CancelTab']
		driver.findElement(By.xpath("//button[text()='click the button to display a confirm box ']")).click();////button[text()='click the button to display a confirm box ']
		//driver.switchTo().alert().dismiss();
		driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		
		driver.findElement(By.xpath("//a[text()='Alert with Textbox ']")).click();//a[@href='#CancelTab']
		driver.findElement(By.xpath("//button[text()='click the button to demonstrate the prompt box ']")).click();////button[text()='click the button to display a confirm box ']
		
		String alertMessage= driver.switchTo().alert().getText();
		System.out.println(alertMessage);
		
		
		Alert promptAlert = driver.switchTo().alert();

		
		String promptText = promptAlert.getText();

		
		promptAlert.sendKeys("Selenium");

		// Click the OK button to accept the prompt
		//promptAlert.accept();
		  // promptAlert.sendKeys("Hi Buddy");
		 //  promptAlert.accept();
		//driver.switchTo().alert().sendKeys("Hi Buddy");

	}

}
