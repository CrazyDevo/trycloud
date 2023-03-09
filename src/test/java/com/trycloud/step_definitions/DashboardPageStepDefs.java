package com.trycloud.step_definitions;

import com.trycloud.pages.DashboardPage;
import com.trycloud.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class DashboardPageStepDefs {

    String expected;
    DashboardPage dashboardPage=new DashboardPage();

    @Then("Verify the user see the following modules:")
    public void verify_the_user_see_the_following_modules(List<String> expectedModules) {

        Assert.assertEquals(expectedModules,new DashboardPage().getMenuTexts());
    }

    @When("the user clicks the {string} module")
    public void the_user_clicks_the_module(String moduleName) {
     new DashboardPage().clickOption(moduleName);

    }

    @When("the user clicks the magnifier icon on the right top")
    public void the_user_clicks_the_magnifier_icon_on_the_right_top() {
        dashboardPage.searchIcon.click();
    }
    @When("users search any existing files-folder-users {string} name")
    public void users_search_any_existing_files_folder_users_name(String searched) {
        expected =searched;
        dashboardPage.txtSearch.sendKeys(searched);
    }
    @Then("verify the app displays the expected result option")
    public void verify_the_app_displays_the_expected_result_option() {
        Assert.assertTrue(dashboardPage.foundItem.getText().contains(expected));

    }

}
