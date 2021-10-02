package com.application.tests.day7;

import org.testng.Assert;
import org.testng.annotations.*;

public class BeforeAfter {

    @BeforeClass
    public void setUp(){
        System.out.println("This method is executed before anything in the class");
    }

    @AfterClass
    public void tearDown(){
        System.out.println("This method is executed after everything in the class");
    }

    @Test
    public void firstTestNGTest(){
        System.out.println("Hello World, Im testNG");
    }

    @BeforeMethod
    public void setUpMethod(){
        System.out.println("This method is executed by TestNG just before each method");
    }

    @AfterMethod
    public void tearDownMethod(){
        System.out.println("This method is executed by TestNG internally just after each method");
    }

    @Test
    public void secondTestNGMethod(){
        System.out.println("Hello world again, Im TestNG again:)");
    }

    String actual = "Alperen";
    String expected = "eren";

    @Test
    public void test1(){
        try{
            System.out.println("actual.substring(6,10) = " + actual.substring(6, 10));
        }catch (RuntimeException r){
            System.out.println("r.getMessage() = " + r.getMessage());
            System.out.println("Hello");
        }

        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            System.out.println("e.getMessage() = " + e.getMessage());
        }finally {
            System.out.println("\"after thread\" = " + "after thread");
        }


    }

}
