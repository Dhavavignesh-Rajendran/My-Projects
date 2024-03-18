package com.search;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) {
		WebDriver driver=new ChromeDriver();
		//System.setProperty("webdriver.chrome.driver","C:/chromedriver-win64/chromedriver.exe");
		System.setProperty("webdriver.chrome.driver","C:/Users/DHARAJEN/Downloads/chromedriver-win64 (1)/chromedriver-win64/chromedriver.exe");
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		WebElement find=driver.findElement(By.xpath("//input[@name='keyword' and @id='inputValEnter']"));//Anything that is present on the web page is a WebElement 
		find.clear();
		find.sendKeys("mobile");//Entering values in input boxes explicitly using sendkeys() method 
		//find.clear();						//sendKeys command allows the user to type content automatically into an editable field while executing tests. These fields are web elements that can be identified using locators like element id, name, class name, etc.
	//	find.sendKeys("laptop");//if we give laptop search bar contain "mobile laptop
	
		find.sendKeys(Keys.ENTER);//To press ENTER
	
		System.out.println(driver.getTitle());
		////*[@href='https://www.snapdeal.com/myorders' and text()='Your Account']
		
		//driver.quit();//all associated windows will get closed
		//driver.close();//only original window will get closed and followed windows will not close
		
		//driver.findElement(By.xpath("//a[@href='https://www.snapdeal.com/products/digital-entertainment' and text()='Gift Cards']")).click();
//driver.findElement(By.xpath("//span[@class='accountUserName col-xs-12 reset-padding' and text()='Sign In']")).click();
		
		//*[text()='login']
//driver.findElement(By.xpath("//*[text()='login']")).click();
driver.findElement(By.xpath("//p[contains(text(),'Karbonn K531 Dual SIM Feature Phone Black Red')]")).click();
	
driver.findElement(By.xpath("//div[starts-with(@id,'add-cart-button-id')]")).click();
//	driver.findElement(By.xpath("//input[@placeholder='Mobile Number/ Email\']")).click();
		//input[@placeholder="Mobile Number/ Email"]
		//button[@class="btn col-xs-24 btn-large btn-skyblue continueBtn marT20 marB30"]
		//driver.findElement (By.name("username") ) .sendKeys ("dhava") ;
		//driver.findElement(By.id("userName")).sendKeys("dhava");
//driver.findElement(By.xpath("//button[text()='continue']")).click();
	}

}
