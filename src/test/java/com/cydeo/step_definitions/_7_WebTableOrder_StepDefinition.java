package com.cydeo.step_definitions;

import com.cydeo.pages._0_PageBase;
import com.cydeo.pages._5_WebTableLoginPage;
import com.cydeo.pages._7_1_WebTableViewAllOrdersPage;
import com.cydeo.pages._7_WebTableOrderPage;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _7_WebTableOrder_StepDefinition {


    _5_WebTableLoginPage webTableLoginPage = new _5_WebTableLoginPage();
    _0_PageBase pageBase = new _0_PageBase();
    _7_WebTableOrderPage webTableOrderPage = new _7_WebTableOrderPage();
    _7_1_WebTableViewAllOrdersPage viewAllOrdersPage = new _7_1_WebTableViewAllOrdersPage();


    @Given("user is already logged in and on order page")
    public void user_is_already_logged_in_and_on_order_page() {
        //getting the url from configuration reader
        Driver.getDriver().get(ConfigurationReader.getProperty("webTableUrl"));

        //reaching login() method which is without parameters
        //it logs is username:Test , password:Tester
        webTableLoginPage.login();

        //clicking Order button
        pageBase.ordersButton.click();
    }
    @When("user selects product type {string}")
    public void user_selects_product_type(String string) {
        Select select = new Select(webTableOrderPage.dropdownProduct);
        select.selectByVisibleText(string);
    }
    @When("user enters quantity {int}")
    public void user_enters_quantity(Integer int1) {
        //first we need to clear inside the box
        //first-way to delete
        webTableOrderPage.inputQuantity.clear();

        //second-way to delete
        //webTableOrderPage.inputQuantity.sendKeys(Keys.BACK_SPACE);

        //webTableOrderPage.inputQuantity.sendKeys(int1+"");
        webTableOrderPage.inputQuantity.sendKeys(String.valueOf(int1));
    }
    @When("user enters customer name {string}")
    public void user_enters_customer_name(String string) {
        webTableOrderPage.inputCustomerName.sendKeys(string);
    }
    @When("user enters street {string}")
    public void user_enters_street(String string) {
        webTableOrderPage.inputStreet.sendKeys(string);
    }
    @When("user enters city {string}")
    public void user_enters_city(String string) {
        webTableOrderPage.inputCity.sendKeys(string);
    }
    @When("user enters state {string}")
    public void user_enters_state(String string) {
        webTableOrderPage.inputState.sendKeys(string);
    }
    @When("user enters zipcode {string}")
    public void user_enters_zipcode(String string) {
        webTableOrderPage.inputZip.sendKeys(string);
    }
    @When("user selects credit card type {string}")
    public void user_selects_credit_card_type(String cardType) {
        List<WebElement> radioButtons = new ArrayList<>();
        radioButtons.addAll(Arrays.asList(webTableOrderPage.radioButtonVisa,
                webTableOrderPage.radioButtonMasterCard, webTableOrderPage.radioButtonAmericanExpress));

        for (WebElement radioButton : radioButtons) {
            if (radioButton.getAttribute("value").equalsIgnoreCase(cardType)){
                radioButton.click();
                return;
            }
        }

        //after here, we created a brand-new utility method in BrowserUtilities named clickRadioButton
        //but i am not going to change my codes, since I did it myself :)

    }
    @When("user enters credit card number {string}")
    public void user_enters_credit_card_number(String string) {
        webTableOrderPage.inputCardNo.sendKeys(string);
    }
    @When("user enters expiry date {string}")
    public void user_enters_expiry_date(String string) {
        webTableOrderPage.inputCarExpiryDate.sendKeys(string);
    }
    @When("user enters process order button")
    public void user_enters_process_order_button() {
        webTableOrderPage.buttonProcessOrder.click();
    }
    @Then("user should see {string} in first row of the web table")
    public void user_should_see_in_first_row_of_the_web_table(String expectedName) {
        String actualName = viewAllOrdersPage.firstCellInTable.getText();
        Assert.assertEquals(expectedName, actualName);
    }




}
