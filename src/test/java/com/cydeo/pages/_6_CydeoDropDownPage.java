package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class _6_CydeoDropDownPage {

    public _6_CydeoDropDownPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


    @FindBy(id = "month")
    public WebElement monthDropdown;







}
