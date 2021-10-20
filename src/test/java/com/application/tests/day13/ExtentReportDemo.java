package com.application.tests.day13;

import com.application.utilities.ConfigurationReader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Objects;

public class ExtentReportDemo {

     ExtentReports report;

     ExtentHtmlReporter htmlReporter;

     ExtentTest extentLogger;

     @BeforeMethod
    public void setUp(){
         report = new ExtentReports();

         String projectPath = System.getProperty("user.dir");
         String path = projectPath + "/test-output/report.html";

         htmlReporter = new ExtentHtmlReporter(path);

         report.attachReporter(htmlReporter);

         htmlReporter.config().setReportName("VytrackSmokeTest");

         report.setSystemInfo("Environment","QA");
         report.setSystemInfo("Browser",ConfigurationReader.get("browser"));
         report.setSystemInfo("OS", System.getProperty("os.name"));

     }

     @Test
     public void test1(){
          extentLogger = report.createTest("TC123 Login as a Driver Test");

          extentLogger.info("Open chrome browser");

          extentLogger.info("go to this url");

          extentLogger.info("click login");

          extentLogger.info("verif logged in");

          extentLogger.info("TC123 is passed");
     }

     @AfterMethod
     public void teardown(){
          report.flush();
     }

}
