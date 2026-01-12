package com.github.indrajitchakraborty.utils;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportManager {

    private static ExtentReports extent;

    public static ExtentReports configExtentReport(String save_report , String reportTitle, String reportName,
                                       String systemInfoKey, String systemInfoValue){

        ExtentSparkReporter reporter = new ExtentSparkReporter("reports"+save_report);

        reporter.config().setDocumentTitle(reportTitle);
        reporter.config().setReportName(reportName);

        extent = new ExtentReports();

        extent.attachReporter(reporter);

        extent.setSystemInfo(systemInfoKey, systemInfoValue);
        extent.setSystemInfo(systemInfoKey, systemInfoKey);
        extent.setSystemInfo(systemInfoValue, systemInfoValue);
        return extent;
    }

}
