package com.webwork.AppiumAutomationFrameWork;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.MutableCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class SoucelabConfig {
	
	public static void main(String args[]) throws MalformedURLException {
	
	MutableCapabilities caps = new MutableCapabilities();
	caps.setCapability("platformName","Android");
	caps.setCapability("appium:deviceName","Android GoogleAPI Emulator");
	caps.setCapability("appium:deviceOrientation", "portrait");
	caps.setCapability("appium:platformVersion","12.0");
	caps.setCapability("appium:automationName", "UiAutomator2");
	caps.setCapability("appium:app", "storage:filename=Android.SauceLabs.Mobile.Sample.app.2.7.0.apk");
	MutableCapabilities sauceOptions = new MutableCapabilities();
	sauceOptions.setCapability("build", "appium-build-FJNRD");
	sauceOptions.setCapability("name", "First Test");
	caps.setCapability("sauce:options", sauceOptions);
	
	URL url = new URL("https://oauth-sunilbombe456-804e1:e020e282-b5e9-4db6-9b59-ec05418a5690@ondemand.eu-central-1.saucelabs.com:443/wd/hub");
	AppiumDriver driver = new AndroidDriver(url, caps);
	}
	
	
	

}
