package com.cydeo.step_definitions;

import com.cydeo.pages._1_GoogleSearchPage;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;

import java.security.Key;

public class _1_Google_StepDefinitions {

    _1_GoogleSearchPage googleSearchPage = new _1_GoogleSearchPage();

    //SCENARIO_1
    @When("user is on Google search page")
    public void user_is_on_google_search_page() {

        Driver.getDriver().get("https://google.com");

    }
    @Then("user should see title is Google")
    public void user_should_see_title_is_google() {

        String expectedTitle = "Google";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);

    }

    //SCENARIO_2
    @When("user types apple and clicks enter")
    public void user_types_and_clicks_enter2() {
        googleSearchPage.searchBox.sendKeys("apple" + Keys.ENTER);
    }
    @Then("user sees apple in the google title")
    public void user_sees_apple_in_the_google_title() {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "apple - Google'da Ara";
        Assert.assertEquals("title is not as expected", expectedTitle, actualTitle);
    }

    //SCENARIO_3
    @When("user types {string} and clicks enter")
    public void user_types_and_clicks_enter(String string) {
        googleSearchPage.searchBox.sendKeys(string+ Keys.ENTER);
    }
    @Then("user sees {string} in the google title")
    public void user_sees_in_the_google_title(String string) {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = string + " - Google'da Ara";
        Assert.assertEquals("Title is not as expected!",expectedTitle, actualTitle);
    }






}
