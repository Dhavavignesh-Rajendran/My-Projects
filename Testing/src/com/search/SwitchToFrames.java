package com.search;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SwitchToFrames {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/DHARAJEN/Downloads/chromedriver-win64 (1)/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.hyrtutorials.com/p/frames-practice.html");
		driver.manage().window().maximize();
		List<WebElement> iframeElements = driver.findElements(By.tagName("iframe"));
		System.out.println("The total number of iframes are " + iframeElements.size());
		//main webpage
		driver.findElement(By.xpath("//input[@class=\"frmTextBox\" and @id='name']")).sendKeys("Main Webpage");
		
		//frame 1
		driver.switchTo().frame("frm1");//frame 1	
		Select Fr1=new Select(driver.findElement(By.id("course")));
		Fr1.selectByVisibleText("Java");
		
		driver.switchTo().defaultContent(); //coming back to main webpage to access frame 2
		
		//frame 2
		driver.switchTo().frame("frm2");//frame 2
		driver.findElement(By.id("englishchbx")).click();
		driver.findElement(By.id("hindichbx")).click();
		
		driver.switchTo().defaultContent();
		
		//frame3[parent frame]
		driver.switchTo().frame("frm3");//coming back to main webpage to access frame 3(nested webpage)
		driver.findElement(By.xpath("//input[@class=\"frmTextBox\" and @id='name']")).sendKeys("Frame 3");
		
		driver.switchTo().frame("frm1");//switching to frame 1(child) in frame 3	
		Select Fr3=new Select(driver.findElement(By.id("course")));
		Fr3.selectByVisibleText("Python");//id="firstName"
		
//		driver.switchTo().frame("frm2");//switching to frame 2(child) in frame 3
//		driver.findElement(By.id("firstName")).sendKeys("Dhava");
		
		driver.switchTo().parentFrame();//switching back to Frame3(parent frame)
		driver.findElement(By.xpath("//input[@class=\"frmTextBox\" and @id='name']")).sendKeys("parent frame");
//	}

}
}
