package com.webwork.AppiumAutomationFrameWork.test;

import static com.webwork.AppiumAutomationFrameWork.test.Config.region;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;

public class Mobile_Android_Browser_Test {
	// To Run on Local Env
    //    private static final String APP = "C:/Android-Apk/assets/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk";
    //    private static final String APPIUM = "http://localhost:4723/wd/hub"; // See the new URL declared according to region.
    
	String appUrl = "https://www.saucedemo.com/"; //added
    private AndroidDriver driver;
//    String usernameID = "test-Username";
//    String passwordID = "test-Password";
//    String submitButtonID = "test-LOGIN";
//    By ProductTitle = By.xpath("//android.widget.TextView[@text='PRODUCTS']");
    By usernameInput = By.id("user-name");
    By passwordInput = By.id("password");
    By submitButton = By.className("btn_action");
    By productTitle = By.className("product_label");
    //all 4 vars changed from app test

    @BeforeMethod
    public void setUp () throws Exception {
        System.out.println("Sauce Android Mobile Browser EMU - BeforeMethod hook"); //added
        URL url; //added
        String username = System.getenv("SAUCE_USERNAME");
        String accesskey = System.getenv("SAUCE_ACCESS_KEY");
        String sauceUrl;
        if (region.equalsIgnoreCase("eu")) {
            sauceUrl = "@ondemand.eu-central-1.saucelabs.com:443";
        } else {
            sauceUrl = "@ondemand.us-west-1.saucelabs.com:443";
        }
       // String SAUCE_REMOTE_URL = "https://" + username + ":" + accesskey + sauceUrl + "/wd/hub";
        String SAUCE_REMOTE_URL = "https://oauth-sunilbombe456-804e1:e020e282-b5e9-4db6-9b59-ec05418a5690@ondemand.eu-central-1.saucelabs.com:443/wd/hub";
        
        url = new URL(SAUCE_REMOTE_URL);

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion","8.0" );
        capabilities.setCapability("automationName", "UiAutomator2");
//       capabilities.setCapability("appWaitActivity", "com.swaglabsmobileapp.MainActivity"); //deleted
//        MutableCapabilities sauceOptions = new MutableCapabilities();
//    	sauceOptions.setCapability("build", "appium-build-FJNRD");
//    	sauceOptions.setCapability("name", "First Test");
//    	capabilities.setCapability("sauce:options", sauceOptions);
        capabilities.setCapability("browserName", "Chrome");// added
//        driver = new AndroidDriver(new URL(APPIUM), capabilities); //removed
        driver = new AndroidDriver(url, capabilities); //added

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
        driver.get(appUrl);
        login("standard_user", "secret_sauce");
        // Verification
        Assert.assertTrue(isOnProductsPage());
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


