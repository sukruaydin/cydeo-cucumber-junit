package com.cydeo.step_definitions;

import com.cydeo.pages._6_CydeoDropDownPage;
import com.cydeo.utilities.BrowserUtilities;
import com.cydeo.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import java.util.List;

public class _6_CydeoDropdown_StepDefinitions {

    _6_CydeoDropDownPage cydeoDropDownPage = new _6_CydeoDropDownPage();

    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {
        Driver.getDriver().get("https://practice.cydeo.com/dropdown");
    }
    @Then("User should see below info in moth dropdown")
    public void user_should_see_below_info_in_moth_dropdown(List<String> expectedMonths) {
        /**
         * THIS IS THE FIRST WAY
         * THEN WE CREATED A NEW UTILITY METHOD NAMED dropdownOptionsAsString
         *
         * using Select class to handle dropdowns
         *         Select select = new Select(cydeoDropDownPage.monthDropdown);
         *         List<WebElement> allMonths = select.getOptions();
         *
         *         //iterating for getting the texts
         *         List<String> actualMonths = new ArrayList<>();
         *         for (WebElement each : allMonths) {
         *             actualMonths.add(each.getText());
         *         }
         */

        List<String> actualMonths = BrowserUtilities.dropdownOptionsAsString(cydeoDropDownPage.monthDropdown);

        System.out.println("expectedMonths = " + expectedMonths);
        System.out.println("actualMonths = " + actualMonths);

        Assert.assertEquals(expectedMonths, actualMonths);
        //Assert will check the size of the lists first. If sizes are matching it will check the content one by one

    }

}
