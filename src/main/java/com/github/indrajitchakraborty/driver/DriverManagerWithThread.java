package com.github.indrajitchakraborty.driver;

import org.openqa.selenium.WebDriver;

public class DriverManagerWithThread {

    private static  final  ThreadLocal<WebDriver> tdriver = new ThreadLocal<>();

    public static void setDriver(WebDriver driver){

        tdriver.set(driver);
    }

    public static WebDriver getDriver(){

        return tdriver.get();
    }

    public static void removeDriver(){

        tdriver.remove();
    }


}
