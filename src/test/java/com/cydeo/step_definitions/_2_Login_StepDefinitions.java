package com.cydeo.step_definitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class _2_Login_StepDefinitions {

    //basically order is not important
    //the code is going to be executed by login.feature file

    //SCENARIO_1
    @Given("user is on the library login page")
    public void user_is_on_the_library_login_page() {
        System.out.println("User is on the library login page");
    }
    @When("user enters librarian username")
    public void user_enters_librarian_username() {
        System.out.println("User enters librarian username");
    }
    @When("user enters librarian password")
    public void user_enters_librarian_password() {
        System.out.println("User enters librarian password");
    }
    @Then("user should see the dashboard")
    public void user_should_see_the_dashboard() {
        System.out.println("User should see the dashboard");
    }


    //SCENARIO_2
    @When("user enters student username")
    public void user_enters_student_username() {
        System.out.println("User enters student username");
    }
    @When("user enters student password")
    public void user_enters_student_password() {
        System.out.println("User enters student password");
    }


    //SCENARIO_3
    @When("user enters admin username")
    public void user_enters_admin_username() {
        System.out.println("User enters admin username");
    }
    @When("user enters admin password")
    public void user_enters_admin_password() {
        System.out.println("User enters admin password");
    }


}
