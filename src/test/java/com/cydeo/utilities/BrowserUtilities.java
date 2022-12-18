package com.cydeo.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BrowserUtilities {

    //accepts int in seconds and executes Thread.sleep for given duration
    public static void sleep(int seconds){
        seconds *= 1000;
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //accepts 3 arguments, switches the window accordingly, and asserts the title if it is true
    public static void switchWindowAndVerify(String expectedInUrl, String expectedInTitle){
        for (String each : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(each);
            if (Driver.getDriver().getCurrentUrl().contains(expectedInUrl)){
                break;
            }
        }
        Assert.assertTrue(Driver.getDriver().getTitle().contains(expectedInTitle));

    }

    //accepts String expectedTitle and asserts if it is true
    public static void verifyTitle(String expectedTitle){
        String actualTitle = Driver.getDriver().getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    //calls explicitly wait with turning-off implicitly wait and returns WebDriverWait wait
    public static WebDriverWait explicitlyWait(){
        Driver.getDriver().manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        return wait;
    }

    /**
     * accepts a String expected value and verify actual URL CONTAINS the value
     * @param expectedInURL
     */
    public static void verifyURLContains(String expectedInURL){
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains(expectedInURL));
    }

    /**
     * accepts a dropdown WebElement
     * return all options' text as List<String>
     * @param dropdown
     * @return
     */
    public static List<String> dropdownOptionsAsString(WebElement dropdown){
        //using Select class to handle dropdowns
        Select select = new Select(dropdown);
        List<WebElement> allOptions = select.getOptions();

        //iterating for getting the texts
        List<String> texts = new ArrayList<>();
        for (WebElement each : allOptions) {
            texts.add(each.getText());
        }

        return texts;
    }


    /**
     * accepts 2 arguments, radioButtons as list of WebElements and attribute value
     * loops through the list and clicks the matching one
     * @param radioButtons
     * @param attributeValue
     */
    public static void clickRadioButton(List<WebElement> radioButtons, String attributeValue){
        for (WebElement radioButton : radioButtons) {
            if (radioButton.getAttribute("value").equalsIgnoreCase(attributeValue)){
                radioButton.click();
                return;
            }
        }
    }


}
