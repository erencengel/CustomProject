package com.application.tests.day2;

import com.application.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverBasics {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://www.google.com.tr/");
        WebDriverWait webDriverWait = new WebDriverWait(driver,10);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector(".gLFyf.gsfi"))));
        System.out.println("driver.getTitle() = " + driver.getTitle());
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());

        driver.get("https://www.amazon.com/");
        WebElement element = driver.findElement(By.cssSelector("#nav-cart-count"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(element));
        System.out.println("driver.getTitle() = " + driver.getTitle());
        System.out.println("driver.getCurrentUrl() = " + driver.getCurrentUrl());
        driver.close();
    }


}
