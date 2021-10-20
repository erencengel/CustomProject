package com.application.pages;

import com.application.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CustomerPage {
    public CustomerPage(){
        PageFactory.initElements(Driver.get(),this);
    }

    @FindBy(xpath = "//div[@class='control-label html-property']")
    public WebElement name;

    @FindBy(xpath = "(//div[@class='control-group attribute-row'])[3]/div/div/ul/li/span")
    public WebElement email;

    @FindBy (xpath = "((//div[@class='control-group attribute-row'])[2]/div/div/ul/li/span/span/a)[1]")
    public WebElement phoneNumber;


}
