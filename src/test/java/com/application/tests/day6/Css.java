package com.application.tests.day6;

import com.application.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Css {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");
        List<WebElement> elements = driver.findElements(By.cssSelector("[class^='btn']"));
        for (int i = 0; i < elements.size(); i++) {
            System.out.println("elements.get("+i+").getText() = " + elements.get(i).getText());
        }
        driver.quit();

    }

}
