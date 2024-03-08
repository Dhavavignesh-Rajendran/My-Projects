package com.util.scenario;

import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Map;
import java.util.Set;

import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class MyntraMain {

	
	static DriverUtilScenario util;
	static WebDriver driver;

	
	public static void main(String[] args)throws IOException, ParseException {
		OpenApplication();
		JsonCredential();
		
	}

	
	private static WebDriver OpenApplication() {
		System.setProperty("WebDriver.chrome.driver", "C:/Users/DHARAJEN/Downloads/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://www.myntra.com/");
		driver.manage().window().maximize();
		util = new DriverUtilScenario(driver);
		return driver;
	}

	public static void JsonCredential() throws IOException, ParseException {

		FileReader reader = new FileReader("./Json/myntrasearch.json");

		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> userData = mapper.readValue(reader, Map.class);

		performSearchOperation(userData);
		PerformFilterOptions(userData);
//		performSendKeysOperations(userData);

	}

	public static void performSearchOperation(Map<String, String> userData) {
		
		util.Sendkeys(userData.get("searchfield"), userData.get("Nike Shoes"));
		util.Click(userData.get("searchbutton"));

	}

	public static void PerformFilterOptions(Map<String, String> userData) {
		util.Click(userData.get("menradiobutton"));
		util.Click(userData.get("pricefilter"));
		util.Click(userData.get("lowtohigh"));
		

	}

	public static void performSendKeysOperations(Map<String, String> userData) {
		

	}
	
//	@AfterTest
//	public static void CloseApplication() {
//		driver.quit();
//	}

}

