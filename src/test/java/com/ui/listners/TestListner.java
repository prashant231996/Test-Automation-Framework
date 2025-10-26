package com.ui.listners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.tests.TestBase;
import com.utility.BrowserUtility;
import com.utility.ExtentReportUtility;
import com.utility.LoggerUtility;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.util.Arrays;

public class TestListner implements ITestListener {

    Logger logger= LoggerUtility.getLogger(this.getClass());

    ExtentSparkReporter extentSparkReporter;   //Look ,style & Fill of report
    ExtentReports extentReports;  //Heavy lifting==>Dumping of data into html report
    ExtentTest extentTest;   //Store information about test

    public void onTestStart(ITestResult result) {
        logger.info(result.getMethod().getMethodName());
        logger.info(result.getMethod().getDescription());
        logger.info(Arrays.toString(result.getMethod().getGroups()));
        ExtentReportUtility.createExtentTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        logger.info(result.getMethod().getMethodName()+" "+"PASSED");
        ExtentReportUtility.getExtentTest().log(Status.PASS,result.getMethod().getMethodName()+" "+"PASSED");
    }

    public  void onTestFailure(ITestResult result) {
        logger.error(result.getMethod().getMethodName()+" "+"FAILED");
        logger.error(result.getThrowable().getMessage());
        ExtentReportUtility.getExtentTest().log(Status.FAIL,result.getMethod().getMethodName()+" "+"FAILED");
        ExtentReportUtility.getExtentTest().log(Status.FAIL,result.getThrowable().getMessage());
        Object testClass=result.getInstance();
        TestBase testBase=(TestBase)testClass;
        BrowserUtility browserUtility=testBase.getInstance();
        logger.info("Capturing screen shot for the failed test");
        String screenShotpath=browserUtility.takeScreenShot(result.getMethod().getMethodName());
        logger.info("Attcaching failed screen shot in the report");
        ExtentReportUtility.getExtentTest().addScreenCaptureFromPath(screenShotpath);
    }

    public void onTestSkipped(ITestResult result) {
        logger.warn(result.getMethod().getMethodName()+" "+"SKIPPED");
        ExtentReportUtility.getExtentTest().log(Status.SKIP,result.getMethod().getMethodName()+" "+"SKIPPED");
    }

    public void onStart(ITestContext context) {
        logger.info("Test suite is started");
        ExtentReportUtility.setupSparkReporter("report.html");
    }

    public void onFinish(ITestContext context) {
        logger.info("Test suite is completed");
        ExtentReportUtility.flushReport();
    }


}
