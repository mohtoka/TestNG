package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertionExample {
	
	public static String url = "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login";

	public static WebDriver driver;

	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get(url);
		//driver.manage().window().maximize();
	}

	@AfterMethod
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(3000);
		driver.quit();
	}
	
	@Test
	public void invalidLoginError() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm1234");
		driver.findElement(By.cssSelector("input[id='btnLogin']")).click();
		
		String expected = "Invalid credentials";
		String actual = driver.findElement(By.id("spanMessage")).getText();
		SoftAssert sa = new SoftAssert();
		sa.assertEquals(actual, expected);
		
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("");
		driver.findElement(By.cssSelector("input[id='btnLogin']")).click();
		
		String expected2 = "Password cannot be empty";
		String actual2 = driver.findElement(By.id("spanMessage")).getText();
		sa.assertEquals(actual2, expected2);
		sa.assertAll();
		
	}

}
