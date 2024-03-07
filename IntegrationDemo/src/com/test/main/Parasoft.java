package com.test.main;

import org.testng.Assert;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.test.utils.ParaSoftUtil;
import com.test.utils.ParaSoftProperties;

public class Parasoft extends ParaSoftProperties {

	static ParaSoftUtil util;
	static WebDriver driver;

	public static void main(String[] args) {

		OpenApplication();
		ClickForgetPassword();
		UserDetails();
		ClickFindLoginButton();
		ValidationOfError();
		//CloseApplication();
	}

	private static WebDriver OpenApplication() {
		System.setProperty("WebDriver.chrome.driver",
				"C:/Users/DHARAJEN/Downloads/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("https://parabank.parasoft.com/");
		driver.manage().window().maximize();
		util = new ParaSoftUtil(driver);
		return driver;
	}

	private static void ClickForgetPassword() {
		util.Click(forgetinfo);
	}

	public static void UserDetails() {
		util.Sendkeys(FirstName, Dhava);
		util.Sendkeys(LastName, Vignesh);
		util.Sendkeys(Address, HomeAddress);
		util.Sendkeys(City, HomeCity);
		util.Sendkeys(State, StateName);
		util.Sendkeys(ZipCode, CityZipcode);
		util.Sendkeys(Ssn, SsnCode);
	}

	private static void ClickFindLoginButton() {
		util.Click(FindLoginButtom);
	}

	private static void ValidationOfError() {
		Assert.assertEquals(ExpectedErrorMessage, util.GetText(ActualErrorMessage));
	}

	private static void CloseApplication() {
		driver.quit();
	}

}
