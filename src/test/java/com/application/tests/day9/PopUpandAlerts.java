package com.application.tests.day9;

import com.application.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PopUpandAlerts {

    WebDriver driver;
    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown(){
        try {
            Thread.sleep(3000);
        }catch (InterruptedException interruptedException){
            System.out.println("coming from catch block");
        }finally {
            System.out.println("coming from finally block");
        }
        driver.quit();
    }


    @Test
    public void test1(){
        driver.get("https://www.primefaces.org/showcase/ui/overlay/confirmDialog.xhtml");
        driver.findElement(By.xpath("(//span[contains(text(),'Con')])[1]")).click();
        driver.findElement(By.xpath("(//button[starts-with(@name,'j')])[4]")).click();
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        WebElement JSAlert = driver.findElement(By.cssSelector("button[onclick*='jsAlert()']"));
        WebElement JSConfirm = driver.findElement(By.cssSelector("button[onclick*='jsC']"));
        WebElement JSPrompt = driver.findElement(By.cssSelector("button[onclick*='jsPro']"));
        JSAlert.click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        try {
            Thread.sleep(3000);
        }catch (InterruptedException interruptedException){

        }
        JSConfirm.click();
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        try {
            Thread.sleep(3000);
        }catch (InterruptedException interruptedException){

        }
        JSConfirm.click();
        Thread.sleep(3000);
        driver.switchTo().alert().dismiss();
        try {
            Thread.sleep(3000);
        }catch (InterruptedException interruptedException){

        }

        JSPrompt.click();
        Thread.sleep(3000);
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("alperen");
        alert.accept();
        try {
            Thread.sleep(3000);
        }catch (InterruptedException interruptedException){

        }
    }

}
