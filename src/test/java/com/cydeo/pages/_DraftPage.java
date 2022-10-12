package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class _DraftPage {

    public _DraftPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(name = "q")
    public WebElement googleSearchBox;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement googleSearchButton;






}
