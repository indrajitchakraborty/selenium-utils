package com.github.indrajitchakraborty.driver;

import org.openqa.selenium.WebDriver;

public class Test {


    public static void main (String args[]) {

        WebDriver driver = DriverFactory.getChromeDriver();
        driver.get("https://www.google.com");

    }
}
