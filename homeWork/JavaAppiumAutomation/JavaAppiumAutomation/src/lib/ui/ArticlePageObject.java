package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

abstract public class ArticlePageObject extends  MainPageObject
{
    private static String name_of_folder = "Learning programming";
    protected static String
    TITLE,
    FOOTER_ELEMENT,
    SAVE_BUTTON,

    CANCEL_BUTTON,
    PAGE_SAVE_BUTTON,
    NAME_OF_FOLDER,
    SAVE_ADD_TO_MY_LIST_BUTTON,
    MY_LIST_NAME_INPUT,
    MY_LIST_OK_BUTTON,
    CLOSE_ARTICLE_BUTTON,
    SNACKBAR_VIEW_LIST_BUTTON;

    public ArticlePageObject(AppiumDriver driver)
    {
        super(driver);
    }

    public WebElement waitForTitleElement()
    {
       return  this.waitForElementPresent(TITLE, "Cannot find article title on page", 40 );
    }

    public String getArticleTitle()
    {
        WebElement title_element = waitForTitleElement();
        if (Platform.getInstance().isAndroid()){
            return title_element.getAttribute("text");
        } else {
            return  title_element.getAttribute("name");
        }

    }

    public void swipeToFooter()
    {
        if (Platform.getInstance().isAndroid()){
            this.swipeUpToFindElement(
                    FOOTER_ELEMENT,
                    "Cannot find the end of article",
                    40);
        } else {
            this.swipeUpTitleElementAppear(FOOTER_ELEMENT,
                    "Cannot find the end of article",
                     40);
        }
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
        if (Platform.getInstance().isAndroid()) {
            this.waitForElementAndClick(
                    CLOSE_ARTICLE_BUTTON,
                    "Cannot close article, cannot click back button",
                    5);
        } else {
            this.waitForElementAndClick(
                    CLOSE_ARTICLE_BUTTON,
                    "Cannot close article, cannot click back button",
                    5);
            this.waitForElementAndClick(
                    CANCEL_BUTTON,
                    "Cannot close article, cannot click CANCEL button",
                    10);
        }
    }

    public void addArticlesToMySaved()
    {
        this.waitForElementAndClick(SAVE_BUTTON, "Cannot find SAVE button", 10);
    }
}
