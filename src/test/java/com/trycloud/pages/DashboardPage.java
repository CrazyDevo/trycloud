package com.trycloud.pages;

import com.trycloud.utilities.BrowserUtils;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DashboardPage extends BasePage{


    public List<String> getMenuTexts(){
        List<String> menuTexts=new ArrayList<>();
        for (WebElement menuOption : menuOptions) {
            BrowserUtils.hover(menuOption);
           menuTexts.add(menuOption.getText());

        }
        return menuTexts;
    }
}
