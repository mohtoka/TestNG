package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class IssueWithoutAssertion {
	
	public static String url = "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login";
	
	public static WebDriver driver;
	
	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
	@Test(groups = "smoke")
	public void validLogin() {
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
		driver.findElement(By.cssSelector("input[id='btnLogin']")).click();
		String welcomeText = driver.findElement(By.id("welcome")).getText();
		
		if(welcomeText.contains("Admin")) {
			System.out.println("Admin is logged in. Test passed");
		}else {
			System.out.println("Admin is NOT logged in. Test failed");
		}
	}
	
	@Test(groups = "regression")
	public void titleValidation() {
		String expectedTitle = "Human Management System";
		String actualTitle = driver.getTitle();
		
		if(actualTitle.equals(expectedTitle)) {
			System.out.println("Titles match. Test passed");
		}else {
			System.out.println("Titles DON'T match. Text failed");
		}
	}

}
