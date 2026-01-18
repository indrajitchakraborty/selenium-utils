package com.github.indrajitchakraborty.driver;

import com.github.indrajitchakraborty.utilis.ConfigureThread;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverFactory {

    static ConfigureThread configThred = new ConfigureThread();
    //static WebDriver driver;

    public static void navigateWithChrome(String url, WebDriver driver){

        driver = new ChromeDriver();

        configThred.setDriver(driver);
        configThred.getDriver();

        configThred.getDriver().get(url);
    }
    public static void navigateWithFirefox(String url, WebDriver driver){

       driver = new FirefoxDriver();

       configThred.setDriver(driver);
       configThred.getDriver();

       configThred.getDriver().get(url);
    }
    public static void navigateWithSafari(String url,WebDriver driver){

      driver = new SafariDriver();

      configThred.setDriver(driver);
      configThred.getDriver();
      configThred.getDriver().get(url);
    }
    public static void navigateWithEdge(String url, WebDriver driver){

       driver = new EdgeDriver();

       configThred.setDriver(driver);
       configThred.getDriver();
       configThred.getDriver().get(url);

    }


}
