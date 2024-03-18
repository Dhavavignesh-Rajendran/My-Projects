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

public class DriverMainScenario {
	static DriverUtilScenario util;
	static WebDriver driver;

	@BeforeTest
	private static void openApplication() {
		util = new DriverUtilScenario(driver);	
		util.credenTials("https://demo.automationtesting.in/Index.html");
	}

	@Test
	public static void testStart() throws IOException, ParseException {
		jsonCredential();
	}

	public static void jsonCredential() throws IOException, ParseException {
		FileReader reader = new FileReader("./Json/userdetails.json");
		ObjectMapper mapper = new ObjectMapper();
		Map<String, String> userData = mapper.readValue(reader, Map.class);

		clickSkipSignin(userData);
		enterUserDetails(userData);
		clickSubmitButton(userData);
	}

	public static void clickSkipSignin(Map<String, String> userData) {
		util.cLick(userData.get("skipsigninButton"));
	}

	public static void enterUserDetails(Map<String, String> userData) {
		util.sendKeys(userData.get("firstnamexpath"), userData.get("firstname"));
		util.cLick(userData.get("genderxpath"));
		util.cLick(userData.get("hobby1"));
		util.cLick(userData.get("hobby2"));
		util.seLect(userData.get("yearxpath"), userData.get("yearvalue"));
		util.seLect(userData.get("monthxpath"), userData.get("monthvalue"));
		util.seLect(userData.get("dayxpath"), userData.get("dayvalue"));
	}

	public static void clickSubmitButton(Map<String, String> userData) {
		util.cLick(userData.get("usersubmit"));
	}

	@AfterTest
	public static void closeApplication() {
		util.cLose();
	}

}
