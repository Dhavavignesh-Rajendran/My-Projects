package com.search;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ExplicitWait {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		// System.setProperty("webdriver.chrome.driver","C:/chromedriver-win64/chromedriver.exe");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		System.setProperty("webdriver.chrome.driver",
				"C:/Users/DHARAJEN/Downloads/chromedriver-win64 (1)/chromedriver-win64/chromedriver.exe");
		driver.get("https://www.bigbasket.com/");
		driver.manage().window().maximize();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@id='headlessui-menu-button-:R5bab6:']")))
				.click();

		// driver.findElement(By.xpath("//button[@id='eadlessui-menu-button-:R5bab6:']")).click();
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(
				"//span[@class='Label-sc-15v1nk5-0 SingleTab___StyledLabel-sc-12ryjuq-2 gJxZPQ jprYOZ' and text()='My Smart Basket']")));

		driver.findElement(By.xpath("//img[@src='https://www.bigbasket.com/media/customPage/b01eee88-e6bc-410e-993c-dedd012cf04b/91e53046-98e0-4c5b-ae53-7d073e5210e1/41a0810e-1fc3-46e4-9d2c-7d9e79e0aa29/hp_f&v_m_herbs-&-seasoning_480_250923.jpg?tr=w-3840,q=80']")).click();
		
		WebDriverWait alert = new WebDriverWait(driver, Duration.ofSeconds(10));
		if (alert.until(ExpectedConditions.alertIsPresent()) == null) {
			System.out.println("Alert not exists");
		} else
			System.out.println("Alert exists");
	};
}
