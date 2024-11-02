package org.pageobject;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNg {
//"user.dir")+"//reports//"

        public static ExtentReports getReportObject() {
                String path = System.getProperty("user.dir") + "//reports//index.html";
                ExtentSparkReporter reporter = new ExtentSparkReporter(path);
                reporter.config().setReportName("WebAutomationResult");
                reporter.config().setDocumentTitle("Test Result ");
                ExtentReports extent = new ExtentReports();
                extent.attachReporter(reporter);
                extent.setSystemInfo("tester", "rohit chauhan");
                return extent;
        }


}
