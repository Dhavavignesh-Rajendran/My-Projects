package com.search;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.URL;

public class GridTest {

	public static void main(String[] args) {
		// Define hub URL
		String hubUrl = "http://localhost:4444/wd/hub";
 
		// Define desired capabilities for Chrome browser
		// Creates a DesiredCapabilities object, which represents the desired configuration for the WebDriver instance.
		// setBrowserName("chrome") method sets the desired browser type to Chrome.
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setBrowserName("chrome");
 
		try {
			// Create a RemoteWebDriver instance with hub URL and desired capabilities
			WebDriver driver = new RemoteWebDriver(new URL(hubUrl), capabilities);
 
			// Navigate to the website and perform actions
			driver.get("https://www.w3schools.com");
			System.out.println("Page title: " + driver.getTitle());
 
			driver.quit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
