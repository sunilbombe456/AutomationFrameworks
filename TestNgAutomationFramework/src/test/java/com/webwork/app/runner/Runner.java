package com.webwork.app.runner;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Runner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//System.setProperty("","")
		System.setProperty("webdriver.chrome.driver", "C://drivers//chromedriver.exe");  
		
		//WebDriverManager.chromedriver().setup();
		
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://rahulshettyacademy.com/client");
		
		driver.findElement(By.cssSelector("input[type='email']")).sendKeys("ganesh.jadhav@gmail.com");
		
		driver.findElement(By.cssSelector("input[type='password']")).sendKeys("Ganesh@123");
		
		driver.findElement(By.cssSelector("input[type='submit']")).click();
				
		//driver.close();
	}

}
