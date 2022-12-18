package com.cydeo.step_definitions;

/*
In this class we will be able to pass pre & post conditions to each scenario and each step
 */

import com.cydeo.utilities.BrowserUtilities;
import com.cydeo.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class _0_Hooks {
    @Before (order = 0) //import from cucumber
    public void setupScenario(){
        System.out.println("====Setting up browser using cucumber @Before");
    }

    //customizing @Before method
    //@Before (value = "@login", order = 1) //import from cucumber
    //this @Before is going to be running right before my scenarios that only have the tag that I provided here
    public void setupScenarioForLogins(){
        System.out.println("====This will only apply to scenarios with @login tag");
    }

    //customizing @Before method
    //@Before (value = "@db", order = -1) //import from cucumber
    //this @Before is going to be running right before my scenarios that only have the tag that I provided here
    public void setupForDataBaseScenarios(){
        System.out.println("====This will only apply to scenarios with @db tag");
    }

    @After //import from cucumber
    public void tearDownScenario(Scenario scenario){

        //if scenario fails, it takes screenshot
        if (scenario.isFailed()){
            byte[] screenshot = ( (TakesScreenshot)Driver.getDriver() ).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        //for closing the browser
        //BrowserUtilities.sleep(3);
        Driver.closeDriver();

    }

    //@BeforeStep
    public void setupStep(){
        System.out.println("-----------> applying setup using @BeforeStep");
    }

    //@AfterStep
    public void afterStep(){
        System.out.println("-----------> applying tearDown using @AfterStep");
    }

}
