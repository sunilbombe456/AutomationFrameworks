package com.webwork.AppiumAutomationFrameWork.test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.lang.reflect.Method; //added & used for first time
import java.net.URL;


import static com.webwork.AppiumAutomationFrameWork.test.Config.region;



public class Mobile_Android_EMU_Reporting_Test {

    private static final String APP = "Android.SauceLabs.Mobile.Sample.app.2.7.0.apk";

    URL url;
    private AndroidDriver driver;

    String usernameID = "test-Username";
    String passwordID = "test-Password";
    String submitButtonID = "test-LOGIN";
    By ProductTitle = By.xpath("//android.widget.TextView[@text='PRODUCTS']");

    @BeforeMethod
    public void setUp (Method method) throws Exception {
        System.out.println("Sauce Android EMU App Test with Reporting - BeforeMethod hook");
        String methodName = method.getName(); //added
        String username = System.getenv("SAUCE_USERNAME");
        String accesskey = System.getenv("SAUCE_ACCESS_KEY");
        String sauceUrl;
        if (region.equalsIgnoreCase("eu")) {
            sauceUrl = "@ondemand.eu-central-1.saucelabs.com:443";
        } else {
            sauceUrl = "@ondemand.us-west-1.saucelabs.com:443";
        }
        String SAUCE_REMOTE_URL = "https://" + username + ":" + accesskey + sauceUrl + "/wd/hub";
        url = new URL(SAUCE_REMOTE_URL);
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Android Emulator");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "8.0");
        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("appWaitActivity", "com.swaglabsmobileapp.MainActivity");
        capabilities.setCapability("app", "storage:filename=" + APP);
        capabilities.setCapability("name", methodName); //added, Method added as parameter
        driver = new AndroidDriver(url, capabilities);
    }

    @AfterMethod
    public void teardown(ITestResult result) {
        System.out.println("Sauce Android App EMU Test - AfterMethod hook");// added
//            if (driver != null) {
//                driver.quit();
//            }
        try {
            if (driver != null) {
                ((JavascriptExecutor) driver).executeScript("sauce:job-result=" + (result.isSuccess() ? "passed" : "failed"));
            }
        }finally {
            System.out.println("Sauce - release driver");
            driver.quit();
        } //try, finally added with JS for job-results, ITestResult added as parameter

    }

    @Test
    public void loginToSwagLabsTestValid () {
        System.out.println("Sauce - Start loginToSwagLabsTestValid test");

        login("standard_user", "secret_sauce");

        // Verification
        Assert.assertTrue(isOnProductsPage());
    }

    @Test
    public void loginTestValidProblem () {
        System.out.println("Sauce - Start loginTestValidProblem test");

        login("problem_user", "secret_sauce");

        // Verification - we on Product page
        Assert.assertTrue(isOnProductsPage());
    }

    public void login (String user, String pass){

        WebDriverWait wait = new WebDriverWait(driver, 5);
        final WebElement usernameEdit = wait.until(ExpectedConditions.visibilityOfElementLocated(new MobileBy.ByAccessibilityId(usernameID)));

        usernameEdit.click();
        usernameEdit.sendKeys(user);

        WebElement passwordEdit = driver.findElementByAccessibilityId(passwordID);
        passwordEdit.click();
        passwordEdit.sendKeys(pass);

        WebElement submitButton = driver.findElementByAccessibilityId(submitButtonID);
        submitButton.click();
    }

    public boolean isOnProductsPage () {
        //Create an instance of a Appium explicit wait so that we can dynamically wait for an element
        WebDriverWait wait = new WebDriverWait(driver, 5);

        //wait for the product field to be visible and store that element into a variable
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(ProductTitle));
        } catch (TimeoutException e) {
            System.out.println("*** Timed out waiting for product page to load.");
            return false;
        }
        return true;
    }
}


