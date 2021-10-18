package com.application.tests.day10;

import com.application.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Actionss {

    WebDriver driver;
    Actions action;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        //driver.quit();
    }

    @Test
    public void test1() throws InterruptedException {
        driver.get("https://practice.cybertekschool.com/hovers");
        new WebDriverWait(driver,7).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("button#details-button"))));
        driver.findElement(By.cssSelector("button#details-button")).click();
        driver.findElement(By.cssSelector("#proceed-link")).click();
        new WebDriverWait(driver,7).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[.='Hovers']"))));
        action = new Actions(driver);
        action.moveToElement(driver.findElement(By.cssSelector(".example div:nth-of-type(1)"))).perform();
        Thread.sleep(2000);
        action.moveToElement(driver.findElement(By.cssSelector(".example div:nth-of-type(2)"))).perform();
        Thread.sleep(2000);
        action.moveToElement(driver.findElement(By.cssSelector(".example div:nth-of-type(3)"))).perform();
        Thread.sleep(2000);
        //action.moveToElement(driver.findElement(By.xpath("//a[@href='/users/3'][.='View profile']"))).click();
        action.click(driver.findElement(By.xpath("//a[@href='/users/3'][.='View profile']"))).perform();
    }

    @Test
    public void test2() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        new WebDriverWait(driver,7).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("(//a[.='Basic usage'])[1]"))));
        action = new Actions(driver);
        action.moveToElement(driver.findElement(By.cssSelector("button#onetrust-accept-btn-handler"))).click().perform();
        Thread.sleep(1000);
        WebElement takeIt = driver.findElement(By.cssSelector("div#draggable"));
        WebElement drop = driver.findElement(By.cssSelector("div#droptarget"));
        action.dragAndDrop(takeIt,drop).perform();
        Assert.assertTrue(driver.findElement(By.cssSelector("div#droptarget")).getText().equals("You did great!"));
    }

}
