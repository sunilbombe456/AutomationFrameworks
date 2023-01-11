package com.webwork.AppiumAutomationFrameWork;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class CalculatorTest {
	
	static AppiumDriver<MobileElement> driver;

	public static void main(String args[]) {
		openCalculator();
	}

	public static void openCalculator() {
		DesiredCapabilities cap = new DesiredCapabilities();

		cap.setCapability("deviceName", "MOTO G60 mb");
		cap.setCapability("udid", "ZD22255JS7");
		cap.setCapability("platformName", "Android");
		cap.setCapability("platformVersion", "12");
		cap.setCapability("appPackage", "com.google.android.calculator");
		cap.setCapability("appActivity", "com.android.calculator2.Calculator");
		URL url = null;
		try {
			url = new URL("http://localhost:4723/wd/hub");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver = new AppiumDriver<MobileElement>(url,cap);
		
		
		
	}
}
