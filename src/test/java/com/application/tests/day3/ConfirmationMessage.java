package com.application.tests.day3;

import com.application.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmationMessage {

    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/forgot_password");
        WebDriverWait webDriverWait = new WebDriverWait(driver,10);
        WebElement mailBox = driver.findElement(By.cssSelector("input[type='text']"));
        WebElement retrievePassword = driver.findElement(By.xpath("//i[.='Retrieve password']"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(retrievePassword));
        String email = "erencengel@gmail.com";
        mailBox.sendKeys(email);
        //verify that email is displayed in the input box
        String actualEmail = mailBox.getAttribute("value");
        System.out.println("actualEmail = " + actualEmail);
        if(actualEmail.equals(email)){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
        }
        retrievePassword.click();

        WebElement confirmationMessage = driver.findElement(By.cssSelector("h4[name='confirmation_message']"));
        webDriverWait.until(ExpectedConditions.visibilityOf(confirmationMessage));
        if(confirmationMessage.getText().equals("Your e-mail's been sent!")){
            System.out.println("PASS");
        }else {
            System.out.println("FAIL");
            System.out.println("ActualMessage is " + confirmationMessage.getText());
        }

        driver.quit();

    }

}
