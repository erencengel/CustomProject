package com.application.tests.day5;

import com.application.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class XPath {

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        List<WebElement> elements = driver.findElements(By.xpath("//button[@class='btn btn-primary']"));
        for (WebElement element : elements) {
            element.click();
            Thread.sleep(2000);
        }
        driver.quit();
    }

}
