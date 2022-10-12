package com.cydeo.pages;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class _5_WebTableLoginPage {

    public  _5_WebTableLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@name='username']")
    public WebElement inputUsername;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement inputPassword;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement loginButton;

    /**
     * no parameters
     * when we call this method, it will directly login using -->
     *
     * username : test
     * password : tester
     */
    public void login(){
        inputUsername.sendKeys("Test");
        inputPassword.sendKeys("Tester");
        loginButton.click();
    }

    /**
     * this will accept 2 parameters and login
     * will take those 2 parameters from feature file
     * @param username
     * @param password
     */
    public void login(String username, String password){
        inputUsername.sendKeys(username);
        inputPassword.sendKeys(password);
        loginButton.click();
    }

    /**
     * this will login using credentials from configuration.properties
     */
    public void loginWithConfig(){
        inputUsername.sendKeys(ConfigurationReader.getProperty("webTableUsername"));
        inputPassword.sendKeys(ConfigurationReader.getProperty("webTablePassword"));
        loginButton.click();
    }




}
