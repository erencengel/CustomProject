package com.application.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AllCalendarEventsPage extends BasePage {

    @FindBy(xpath = "//div[@class='btn btn-link dropdown-toggle' and @data-toggle='dropdown' ]")
    public WebElement optionButton;

    @FindBy(css = "input[type='number']")
    public WebElement pageNumber;

    @FindBy(xpath = "(//div[@class='btn-group'])[2]")
    public WebElement perPageNumber;

    @FindBy(css = ".grid-row")
    public List<WebElement> rows;

    @FindBy(xpath = "//i[@class='fa-chevron-right hide-text']")
    public WebElement nextClickButton;

    @FindBy (xpath = "(//label [@class='dib'])[2]")
    public WebElement number;

    @FindBy(css = ".btn.btn-default.btn-small.dropdown-toggle>input")
    public WebElement titleClick;

    @FindBy(css = "input[tabindex='-1']")
    public List<WebElement> clickedButton;

    @FindBy(css = ".fa-bars")
    public WebElement optionsButton;

    @FindBy(xpath = "(//a[contains(text(),'Testers meeting')])[1]")
    public WebElement relatedButton;
}
