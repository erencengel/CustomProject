package com.application.tests.day8;

import com.application.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SelectDropDown {

    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome-headless");
        driver.get("http://practice.cybertekschool.com/dropdown");
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
    public void test1(){
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("select#dropdown"))));
        WebElement month = driver.findElement(By.cssSelector("select#month"));
        Select select = new Select(month);
        System.out.println("select.getFirstSelectedOption().getText() = " + select.getFirstSelectedOption().getText());
        List<WebElement> options = select.getOptions();
        for (WebElement option : options) {
            System.out.println("option.getText() = " + option.getText());
        }
        System.out.println(options.size());
        select.selectByIndex(11);
        System.out.println("select.getFirstSelectedOption().getText() = " + select.getFirstSelectedOption().getText());
        select.selectByVisibleText("January");
        System.out.println("select.getFirstSelectedOption().getText() = " + select.getFirstSelectedOption().getText());
    }


    @Test
    public void test2() {
        List<WebElement> elements = driver.findElements(By.xpath("//a[starts-with(@class,'drop')]"));
        driver.findElement(By.cssSelector("a#dropdownMenuLink")).click();
        System.out.println("elements.size() = " + elements.size());
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }
        elements.removeIf(n-> n.getText().contains("e"));
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }

    }

    @Test
    public void test3(){
        List<WebElement> elements = driver.findElements(By.xpath("//a[starts-with(@class,'drop')]"));
        driver.findElement(By.cssSelector("a#dropdownMenuLink")).click();
        System.out.println("elements.get(0).getText() = " + elements.get(0).getText());
        System.out.println("elements.get(0).getAttribute(\"value\") = " + elements.get(0).getAttribute("value"));
        System.out.println("elements.get(0).getAttribute(\"href\") = " + elements.get(0).getAttribute("href"));
    }







}








