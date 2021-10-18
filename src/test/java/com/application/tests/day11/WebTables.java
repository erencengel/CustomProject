package com.application.tests.day11;

import com.application.utilities.WebDriverFactory;
import com.sun.xml.internal.bind.v2.runtime.reflect.Lister;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class WebTables {

    static WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
        driver.get("https://practice.cybertekschool.com/tables");
        driver.findElement(By.cssSelector("button[id^='d']")).click();
        driver.findElement(By.cssSelector("a[id*='proceed']")).click();
        new WebDriverWait(driver,7).until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//h3[contains(text(),Data)]"))));
    }

    @AfterMethod
    public void tearDown(){
        try {
            Thread.sleep(3000);
        }catch (InterruptedException interruptedException){
            interruptedException.printStackTrace();
        }
        driver.quit();
    }

    @Test
    public void test1(){
        System.out.println(driver.findElement(By.cssSelector("table#table1")).getText());
    }

    @Test
    public void test2(){
        //number of headers
        List<WebElement> list = driver.findElements(By.cssSelector("table#table1 thead tr th"));
        System.out.println("list.size() = " + list.size());

        //type all headers orderly
        for (WebElement element : list) {
            System.out.println("element.getText() = " + element.getText());
        }

        //number of all rows
        List<WebElement> list2 = driver.findElements(By.cssSelector("table#table1 tr"));
        System.out.println("list2.size() = " + list2.size());

        //number of rows without header
        List<WebElement> list3 = driver.findElements(By.cssSelector("table#table1 tbody tr"));
        System.out.println("list3.size() = " + list3.size());
    }


    @Test
    public void test3(){
        WebElement row2 = driver.findElement(By.xpath("(//table[@id='table1']/tbody/tr)[2]"));
        System.out.println("row2.getText() = " + row2.getText());
        List<WebElement> list = driver.findElements(By.xpath("(//table[@id='table1']/tbody/tr)[2]/td"));
        for (WebElement element : list) {
            System.out.println("element.getText() = " + element.getText());
        }
    }

    @Test
    public void test4(){
        int rawNumber = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr")).size();
        int columnNumber = driver.findElements(By.xpath("//table[@id='table1']/thead/tr/th")).size();
        for(int i=1;i<=rawNumber;i++){
            for (int j=1;j<=columnNumber;j++){
                System.out.println("raw: " + i + " / column: " + j);
                System.out.println(driver.findElement(By.xpath("//table[@id='table1']/tbody/tr[" + i + "]/td[" + j + "]")).getText());
            }
        }

    }


}
