package com.trycloud.step_definitions;

import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class GeneralStepDefs {
    @Then("verify the page title is {string}")
    public void verify_the_page_title_is(String expectedTitle) {
        Assert.assertEquals(expectedTitle, Driver.getDriver().getTitle());
        //We can create a method in BrowserUtil for verifying title
    }
}
