package com.trycloud.pages;

import com.trycloud.utilities.BrowserUtils;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class FilesPage extends BasePage {


    @FindBy(xpath = "//label[@for='select_all_files']")
    public WebElement selectAllFiles;

    @FindBy(xpath = "//input[contains(@id,'select-files')]")
    public List<WebElement> checkBoxesForFiles;

    @FindBy(xpath = "//span[@class='fileactions']/a[2]")
    public List<WebElement> actionListForFiles;


    @FindBy(xpath = "//div[@id='app-content-favorites']//table//tbody//span[@class='fileactions']/a[2]")
    public List<WebElement> actionListForFavoriteFiles;


    @FindBy(xpath = "//span[@class='fileactions']/..")
    public List<WebElement> listOfFiles;


    @FindBy(xpath = "(//table[@id='filestable'])[3]//tbody/tr/td[1]")
    public List<WebElement> favoriteFiles;

    @FindBy(xpath = "//a[@class='button new']")
    public WebElement addFile;


    @FindBy(xpath = "//input[@id='file_upload_start']")
    public WebElement fileUpload;

    @FindBy(xpath = "//table[@id='filestable']//tbody[@id='fileList']/tr/td[2]/a/span/span[1]")
    public List<WebElement> listOfUploadedFiles;

    @FindBy(xpath = "//input[@value='New folder']")
    public WebElement folderName;

    @FindBy(xpath = "(//input[@type='submit'])[2]")
    public WebElement buttonFolderCreate;

    @FindBy(xpath = "//form[@class='newCommentForm']/div")
    public WebElement textNewComment;

    @FindBy(xpath = "//form[@class='newCommentForm']/input")
    public WebElement btnSubmitComment;

    @FindBy(xpath = "//ul[@class='comments']/li/div[2]")
    public List<WebElement> listOfComments;


    @FindBy(xpath = "//div[@id='app-settings-header']/button")
    public WebElement buttonSettings;


    @FindBy(xpath = "//div[@id='app-settings-content']//input[@type='checkbox']/../label")
    public List<WebElement> listOfCheckbox;

    @FindBy(xpath = "//div[@id='app-settings-content']//input[@type='checkbox']")
    public List<WebElement> listOfCheckbox1;




    public void chooseDetail(String detailOption) {
        String locator = "//div[@class='app-sidebar-tabs']//ul/li//a[contains(.,'" + detailOption + "')]";
        Driver.getDriver().findElement(By.xpath(locator)).click();
    }

    public void upload(String option) {
        if (option.equals("Upload file")) {
            System.out.println(System.getProperty("user.dir"));
            fileUpload.sendKeys(System.getProperty("user.dir") + "/src/test/resources/files/fileUpload.png");
        } else if (option.equals("New folder")) {
            String locator = "//a[.='" + option + "']";
            WebElement element = Driver.getDriver().findElement(By.xpath(locator));
            BrowserUtils.hover(element);
            element.click();
        }

    }

    public void actionForSpecificFile(String fileName) {
        String locator = "//span[@class='fileactions']/../span[1]/span[contains(.,'" + fileName + "')]/../../span[@class='fileactions']/a[2]";
        WebElement element = Driver.getDriver().findElement(By.xpath(locator));
        BrowserUtils.hover(element);
        element.click();
    }


    public void chooseActionForFile(String action) {
        //we can create a specific method for special files if we need
        BrowserUtils.waitFor(2);
        String locator = "//div[contains(@class,'fileActionsMenu')]//a[contains(.,'" + action + "')]";
        WebElement element = Driver.getDriver().findElement(By.xpath(locator));
        BrowserUtils.hover(element);
        element.click();
    }

    public void chooseActionForFavoriteFile(String action) {
        //we can create a specific method for special files if we need
        BrowserUtils.waitFor(2);
        String locator =
                "//div[contains(@class,'fileActionsMenu popovermenu bubble open menu')]//a[contains(., '" + action + "')]";
        WebElement element = Driver.getDriver().findElement(By.xpath(locator));
        BrowserUtils.hover(element);
        element.click();
    }

    public void selectOptionFromLeftSide(String option) {
        String locator = "//div[@id='app-navigation']//li[contains(.,'" + option + "')]";
        Driver.getDriver().findElement(By.xpath(locator)).click();
    }
}
