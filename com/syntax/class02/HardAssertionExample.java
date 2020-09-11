package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HardAssertionExample {

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
	
	@Test()
	public void titleValidation() {
		String expectedTitle = "Human Management System";
		String actualTitle = driver.getTitle();
		
		Assert.assertEquals(actualTitle, expectedTitle);
		
		System.out.println("---Code after assertion---");
		System.out.println("---End if test titleValidation---");
	}
	
	@Test
	public void logoValidation() {
		WebElement logo = driver.findElement(By.xpath("//div[@id='divLogo']/img"));
		Assert.assertTrue(logo.isDisplayed());
	}
	
	@Test
	public void loginFormText() {
		String expectedText = "LOGIN Panel";
		WebElement actualText = driver.findElement(By.id("logInPanelHeading"));
		
		Assert.assertEquals(actualText.getText(), expectedText);
		
	}

}
