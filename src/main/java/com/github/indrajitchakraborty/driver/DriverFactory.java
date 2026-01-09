package com.github.indrajitchakraborty.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    public static WebDriver getChromeDriver(){

        return new ChromeDriver();
    }

    public static  WebDriver getFirefoxDriver(){

        return new FirefoxDriver();
    }

    public static WebDriver getEdgeDriver(){

        return new EdgeDriver();
    }

    public static WebDriver getSafariDriver(){

        return new SafariDriver();
    }
}
