package com.application.tests.day4;

import com.application.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Locators {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
//        driver.get("http://practice.cybertekschool.com/multiple_buttons");
//        WebElement dontClickButton = driver.findElement(By.id("disappearing_button"));
//        dontClickButton.click();
//        Thread.sleep(3000);

//        driver.get("http://practice.cybertekschool.com/sign_up");
//        driver.findElement(By.name("full_name")).sendKeys("Eren ÇENGEL");
//        driver.findElement(By.name("email")).sendKeys("erencengel@gmail.com");
//        Thread.sleep(3000);

//        driver.findElement(By.tagName("input")).sendKeys("Eren ÇENGEL");
//        driver.findElement(By.xpath("(//input)[2]")).sendKeys("erencengel@gmail.com");
//        Thread.sleep(3000);

//        driver.findElement(By.tagName("input")).sendKeys("Eren ÇENGEL");
//        driver.findElement(By.xpath("(//input)[2]")).sendKeys("erencengel@gmail.com");
//        driver.findElement(By.className("radius")).click();
//        Thread.sleep(3000);

        driver.get("http://practice.cybertekschool.com/dynamic_loading");
        driver.findElement(By.linkText("Example 1: Element on page that is hidden and become visible after trigger"))
                .click();
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.findElement(By.partialLinkText("Example 5: Loading")).click();
        WebDriverWait webDriverWait = new WebDriverWait(driver,10);
        webDriverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[.='Submit']"))));
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();",driver.findElement(By.xpath("//button[.='Submit']")));
        //driver.findElement(By.xpath("//button[.='Submit']")).click();
        webDriverWait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[.='Submit']"))));
        driver.quit();
    }


}
