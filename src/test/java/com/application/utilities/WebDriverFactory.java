package com.application.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;

public class WebDriverFactory {


    static WebDriver driver;
    public static WebDriver getDriver(String browserType){
        switch (browserType.toLowerCase()){
            case "chrome":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                return driver;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
                driver.manage().window().maximize();
                return driver;
            case "edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
                driver.manage().window().maximize();
                return driver;
            case "chrome-headless":
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
                return driver;
            default:
                driver = null;
                return driver;
        }
    }

}
