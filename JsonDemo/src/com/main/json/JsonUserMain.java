package com.main.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.util.json.*;

public class JsonUserMain {

	static JsonUserUtil util;
	static WebDriver driver;

	public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {

		OpenApplication();
		jsonMethod();
//		ClickForgetPassword();
//		UserDetails();
//		ClickFindLoginButton();
//		ValidationOfError();
		CloseApplication();
	}

	@BeforeTest
	private static WebDriver OpenApplication() {
		System.setProperty("WebDriver.chrome.driver",
				"C:/Users/DHARAJEN/Downloads/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.manage().window().maximize();
		util = new JsonUserUtil(driver);
		return driver;
	}
	
	@Test
	public static void jsonMethod() throws FileNotFoundException, IOException, ParseException {
	JSONParser jsonparser = new JSONParser();
	FileReader reader = new FileReader("C:/Users/DHARAJEN/Downloads/JavasonUser.json");
	Object obj = jsonparser.parse(reader);
	JSONObject employee = (JSONObject) obj;
	
	String userName=(String) employee.get("username");
	String UserPassowrd=(String) employee.get("password");
	String submitButton=(String)employee.get("clickbutton");
	String nAme=(String) employee.get("name");
	String Upassword=(String) employee.get("Upassword");

	util.Sendkeys(userName, nAme);
	util.Sendkeys(UserPassowrd, Upassword);
	util.Click(submitButton);
	
	}
	
	@AfterTest
	public static void CloseApplication() {
		driver.close();
	}

}
	

	
