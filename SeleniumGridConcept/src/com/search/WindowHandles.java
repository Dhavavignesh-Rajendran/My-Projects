package com.search;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WindowHandles {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver",
				"C:/Users/DHARAJEN/Downloads/chromedriver-win64 (1)/chromedriver-win64/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		// driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://www.hyrtutorials.com/p/window-handles-practice.html");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@id='newWindowBtn']")).click();
		driver.findElement(By.xpath("//button[@id='newTabBtn']")).click();
		String mainwindow = driver.getWindowHandle();
		Set<String> allwindow = driver.getWindowHandles();

		Iterator<String> i1 = allwindow.iterator();
		System.out.println("Total windows opened->" + allwindow);
		System.out.println("child browsers");

		while (i1.hasNext()) {
			String childwindows = i1.next();
			driver.switchTo().window(childwindows);
			if (driver.getTitle().contains("Basic Controls - H Y R Tutorials")) {
				driver.findElement(By.xpath("//input[@id='firstName']")).sendKeys("Vignesh");
				System.out.println("new window-------->" + driver.getTitle());
				System.out.println("child 1 browser URL--------->" + driver.getCurrentUrl());
				System.out.println("child 1 browser------>" + childwindows);

			} else if (driver.getTitle().contains("AlertsDemo - H Y R Tutorials")) {// AlertsDemo - H Y R Tutorials
				driver.findElement(By.xpath("//a[text()='YouTube Courses']")).click();
				System.out.println("new Tab-------->" + driver.getTitle());
				System.out.println("child browser 2 browser URL--------->" + driver.getCurrentUrl());
				System.out.println("child browser  2------>" + childwindows);
			}
		}
		
		System.out.println("Main Browser");
		driver.switchTo().window(mainwindow);
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Hello There");
		System.out.println("Main Window------------>" + driver.getTitle());
		System.out.println("Main browser URL--------->" + driver.getCurrentUrl());
	}

}

