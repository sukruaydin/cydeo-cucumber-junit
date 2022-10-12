package com.cydeo.step_definitions;

import com.cydeo.pages._5_WebTableLoginPage;
import com.cydeo.utilities.BrowserUtilities;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import org.junit.Assert;

import java.util.Map;

public class _5_WebTableLogin_StepDefinitions {

    _5_WebTableLoginPage webTableLoginPage = new _5_WebTableLoginPage();

    //SCENARIO_1
    @Given("User is on the login page of web table app")
    public void user_is_on_the_login_page_of_web_table_app() {
        Driver.getDriver().get(ConfigurationReader.getProperty("webTableUrl"));
    }
    @When("User enters {string} in username input box")
    public void user_enters_in_username_input_box(String string) {
        webTableLoginPage.inputUsername.sendKeys(string);
    }
    @When("User enters {string} in password input box")
    public void user_enters_in_password_input_box(String string) {
        webTableLoginPage.inputPassword.sendKeys(string);
    }
    @When("User clicks to login button")
    public void user_clicks_to_login_button() {
        webTableLoginPage.loginButton.click();
    }
    @Then("User should see url contains orders")
    public void user_should_see_url_contains_orders() {
        BrowserUtilities.verifyURLContains("orders");
    }


    //SCENARIO_2
    @When("User enters username {string} password {string} and logins")
    public void user_enters_username_password_and_logins(String string, String string2) {
        webTableLoginPage.login(string,string2);
    }

    //SCENARIO_3
    @When("User enters below credentials")
    public void user_enters_below_credentials(Map<String,String> credentials) {
        String username = credentials.get("username");
        String password = credentials.get("password");

        webTableLoginPage.login(username,password);
    }


}
