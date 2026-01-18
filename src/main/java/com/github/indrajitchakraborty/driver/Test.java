package com.github.indrajitchakraborty.driver;

import com.github.indrajitchakraborty.extent.ExtentListener;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Listeners;

@Listeners(ExtentListener.class)
public class Test {

    WebDriver driver;
    @org.testng.annotations.Test(priority = 1)
    public void invokeDriver(){

        driver = new ChromeDriver();
        DriverManagerWithThread.setDriver(driver);
        DriverManagerWithThread.getDriver().get("https://www.google.com");
    }

    @org.testng.annotations.Test(priority = 2)
    public void getTitle(){
        DriverManagerWithThread.getDriver().getTitle();
        Assert.assertTrue(false);
    }
}
