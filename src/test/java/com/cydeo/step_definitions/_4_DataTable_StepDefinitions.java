package com.cydeo.step_definitions;

import io.cucumber.java.en.Then;

import java.util.List;

public class _4_DataTable_StepDefinitions {

    @Then("User should see fruits i like")
    public void user_should_see_fruits_i_like(List<String> fruits) {
        System.out.println("fruits = " + fruits);
    }


}





