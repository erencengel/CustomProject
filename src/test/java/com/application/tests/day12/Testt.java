package com.application.tests.day12;

import com.application.utilities.ConfigurationReader;
import com.application.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Testt {


    @BeforeMethod
    public void setUp(){

    }

    @Test
    public void test1(){
        WebDriver driver = Driver.get();
        driver.get("https://www.amazon.com");
    }
}
