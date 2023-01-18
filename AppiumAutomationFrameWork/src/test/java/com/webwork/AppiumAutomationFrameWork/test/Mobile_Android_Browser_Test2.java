package com.webwork.AppiumAutomationFrameWork.test;

import static com.webwork.AppiumAutomationFrameWork.test.Config.region;

import java.lang.reflect.Method;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Mobile_Android_Browser_Test2 {
	// To Run on Local Env
    //    private static final String APP = "C:/Android-Apk/assets/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk";
    //    private static final String APPIUM = "http://localhost:4723/wd/hub"; // See the new URL declared according to region.
    
	String appUrl = "https://www.saucedemo.com/"; //added
	
	//private static final String APP = "Android.SauceLabs.Mobile.Sample.app.2.7.1.apk";
	
	private static final String APP = "mda-1.0.16-19.apk";

    private AndroidDriver driver;
//    String usernameID = "test-Username";
//    String passwordID = "test-Password";
//    String submitButtonID = "test-LOGIN";
//    By ProductTitle = By.xpath("//android.widget.TextView[@text='PRODUCTS']");
    By usernameInput = By.id("test-Username");
    By passwordInput = By.id("test-Password");
    By submitButton = By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]/android.widget.TextView");
    By productTitle = By.className("product_label");
    //all 4 vars changed from app test

    @BeforeMethod
    public void setUp (Method method) throws Exception {
        System.out.println("Sauce Android EMU App Test with Reporting - BeforeMethod hook");
        String methodName = method.getName(); //added
        System.err.println("Method Name "+method);
        String username = System.getenv("SAUCE_USERNAME");
        String accesskey = System.getenv("SAUCE_ACCESS_KEY");
        String sauceUrl;
        if (region.equalsIgnoreCase("eu")) {
            sauceUrl = "@ondemand.eu-central-1.saucelabs.com:443";
        } else {
            sauceUrl = "@ondemand.us-west-1.saucelabs.com:443";
        }
        String SAUCE_REMOTE_URL = "https://oauth-sunilbombe456-804e1:e020e282-b5e9-4db6-9b59-ec05418a5690@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
        URL url = new URL(SAUCE_REMOTE_URL);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "UiAutomator2");
//        capabilities.setCapability("appWaitActivity", "com.swaglabsmobileapp.MainActivity");
     //   capabilities.setCapability("appWaitActivity", "com.saucelabs.mydemoapp.MainActivity");
        capabilities.setCapability("app", "storage:filename=" + APP);
        capabilities.setCapability("name", methodName); //added, Method added as parameter
        driver = new AndroidDriver(url, capabilities);
    }

    @AfterMethod
    public void teardown() {
        System.out.println("Sauce Android Mobile Browser EMU Test - AfterMethod Hook");// added
        if (driver != null) {
            driver.quit();
        }

    }

    @Test
    public void loginToSwagLabsTestValid() {
        System.out.println("Sauce Android Mobile Browser EMU Test - AfterMethod Hook");
//        driver.get(appUrl);
        login("standard_user", "secret_sauce");
//        // Verification
//        Assert.assertTrue(isOnProductsPage());
    }

    public void login(String user, String pass){
        driver.get(appUrl);
        driver.findElement(usernameInput).sendKeys(user);
        driver.findElement(passwordInput).sendKeys(pass);
        driver.findElement(submitButton).click();

    }

    public boolean isOnProductsPage() {
        return driver.findElement(productTitle).isDisplayed();
    }
}


