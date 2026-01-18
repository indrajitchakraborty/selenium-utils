package com.github.indrajitchakraborty.utilis;

import com.github.indrajitchakraborty.driver.DriverManagerWithThread;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static String takesScreenshot(String testName){

        WebDriver driver = DriverManagerWithThread.getDriver();
        if (driver == null) {
            System.out.println("Please Set The Driver using SetDriver Method First for Thread safe");
        }
            String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());
            String screenshotDir = System.getProperty("user.dir") + File.separator+ "extent-test-report" +File.separator+ "screenshots" +File.separator;
            String screenshotPath = screenshotDir + testName + "_" + timeStamp + ".png";

            try {
                new File(screenshotDir).mkdirs();
                File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File dest = new File(screenshotDir + screenshotPath);
                Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                e.printStackTrace();
            }
        return "screenshots" +File.separator + screenshotPath;
        }

}
