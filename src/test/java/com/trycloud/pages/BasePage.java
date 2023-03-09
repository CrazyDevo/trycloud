package com.trycloud.pages;

import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {

    @FindBy(xpath = "//ul[@id='appmenu']/li[@id='more-apps']/preceding-sibling::li")
    public List<WebElement> menuOptions;


    @FindBy(xpath = "//span[@aria-label='Magnify icon']//*[name()='svg']")
    public WebElement searchIcon;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement txtSearch;


    @FindBy(xpath = "//div[@id='header-menu-unified-search']//ul/li//span//strong")
    public WebElement foundItem;



    public BasePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    public void clickOption(String option){
        for (WebElement menuOption : menuOptions) {
            BrowserUtils.hover(menuOption);
            if (menuOption.getText().equals(option)){
                menuOption.click();
                break;
            }

        }
    }


}
