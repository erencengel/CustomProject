package com.application.tests.day9;

import com.application.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Waits {

    WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome-headless");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterTest
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");
        String actual = "Hello World!";
        String expected = driver.findElement(By.cssSelector("div#finish h4")).getText();
        Assert.assertEquals(actual,expected,"verfiy that actual is same with expected");
    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("div#start button"))));
        driver.findElement(By.cssSelector("div#start button")).click();
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("input#username"))));
        driver.findElement(By.cssSelector("input#username")).sendKeys("alperen");
    }

}
