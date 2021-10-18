package com.application.tests.day10;

import com.application.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class JavaScriptExecutor {

    WebDriver driver;
    JavascriptExecutor jse;
    Actions actions;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown(){
        try {
            Thread.sleep(2000);
        }catch (InterruptedException interruptedException){
            interruptedException.printStackTrace();
        }
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/");
        WebElement element = driver.findElement(By.xpath("//*[contains(text(),'Drag')]"));
        jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].click();",element);
        driver.get("http://practice.cybertekschool.com/dynamic_controls");
        new WebDriverWait(driver,7).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//button[@onclick='swapInput()']"))));
        actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//button[@onclick='swapInput()']"))).click().perform();
        new WebDriverWait(driver,7).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("form#input-example input"))));
        jse.executeScript("arguments[0].setAttribute('value', '" + "typo from Alperen" + " ')", driver.findElement(By.cssSelector("form#input-example input")));
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/");
        jse = (JavascriptExecutor) driver;
        jse.executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("//a[contains(text(),' Drop')]")));
        Thread.sleep(3000);
        jse.executeScript("arguments[0].click();",driver.findElement(By.xpath("//a[contains(text(),' Drop')]")));
        WebElement a = driver.findElement(By.cssSelector("#column-a"));
        WebElement b = driver.findElement(By.cssSelector("#column-b"));
        actions = new Actions(driver);
    }

    @Test
    public void test3(){
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        jse = (JavascriptExecutor) driver;
        for (int i=0;i<5;i++){
            jse.executeScript("window.scrollBy(0,100)");
            try{
                Thread.sleep(1000);
            }catch (InterruptedException interruptedException){
                interruptedException.printStackTrace();
            }
        }
    }


}
