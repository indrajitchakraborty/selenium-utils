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
            System.out.println("Driver is null. Please set driver using setDriver()");
            return null;
        }

        String timeStamp = new SimpleDateFormat("ddMMyyyy_HHmmss").format(new Date());

        //Report base folder
        String reportDir = System.getProperty("user.dir")
                + File.separator + "extent-test-report";

        //Screenshot folder INSIDE report
        String screenshotDir = reportDir
                + File.separator + "screenshots";

        String screenshotName = testName + "_" + timeStamp + ".png";

        try {
            new File(screenshotDir).mkdirs();

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File(screenshotDir + File.separator + screenshotName);

            Files.copy(src.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

        //VERY IMPORTANT: return RELATIVE path with forward slash
        return "screenshots/" + screenshotName;

    }

}
