package com.github.indrajitchakraborty.utilis;

import org.openqa.selenium.WebDriver;

public class ConfigureThread {

    private static  ThreadLocal<WebDriver> thredDriver = new ThreadLocal<>();

    public void setDriver(WebDriver driver){

        thredDriver.set(driver);
    }

    public WebDriver getDriver(){

        return thredDriver.get();
    }
}
