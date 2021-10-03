package com.application.tests.day9;

import com.application.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Set;
import java.util.concurrent.TimeUnit;

public class MultipleWindows {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome-headless");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod()
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/windows");
        System.out.println("driver.getTitle() = " + driver.getTitle());
        String windowHandle1 = driver.getWindowHandle();
        WebElement click = driver.findElement(By.cssSelector("a[target*='_blank'][href*='/w']"));
        click.click();
        try {
            Thread.sleep(3000);
        }catch (InterruptedException interruptedException){

        }
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            if(!windowHandle.equals(windowHandle1)){
                driver.switchTo().window(windowHandle);
                break;
            }
        }
        String expected = "New Window";
        WebElement element = driver.findElement(By.xpath("//h3[contains(text(),'W')]"));
        String actual = element.getText();
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/windows");
        System.out.println("driver.getTitle() = " + driver.getTitle());
        String windowHandle1 = driver.getWindowHandle();
        WebElement click = driver.findElement(By.cssSelector("a[target*='_blank'][href*='/w']"));
        click.click();
        System.out.println("driver.getTitle() = " + driver.getTitle());
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            if (driver.getTitle().equals("New Window")){
                break;
            }
        }
        System.out.println("driver.getTitle() = " + driver.getTitle());
        Thread.sleep(3000);
    }



}
