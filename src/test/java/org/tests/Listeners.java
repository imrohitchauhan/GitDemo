package org.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.pageobject.ExtentReportNg;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.util.Iterator;

public class Listeners extends BaseTest implements ITestListener {
    ExtentReports extent = ExtentReportNg.getReportObject();
    ExtentTest test;
    public void onTestStart(ITestResult result) {
        test=extent.createTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println(result.getMethod().getMethodName());
    }

    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
        String filepath = null;
        try {
             filepath =getScreenShot(result.getMethod().getMethodName());

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        test.addScreenCaptureFromPath(filepath);
    }

    public void onTestSkipped(ITestResult result) {
        //System.out.println("onTestSkipped Method" +result.getName());
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        //System.out.println("onTestFailedButWithinSuccessPercentage" +result.getName());
    }

    public void onTestFinish(ITestResult result){
        extent.flush();
    }


}
