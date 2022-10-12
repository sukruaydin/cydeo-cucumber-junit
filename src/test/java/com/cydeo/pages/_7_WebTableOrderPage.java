package com.cydeo.pages;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class _7_WebTableOrderPage {

    public _7_WebTableOrderPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(xpath = "//select[@name='product']")
    public WebElement dropdownProduct;

    @FindBy(xpath = "//input[@name='quantity']")
    public WebElement inputQuantity;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement inputCustomerName;

    @FindBy(xpath = "//input[@name='street']")
    public WebElement inputStreet;

    @FindBy(xpath = "//input[@name='city']")
    public WebElement inputCity;

    @FindBy(xpath = "//input[@name='state']")
    public WebElement inputState;

    @FindBy(xpath = "//input[@name='zip']")
    public WebElement inputZip;

    @FindBy(xpath = "//input[@value='American Express']")
    public WebElement radioButtonAmericanExpress;

    @FindBy(xpath = "//input[@value='MasterCard']")
    public WebElement radioButtonMasterCard;

    @FindBy(xpath = "//input[@value='Visa']")
    public WebElement radioButtonVisa;

    @FindBy(xpath = "//input[@name='cardNo']")
    public WebElement inputCardNo;

    @FindBy(xpath = "//input[@name='cardExp']")
    public WebElement inputCarExpiryDate;

    @FindBy(xpath = "//button[.='Process Order']")
    public WebElement buttonProcessOrder;












}
