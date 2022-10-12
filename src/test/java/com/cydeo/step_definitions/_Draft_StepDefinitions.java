package com.cydeo.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.util.List;

public class _Draft_StepDefinitions {


    @Then("User sees favorite {string}")
    public void user_sees_favorite(String string) {
        System.out.println("string = " + string);

    }
    @Then("User eats favorite fruits")
    public void user_eats_favorite_fruits(List<String> fruits) {
        System.out.println("fruits = " + fruits);
    }


    @Given("{string} opens the app")
    public void opens_the_app(String string) {
        System.out.println("string = " + string);
    }

    @Given("{string} opens the apps")
    public void opens_the_apps(String string) {
        System.out.println("string = " + string);
    }




}
