package com.application.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TestersMeetingPage extends BasePage{

    @FindBy(css="label.control-label")
    public List<WebElement> firstPartInfo;

    @FindBy(css = ".control-group.attribute-row>div>div")
    public List<WebElement> secondPartInfo;



}
