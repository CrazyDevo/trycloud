package com.trycloud.pages;




import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath="//input[@id='user']")
    public WebElement userName;



    @FindBy(xpath="//input[@id='password']")
    public WebElement password;

    @FindBy(id = "submit-form")
    public WebElement submit;

    @FindBy(xpath = "//p[contains(@class, 'warning')]")
    public WebElement wrongUsernamePassword;


    public void login(String userNameStr, String passwordStr) {
        userName.sendKeys(userNameStr);
        password.sendKeys(passwordStr);
    }

    public void login() {
        userName.sendKeys(ConfigurationReader.getProperty("username"));
        password.sendKeys(ConfigurationReader.getProperty("password"));
        submit.click();
    }

}
