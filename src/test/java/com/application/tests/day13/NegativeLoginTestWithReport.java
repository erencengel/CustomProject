package com.application.tests.day13;

import com.application.pages.LoginPage;
import com.application.tests.TestBase;
import com.application.utilities.ConfigurationReader;
import com.application.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeLoginTestWithReport extends TestBase {

    @Test
    public void wrongPassword(){
        //name of the test
        extentLogger = report.createTest("Wrong Password Test");

        LoginPage loginPage = new LoginPage();

        extentLogger.info("Enter username user1");
        loginPage.usernameInput.sendKeys("user1");

        extentLogger.info("Enter Password: somepassword");
        loginPage.passwordInput.sendKeys("somepassword");

        extentLogger.info("Click login Button");
        loginPage.loginBtn.click();

        //driver.findElement(By.id("prependedInput")).sendKeys("user1");
        //driver.findElement(By.id("prependedInput2")).sendKeys("somepassword");
        //driver.findElement(By.cssSelector("#_submit")).click();

        extentLogger.info("verify page URL");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login", "verify that ...");

        extentLogger.pass("Wrong Password Test is passed");

    }
    @Test
    public void wrongUserNameTest(){
        //name of the test
        extentLogger = report.createTest("Wrong Username Test");

        LoginPage loginPage = new LoginPage();

        extentLogger.info("Enter username: someusername");
        loginPage.usernameInput.sendKeys("someusername");

        extentLogger.info("Enter password: User123");
        loginPage.passwordInput.sendKeys("User123");

        extentLogger.info("Click login Button");
        loginPage.loginBtn.click();

        extentLogger.info("Verify Page URL");
        Assert.assertEquals(driver.getCurrentUrl(),"https://qa1.vytrack.com/user/login", "verify that ...");

        extentLogger.pass("Wrong Password Test is Passed");


    }

    @Test
    public void positivetest(){
        extentLogger = report.createTest("myTest");

        LoginPage loginPage = new LoginPage();

        extentLogger.info("enter username as ...");
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("driver_username"));
        extentLogger.info("enter password as ...");
        loginPage.passwordInput.sendKeys(ConfigurationReader.get("driver_password"));
        extentLogger.info("click the login button");
        loginPage.loginBtn.click();
        String expectedUrl = "https://qa1.vytrack.com/";
        String actualUrl = Driver.get().getCurrentUrl();
        extentLogger.info("verify page url");
        Assert.assertEquals(actualUrl,expectedUrl);
        extentLogger.pass("PASS");
    }

    @Test
    public void negativetest(){
        extentLogger = report.createTest("myTest");

        LoginPage loginPage = new LoginPage();

        extentLogger.info("enter username as ...");
        loginPage.usernameInput.sendKeys(ConfigurationReader.get("driver_username"));
        extentLogger.info("enter password as ...");
        loginPage.passwordInput.sendKeys("password");
        extentLogger.info("click the login button");
        loginPage.loginBtn.click();
        String expectedUrl = "https://qa1.vytrack.com/";
        String actualUrl = Driver.get().getCurrentUrl();
        extentLogger.info("verify page url");
        Assert.assertEquals(actualUrl,expectedUrl);
        extentLogger.pass("PASS");
    }


}
