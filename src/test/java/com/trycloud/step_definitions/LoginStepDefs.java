package com.trycloud.step_definitions;


import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LoginStepDefs {


    @Given("the user on the login page")
    public void the_user_on_the_login_page() {

        System.out.println("Login to app in Before method");
    }


    @Given("user use username as {string} and passcode {string}")
    public void user_use_username_as_and_passcode(String username, String password) {
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);
    }


    @Given("user click the login button")
    public void user_click_the_login_button() {
        new LoginPage().submit.click();
    }

    @Then("verify the user should be at the dashboard page")
    public void verify_the_user_should_be_at_the_dashboard_page() {
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().contains("dashboard"));

    }

    @Then("verify {string} message should be displayed")
    public void verify_message_should_be_displayed(String expectedMessage) {
        Assert.assertEquals(expectedMessage, new LoginPage().wrongUsernamePassword.getText());
    }

    @Given("the users  log in with valid credentials")
    public void the_users_log_in_with_valid_credentials() {
       new LoginPage().login();
    }
}
