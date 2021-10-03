package com.application.tests.day9;

import com.application.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Iframe {

    WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(){
        try {
            Thread.sleep(3000);
        }catch (InterruptedException interruptedException){

        }finally {
            System.out.println("coming from finally block");
        }
        driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/iframe");
        WebElement frameID = driver.findElement(By.cssSelector("#mce_0_ifr"));
        driver.switchTo().frame(frameID);
        WebElement element = driver.findElement(By.cssSelector("#tinymce"));
        element.clear();
        Thread.sleep(3000);
        driver.switchTo().parentFrame();
        driver.switchTo().frame(0);
        element.sendKeys("alperen");
        element.clear();
        Thread.sleep(2000);
        driver.switchTo().defaultContent();
        driver.switchTo().frame("mce_0_ifr");
        element.sendKeys("eren");
        Thread.sleep(2000);
    }

    @Test
    public void test2(){
        driver.get("http://practice.cybertekschool.com/nested_frames");
        driver.switchTo().frame(0);
        driver.switchTo().frame("frame-middle");
        System.out.println(driver.findElement(By.id("content")).getText());
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        System.out.println(driver.findElement(By.xpath("//*[contains(text(),'B')]")).getText());
    }

}
