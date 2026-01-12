package com.github.indrajitchakraborty.listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.github.indrajitchakraborty.utils.ExtentReportManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestReportListener implements ITestListener {

    private static ExtentReports extentReports;
    public TestReportListener(String saveReportName, String reportName, String reportTitle,
                              String configInfoKey, String configInfoValue){
        extentReports = ExtentReportManager.configExtentReport(saveReportName,reportName,reportTitle,
                configInfoKey,configInfoValue);
    }

    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        test.set(extentReports.createTest(result.getMethod().getMethodName()));
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass(
                MarkupHelper.createLabel("PASSED", ExtentColor.GREEN)
        );
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.get().fail(
                MarkupHelper.createLabel("FAILED", ExtentColor.RED)
        );
        test.get().fail(result.getThrowable());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        test.get().skip(
                MarkupHelper.createLabel("SKIPPED", ExtentColor.ORANGE)
        );
    }

    @Override
    public void onFinish(ITestContext context) {
        extentReports.flush();
    }

}
