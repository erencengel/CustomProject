package com.application.tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class OpenBrowser {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.get("https://www.google.com.tr/");
        driver.findElement(By.cssSelector(".gLFyf.gsfi"));
        driver.get("http://cybertekschool.com");
        driver.findElement(By.xpath("(//span[.='Join'])[1]"));
        driver.navigate().back();
        driver.findElement(By.cssSelector(".gLFyf.gsfi"));
        WebDriver driver1 = new ChromeDriver();
        driver1.get("https://www.amazon.com/amazonprime");
        WebDriverWait webDriverWait = new WebDriverWait(driver1,10);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(driver1.findElement(By.cssSelector("#nav-search-bar-form"))));
        driver.close();


    }
}
