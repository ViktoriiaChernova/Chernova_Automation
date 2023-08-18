package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ArticlePageObject extends  MainPageObject
{
    private static String name_of_folder = "Learning programming";
    private static final String
    TITLE = "xpath://*[@resource-id='pcs-edit-section-title-description']",
    FOOTER_ELEMENT = "xpath://*[@text='View article in browser']",
    SAVE_BUTTON = "xpath://android.widget.TextView[@content-desc='Save']",
    PAGE_SAVE_BUTTON = "xpath://*[@resource-id='org.wikipedia:id/page_save']",

    NAME_OF_FOLDER = "xpath://*[@text='" + name_of_folder + "']",
    SAVE_ADD_TO_MY_LIST_BUTTON = "xpath://android.widget.Button[@text='ADD TO LIST']",
    MY_LIST_NAME_INPUT = "id:org.wikipedia:id/text_input",
    MY_LIST_OK_BUTTON = "xpath://*[@text='OK']",
    CLOSE_ARTICLE_BUTTON ="xpath://android.widget.ImageButton[@content-desc='Navigate up']",
    SNACKBAR_VIEW_LIST_BUTTON = "xpath://*[@resource-id='org.wikipedia:id/snackbar_action'][@text='VIEW LIST']";



    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public WebElement waitForTitleElement()
    {
       return  this.waitForElementPresent(TITLE, "Cannot find article title on page", 15 );
    }

    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        return title_element.getAttribute("text");
    }

    public void swipeToFooter()
    {
        this.swipeUpToFindElement(
                FOOTER_ELEMENT,
                "Cannot find the end of article",
                20
        );
    }

    public void addArticleToMyList(String name_of_folder)
    {
        this.waitForElementAndClick(
                SAVE_BUTTON,
                "Cannot find button 'Save'",
                5
        );

        this.waitForElementAndClick(
                SAVE_ADD_TO_MY_LIST_BUTTON,
                "Cannot find button 'ADD TO LIST'",
                5
        );

        this.waitForElementAndSendKeys(
                MY_LIST_NAME_INPUT,
                name_of_folder,
                "Cannot put text into articles folder input",
                5
        );

        this.waitForElementAndClick(
                MY_LIST_OK_BUTTON,
                "Cannot find button 'OK'",
                5
        );
    }

    public void addArticleToExistingList(String name_of_folder) {

        this.waitForElementPresent(
                PAGE_SAVE_BUTTON,
                "Cannot find button 'Save'",
                10
        );
        this.waitForElementAndClick(
                SAVE_BUTTON,
                "Cannot find button 'Save'",
                5
        );

        this.waitForElementAndClick(
                SAVE_ADD_TO_MY_LIST_BUTTON,
                "Cannot find button 'ADD TO LIST'",
                5
        );

        this.waitForElementAndClick(
                NAME_OF_FOLDER,
                "Cannot find saved list",
                5
        );

        this.waitForElementAndClick(
                SNACKBAR_VIEW_LIST_BUTTON,
                "Cannot find saved list",
                5
        );
    }

    public void closeArticle()
    {
        this.waitForElementAndClick(
                CLOSE_ARTICLE_BUTTON,
                "Cannot close article, cannot click back button",
                5
        );
    }
}
