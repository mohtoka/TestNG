package com.syntax.class01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task3 {
	
/*Open chrome browser
Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
Enter valid username and password
Click on login button
Then verify Syntax Logo is displayed
Close the browser*/
	
/*Open chrome browser
Go to “http://166.62.36.207/humanresources/symfony/web/index.php/auth/login”
Enter valid username
Leave password field empty
Verify error message with text “Password cannot be empty” is displayed.*/
	
	static String url = "http://166.62.36.207/humanresources/symfony/web/index.php/auth/login";
	static WebDriver driver;
	static String username = "Admin";
	static String password = "Hum@nhrm123";
	
	@BeforeMethod
	public void openBrowser() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver");
		driver = new ChromeDriver();
		driver.get(url);
	}
	
	@AfterMethod
	public void closeBrowser() {
		driver.quit();
	}
	
	@Test
	public void login() {
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("txtPassword")).sendKeys(password);
		driver.findElement(By.id("btnLogin")).click();
		
		boolean isLogoDisplayed = driver.findElement(By.cssSelector("img[alt='OrangeHRM']")).isDisplayed();
		
		System.out.println("Is logo displayed?:" + isLogoDisplayed);
	}
	
	@Test
	public void emptyPassword() {
		driver.findElement(By.id("txtUsername")).sendKeys(username);
		driver.findElement(By.id("btnLogin")).click();
		
		String errorMessage = driver.findElement(By.id("spanMessage")).getText();
		
		if(errorMessage.equals("Password cannot be empty")) {
			System.out.println("Error message displayed. Test PASSED");
		}else {
			System.out.println("Error message NOT displayed. Test FAILED");
		}
	}
	
	
	
	


}
