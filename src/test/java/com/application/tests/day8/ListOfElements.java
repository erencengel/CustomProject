package com.application.tests.day8;

import com.application.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class ListOfElements {

    WebDriver driver;

    @BeforeTest
    public void setUp(){
        driver = WebDriverFactory.getDriver("chrome");
    }

    @AfterTest
    public void tearDown(){
        try {
            Thread.sleep(3000);
        }catch (InterruptedException interruptedException){

        }finally {
            System.out.println("final block is important for Java");
        }
        driver.quit();
    }

    @Test
    public void test1(){
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        List<WebElement> elements = driver.findElements(By.cssSelector("button[onclick^='but']"));
        for (WebElement element : elements) {
            System.out.println(element.getText());
        }

        for (WebElement element : elements) {
            element.click();
        }

        System.out.println("elements.size() = " + elements.size());

        {
            String name = "Alperen";
            System.out.println("name = " + name);
        }

    }

}
