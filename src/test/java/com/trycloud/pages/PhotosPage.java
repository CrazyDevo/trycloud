package com.trycloud.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PhotosPage extends BasePage{

    @FindBy(xpath = "//ul[@class='app-navigation__list']/li//span")
    public List<WebElement> photosSubModules;
}
