package com.github.indrajitchakraborty.extent;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class ExtentManager {

    private static ExtentReports extentReport;
    public static ExtentReports getExtentReport(String reportName, String reportTitle, Map<String, String> systemInfo){

        if(!reportName.endsWith(".html")){

            reportName = reportName + ".html";
        }

        String reportPath =  Paths.get("extent-test-report", reportName).toString();

        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        spark.config().setReportName(reportName);

        spark.config().setDocumentTitle(reportTitle != null ? reportTitle : "Automation Execution Report");

        extentReport = new ExtentReports();
        extentReport.attachReporter(spark);

        if(systemInfo!= null && !systemInfo.isEmpty()){

            for(Map.Entry<String, String> entry : systemInfo.entrySet()){

                String key = entry.getKey();
                String value = entry.getValue();
                if (key != null && value != null) {
                    extentReport.setSystemInfo(key, value);
                }
            }
        }
        return extentReport;
    }
}
