package com.trycloud.step_definitions;

import com.trycloud.pages.DashboardPage;
import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FilesPageStepDefs {

    FilesPage filesPage = new FilesPage();
    String expectedFile;


    @When("user click the top-left checkbox of the table")
    public void user_click_the_top_left_checkbox_of_the_table() {
        filesPage.selectAllFiles.click();
    }

    @Then("verify all the files are selected")
    public void verify_all_the_files_are_selected() {
        for (WebElement checkBoxesForFile : filesPage.checkBoxesForFiles) {
            Assert.assertTrue(checkBoxesForFile.isSelected());
        }
    }

    @When("the user clicks action-icon  from any file on the page")
    public void the_user_clicks_action_icon_from_any_file_on_the_page() {
        expectedFile = filesPage.listOfFiles.get(0).getText();
        System.out.println(expectedFile);
        filesPage.actionListForFiles.get(0).click();

    }

    @When("the user clicks action-icon  from {string} file on the page")
    public void the_user_clicks_action_icon_from_file_on_the_page(String fileName) {
      filesPage.actionForSpecificFile(fileName);

    }

    @When("user choose the {string} option")
    public void user_choose_the_option(String action) {
        filesPage.chooseActionForFile(action);
    }

    @When("user click the {string} sub-module on the left side")
    public void user_click_the_sub_module_on_the_left_side(String option) {
        filesPage.selectOptionFromLeftSide(option);
    }

    @Then("Verify the chosen file is listed on the table")
    public void verify_the_chosen_file_is_listed_on_the_table() {
        Assert.assertTrue(BrowserUtils.getElementsText(filesPage.favoriteFiles).contains(expectedFile));

    }

    @When("the user {word} the files from Favorites")
    public void the_user_remove_the_files_from_favorites(String action) {
        filesPage.actionListForFavoriteFiles.get(0).click();
        filesPage.chooseActionForFavoriteFile(action);
    }

    @Then("Verify that the file is not listed in the Favorites table")
    public void verify_that_the_file_is_not_listed_in_the_Favorites_table() {
        Driver.getDriver().navigate().refresh();
        Assert.assertTrue(!BrowserUtils.getElementsText(filesPage.favoriteFiles).contains(expectedFile));

    }

    @When("the user clicks the add icon on the top")
    public void the_user_clicks_the_add_icon_on_the_top() {
        filesPage.addFile.click();
    }

    @When("users uploads file with the {string} option")
    public void users_uploads_file_with_the_option(String option) {
        filesPage.upload(option);
        BrowserUtils.waitFor(10);
    }

    @Then("verify the file is displayed on the page")
    public void verify_the_file_is_displayed_on_the_page() {
        Driver.getDriver().navigate().refresh();
        List<String> elementsText = BrowserUtils.getElementsText(filesPage.listOfFiles);
        System.out.println(elementsText);
        boolean flag=false;
        for (String s : elementsText) {
            if (s.contains("fileUpload")){
                flag=true;
                break;
            }



        }
        Assert.assertTrue(flag);
    }

    @Then("verify the file is not displayed on the page")
    public void verify_the_file_is_not_displayed_on_the_page() {
        Driver.getDriver().navigate().refresh();
        List<String> elementsText = BrowserUtils.getElementsText(filesPage.listOfFiles);
        System.out.println(elementsText);
        boolean flag=false;
        for (String s : elementsText) {
            if (!s.contains("fileUpload")){
                flag=true;
                break;
            }



        }
        Assert.assertTrue(flag);
    }

    @When("user write a folder name")
    public void user_write_a_folder_name() {
       filesPage.folderName.sendKeys("test");
    }
    @When("the user click submit icon")
    public void the_user_click_submit_icon() {
        filesPage.buttonFolderCreate.click();
    }
    @Then("Verify the folder is displayed on the page")
    public void verify_the_folder_is_displayed_on_the_page() {
        Driver.getDriver().navigate().refresh();
        List<String> elementsText = BrowserUtils.getElementsText(filesPage.listOfFiles);
        System.out.println(elementsText);
        boolean flag=false;
        for (String s : elementsText) {
            if (s.contains("test")){
                flag=true;
                break;
            }



        }
        Assert.assertTrue(flag);
    }

    @Then("Verify the folder is not displayed on the page")
    public void verify_the_folder_is_not_displayed_on_the_page() {
        Driver.getDriver().navigate().refresh();
        List<String> elementsText = BrowserUtils.getElementsText(filesPage.listOfFiles);
        System.out.println(elementsText);
        boolean flag=false;
        for (String s : elementsText) {
            if (!s.contains("test")){
                flag=true;
                break;
            }



        }
        Assert.assertTrue(flag);
    }


    @When("user clicks the {string} option")
    public void user_clicks_the_option(String option) {
        filesPage.chooseDetail(option);
    }
    String expectedComment;
    @When("user write a comment as {string} inside the input box")
    public void user_write_a_comment_inside_the_input_box(String comment) {
        expectedComment=comment;
       filesPage.textNewComment.sendKeys(comment);
    }
    @When("user click the submit button to post it")
    public void user_click_the_submit_button_to_post_it() {
       filesPage.btnSubmitComment.click();
    }
    @Then("Verify the comment is displayed in the comment section")
    public void verify_the_comment_is_displayed_in_the_comment_section() {
        Assert.assertEquals(expectedComment,filesPage.listOfComments.get(0).getText());

    }

    @When("user clicks Settings on the left bottom corner")
    public void user_clicks_settings_on_the_left_bottom_corner() {
       filesPage.buttonSettings.click();
    }
    @Then("the user should be able to click any checkbox")
    public void the_user_should_be_able_to_click_any_checkbox() {
        BrowserUtils.waitFor(3);
        List<WebElement> listOfCheckbox1 = filesPage.listOfCheckbox1;

        int i =0;

        for (WebElement checkbox : filesPage.listOfCheckbox) {
            boolean selected = listOfCheckbox1.get(i).isSelected();
            System.out.println(selected);
            checkbox.click();
            boolean selected1 = listOfCheckbox1.get(i).isSelected();
            System.out.println("selected1 = " + selected1);
            i++;
            Assert.assertTrue(selected1!=selected);
        }
    }




}
