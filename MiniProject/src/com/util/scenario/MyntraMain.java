package com.util.scenario;

import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MyntraMain {

	static DriverUtilScenario util;
	static WebDriver driver;

	@BeforeTest
	private static void OpenApplication() {
		util = new DriverUtilScenario(driver);	
		util.credenTials("https://www.myntra.com/");
	}

	@Test
	public static void Testing()throws IOException, ParseException {
		
		JsonCredential();		
	}

	public static void JsonCredential() throws IOException, ParseException {
		FileReader reader = new FileReader("./Json/myntrasearch.json");
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> userData = mapper.readValue(reader, Map.class);
		performSearchOperation(userData);
		PerformFilterOptions(userData);
	}

	public static void performSearchOperation(Map<String, String> userData) {	
		util.sendKeys(userData.get("searchfield"), userData.get("Nike Shoes"));
		util.cLick(userData.get("searchbutton"));
	}

	public static void PerformFilterOptions(Map<String, String> userData) {
		util.cLick(userData.get("menradiobutton"));
		util.cLick(userData.get("pricefilter"));
		util.cLick(userData.get("lowtohigh"));
	}
	
	@AfterTest
	public static void CloseApplication() {
		util.cLose();
	}

}

