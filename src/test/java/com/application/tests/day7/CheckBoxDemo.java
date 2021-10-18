package com.application.tests.day7;

import com.application.utilities.WebDriverFactory;
import jdk.nashorn.internal.AssertsEnabled;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckBoxDemo {

    @Test
    public void test1(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");
        WebElement element1 = driver.findElement(By.cssSelector("input#box1"));
        WebElement element2 = driver.findElement(By.cssSelector("input#box2"));
        System.out.println("element1.isSelected() = " + element1.isSelected());
        System.out.println("element2.isSelected() = " + element2.isSelected());
        System.out.println("element1.isDisplayed() = " + element1.isDisplayed());
        System.out.println("element2.isDisplayed() = " + element2.isDisplayed());
        System.out.println("element1.isEnabled() = " + element1.isEnabled());
        System.out.println("element2.isEnabled() = " + element2.isEnabled());
        Assert.assertTrue(!element1.isSelected(),"verify that box1 is not selected");
        Assert.assertTrue(element2.isSelected(),"verify that box2 is selected");
        element1.click();
        driver.quit();
    }

    @Test
    public void test2(){
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        WebElement element = driver.findElement(By.id("green"));
        System.out.println("element.isEnabled() = " + element.isEnabled());
        Assert.assertTrue(!element.isEnabled());
        driver.quit();
    }

    @Test
    public void test3(){
        WebDriver driver = WebDriverFactory.getDriver("chrome-headless");
        driver.get("http://practice.cybertekschool.com/dynamic_loading/1");
        driver.findElement(By.xpath("//*[.='Start']")).click();
        System.out.println("driver.findElement(By.cssSelector(\"#username\")).isDisplayed() = " + driver.findElement(By.cssSelector("#username")).isDisplayed());
        new WebDriverWait(driver,10).until(ExpectedConditions.elementToBeClickable(driver.findElement(By.cssSelector("button[type='submit']"))));
        System.out.println("driver.findElement(By.cssSelector(\"#username\")).isDisplayed() = " + driver.findElement(By.cssSelector("#username")).isDisplayed());
        driver.findElement(By.cssSelector("#username")).sendKeys("Alperen");
        try {
            Thread.sleep(3000);
        }catch (InterruptedException interruptedException){

        }
        String expected = "Alperen";
        String actual = driver.findElement(By.cssSelector("#username")).getAttribute("value");
        System.out.println(actual);
        Assert.assertEquals(actual,expected);
    }

    @Test
    public void test4(){
        WebDriver driver = WebDriverFactory.getDriver("chrome-headless");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        WebElement blueButton = driver.findElement(By.xpath("(//label[starts-with(@class,'form')])[1]"));
        WebElement footballButton = driver.findElement(By.xpath("(//label[starts-with(@class,'form')])[7]"));
        WebElement HockeyButton = driver.findElement(By.xpath("(//label[starts-with(@class,'form')])[8]"));
        System.out.println("blueButton.isSelected() = " + blueButton.isSelected());
        System.out.println("footballButton.isSelected() = " + footballButton.isSelected());
        System.out.println("HockeyButton.isSelected() = " + HockeyButton.isSelected());
        Assert.assertTrue(!HockeyButton.isSelected(),"verify ...");
    }

    @Test
    public void test5(){
        WebDriver driver = WebDriverFactory.getDriver("chrome-headless");
        driver.get("http://practice.cybertekschool.com/radio_buttons");
        WebElement blue = driver.findElement(By.cssSelector("input[name^='co']"));
        WebElement basketball = driver.findElement(By.cssSelector("input[name^='spo']"));
        basketball.click();
        System.out.println("blue.isSelected() = " + blue.isSelected());
        System.out.println("basketball.isSelected() = " + basketball.isSelected());
        Assert.assertTrue(basketball.isSelected());
        WebElement football = driver.findElement(By.cssSelector("input#football"));
        System.out.println("football.isSelected() = " + football.isSelected());
        Assert.assertTrue(!football.isSelected());
    }
}
