package com.application.tests.day3;

import com.application.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class VerifyURLChanged {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        String targetWebSite = "http://practice.cybertekschool.com/forgot_password";
        driver.get(targetWebSite);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement mailBox = driver.findElement(By.cssSelector("input[name='email']"));
        mailBox.sendKeys("erencengel@gmail.com");
        WebElement retrieveButton = driver.findElement(By.cssSelector("#form_submit>i"));
        retrieveButton.click();
        WebDriverWait webDriverWait = new WebDriverWait(driver,10);
        WebElement elementWeWait = driver.findElement(By.cssSelector("h4[name='confirmation_message']"));
        webDriverWait.until(ExpectedConditions.visibilityOf(elementWeWait));
        if(driver.getCurrentUrl().equals("http://practice.cybertekschool.com/email_sent")){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("Actual URL is " + driver.getCurrentUrl());
        }
        driver.quit();
    }
}
