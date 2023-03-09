package com.trycloud.step_definitions;

import com.trycloud.pages.PhotosPage;
import com.trycloud.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class PhotosPageStepDefs {

    PhotosPage photosPage=new PhotosPage();

    @Then("verify there are following sub-modules")
    public void verify_there_are_following_sub_modules(List<String> expectedSubModules) {
   List<String> actualSubModules=BrowserUtils.getElementsText(photosPage.photosSubModules);
        Assert.assertEquals(expectedSubModules,actualSubModules);
    }

}
