package com.application.tests.day12;

import com.application.utilities.ConfigurationReader;
import org.testng.annotations.Test;

public class Configuration {

    @Test
    public void test1(){
        String url = ConfigurationReader.get("url");
        String browser = ConfigurationReader.get("browser");
        System.out.println("url = " + url);
        System.out.println("browser = " + browser);
    }

}
