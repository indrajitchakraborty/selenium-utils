package com.github.indrajitchakraborty.extent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.github.indrajitchakraborty.utilis.ScreenshotUtil;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.HashMap;
import java.util.Map;

public class ExtentListener implements ITestListener , ISuiteListener {

    private static ExtentReports extent;

    @Override
    public void onStart(ISuite suite) {

        // Collect all parameters from XML or CLI
        Map<String, String> systemInfo = new HashMap<>(suite.getXmlSuite().getAllParameters());

        // Extract reportName & reportTitle
        String reportName = systemInfo.remove("reportName");
        if (reportName == null || reportName.isEmpty()) reportName = "AutomationReport";

        String reportTitle = systemInfo.remove("reportTitle");
        if (reportTitle == null || reportTitle.isEmpty()) reportTitle = "Automation Execution Report";

        // Initialize ExtentReports
        extent = ExtentManager.getExtentReport(reportName, reportTitle, systemInfo);
    }

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest test = extent.createTest(result.getMethod().getMethodName());
        ExtentTestManager.setTest(test);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getTest().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        ExtentTestManager.getTest().fail(result.getThrowable());

        String screenshotPath = ScreenshotUtil.takesScreenshot(result.getMethod().getMethodName());

        if (screenshotPath != null) {
            ExtentTestManager.getTest().fail(
                    "Screenshot on Failure",
                    MediaEntityBuilder
                            .createScreenCaptureFromPath(screenshotPath)
                            .build()
            );
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ExtentTestManager.getTest().skip("Test Skipped");
    }

    @Override
    public void onFinish(ISuite suite) {
        extent.flush(); // write report
    }
}
