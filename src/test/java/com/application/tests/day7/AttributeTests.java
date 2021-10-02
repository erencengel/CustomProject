package com.application.tests.day7;

import com.application.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class AttributeTests {

    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        WebElement element1 = driver.findElement(By.id("blue"));
        System.out.println("element1.getAttribute(\"name\") = " + element1.getAttribute("name"));
        System.out.println("element1.getAttribute(\"type\") = " + element1.getAttribute("type"));
        System.out.println("element1.getAttribute(\"checked\") = " + element1.getAttribute("checked"));
        System.out.println("element1.getAttribute(\"href\") = " + element1.getAttribute("href"));
        System.out.println("element1.getAttribute(\"class\") = " + element1.getAttribute("class"));
        System.out.println("element1.getAttribute(\"outerHTML\") = " + element1.getAttribute("outerHTML"));
        System.out.println("element1.getAttribute(\"innerHTML\") = " + element1.getAttribute("innerHTML"));
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement element2 = driver.findElement(By.cssSelector("[name='button2']"));
        System.out.println("element2.getAttribute(\"onclick\") = " + element2.getAttribute("onclick"));
        System.out.println("element2.getAttribute(\"outerHTML\") = " + element2.getAttribute("outerHTML"));
        System.out.println("element2.getAttribute(\"innerHTML\") = " + element2.getAttribute("innerHTML"));
        WebElement element3 = driver.findElement(By.cssSelector(".h3"));
        System.out.println("element3.getAttribute(\"innerHTML\") = " + element3.getAttribute("innerHTML"));
        driver.quit();

    }

}
